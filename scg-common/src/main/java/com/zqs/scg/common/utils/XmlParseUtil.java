package com.zqs.scg.common.utils;

import com.zqs.scg.common.model.XmlHeaderParam;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * 解析XML公用类:支持多重内部类解析 dom4j 支持
 *
 * @author huhaopeng
 */
public class XmlParseUtil {

    /**
     * JAVA Bean 转换 XML 字符串 Describe:
     *
     * @param obj       Object 传入 Body
     * @param header    Object 传入 Header
     * @param paramName String OTA区分标识 ( qunar, ectrip )
     * @author:huhaopeng
     * @注： header 需要传入 application, processor, createUser return:void
     * Date:2014-2-21
     */
    @SuppressWarnings({"finally", "deprecation"})
    public static String beanToXML(final Object obj, final Object header,
                                   String paramName) throws Exception {
        // 获取头信息
        XmlHeaderParam param = getXmlHeaderParam(paramName);

        // className:类全名
        String clsName = obj.getClass().getName();
        // 去掉类全名前面不需要的：例如 cn.xml.Context -> Context
        clsName = clsName.substring(clsName.lastIndexOf(".") + 1, clsName
                .length());

        // 根据类名生成root
        Document doc = DocumentHelper.createDocument();
        // doc.addComment("Sample XML file generated by XMLSpy v2013 (http://www.altova.com)");
        // 添加根节点：
        Element root = null;
        if (clsName.indexOf("Request") != -1) {
            root = doc.addElement("qm:request");
            root.addNamespace("qm", param.getNamespaceRequest());
            root.addAttribute("xsi:schemaLocation", param.getAttributeXsi());
            root.addAttribute("xmlns:xsi", param.getAttributeXmlns());
        } else if (clsName.indexOf("Response") != -1) {
            root = doc.addElement("qm:response");
            root.addNamespace("qm", param.getNamespaceResponse());
            root.addAttribute("xsi:schemaLocation", param.getAttributeXsi());
            root.addAttribute("xmlns:xsi", param.getAttributeXmlns());
        }

        // 添加Header
        Element head = root.addElement("qm:header");

        complexTypeRecursive(header, head);

        Element body = root.addElement("qm:body");

        body.setAttributeValue("xsi:type", "qm:" + clsName);
        // bean属性
        complexTypeRecursive(obj, body);

        // 生成xml:String
        XMLWriter xw;
        StringWriter sw = new StringWriter();
        OutputFormat opf;
        String result = null;
        try {
            opf = OutputFormat.createCompactFormat();
            opf.setEncoding("UTF-8");
            xw = new XMLWriter(sw);
            xw.write(doc);
            result = sw.toString();
            xw.close();
            sw.close();

        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }

    }

    /**
     * 递归: 获取 复杂类型 树结构方法。 Describe: objectToXML() use
     *
     * @param obj     : Object(此节点对应对象)
     * @param element : Element(此节点) return:void Date:2014-2-21
     * @author:huhaopeng
     */
    @SuppressWarnings("unchecked")
    public static void complexTypeRecursive(Object obj, Element element) {
        Class cls = obj.getClass();
        String objName = cls.getSimpleName();

        // getDeclaredFields:获取bean中所有属性
        Field[] fields = cls.getDeclaredFields();
        String fieldName = "";
        if ("String".equals(objName)) {
            element.setText(obj.toString());
        } else {
            for (Field f : fields) {
                f.setAccessible(true);
                fieldName = f.getName();

                try {

                    PropertyDescriptor pd = new PropertyDescriptor(fieldName, cls);
                    Method getMethod = pd.getReadMethod();// 获得get方法
                    // 当前对象：o
                    Object o = getMethod.invoke(obj);// 执行get方法返回一个Object

                    // 判断是否为list属性
                    if ((".List").equals(f.getType().toString().substring(
                            f.getType().toString().lastIndexOf(".")))) {
                        List list = (ArrayList) o;
                        for (Object ob : list) {
                            Element emt = element.addElement("qm:" + fieldName);
                            complexTypeRecursive(ob, emt);
                        }
                    } else {
                        Element emt = element.addElement("qm:" + fieldName);
                        // 判断下个节点是否需要：为null说明不用加入xml中
                        if (null != o) {
                            // 判断节点o是否为基础类型:if(基础类型)else(非基础类型)
                            if ("java".equals(o.getClass().getName()
                                    .substring(0, 4))) {
                                emt.setText(o.toString());
                            } else {
                                // 递归调用
                                complexTypeRecursive(o, emt);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Bean To Xml Exception : XMLParseUtil >> complexTypeRecursive() Throws！");
                }
            }
        }
    }

    /**
     * XML 转换 为 JACA BEAN Describe: bodyInfo 对应类中所有属性必须已经实例化，不能为NULL
     *
     * @param xml      String
     * @param bodyInfo Object
     * @return return:Map Date:2014-2-22
     * @author:huhaopeng
     */
    @SuppressWarnings("unchecked")
    public static Map xmlToBean(String xml, Object header, Object bodyInfo)
            throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        Document doc = null;

        try {
            // 读取并解析XML文档
            // SAXReader就是一个管道，用一个流的方式，把xml文件读出来
            // SAXReader reader = new SAXReader(); //User.hbm.xml表示你要解析的xml文档
            // Document document = reader.read(new File("User.hbm.xml"));
            // 下面的是通过解析xml字符串的
            doc = DocumentHelper.parseText(xml); // 将字符串转为XML

            Element root = doc.getRootElement(); // 获取根节点
            String rootName = root.getName();
            Iterator rootIter = root.elementIterator();
            // 获取根节点下的子节点head
            Iterator headerIter = ((Element) rootIter.next()).elementIterator();
            Iterator bodyIter = ((Element) rootIter.next()).elementIterator();

            // 判断header节点是否有值，遍历header节点

            // Header: 递归塞值
            complexTypeRecursiveXmlToBean(header, headerIter);

            map.put("header", header);// map.put("header", rqstHeader);

            // Body: 递归塞值
            complexTypeRecursiveXmlToBean(bodyInfo, bodyIter);

            map.put("body", bodyInfo);

            // 遍历body节点(以传入类结构遍历，用"java"字符串 来判定是否为复杂类型)
            // getDeclaredFields:获取为引用类型数
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("XMLParseUtil.java Error: URL - xmlToBean() throw out");
        }
        return map;
    }

    /**
     * 请求的  Header xml 转  bean
     * Describe:
     *
     * @param xml    Header xml字符串
     * @param header header格式
     * @return return:String
     * Date:2014-5-9
     * @author:huhaopeng
     */
    public static Object requestHeaderXmlTobean(String xml, Object header) {
        Document doc = null;

        try {
            doc = DocumentHelper.parseText(xml); // 将字符串转为XML

            Element root = doc.getRootElement(); // 获取根节点
            Iterator rootIter = root.elementIterator();
            // 获取根节点下的子节点head
            Iterator headerIter = ((Element) rootIter.next()).elementIterator();
            //Iterator bodyIter = ((Element) rootIter.next()).elementIterator();

            // Header: 递归塞值
            complexTypeRecursiveXmlToBean(header, headerIter);

            return header;

            // getDeclaredFields:获取为引用类型数
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("XMLParseUtil.java Error: URL - xmlToBean() throw out");
        }


        return null;
    }

    /**
     * 递归：将xml中对应结构的值塞入对象中 Describe:
     *
     * @param obj    Object 对象结构模型
     * @param iterss 获取的XML文件：body中的所有子节点 return:void Date:2014-2-22
     * @author:huhaopeng
     */
    @SuppressWarnings("unchecked")
    public static void complexTypeRecursiveXmlToBean(Object obj, Iterator iterss) {
        Class cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        String upName;

        // 获取(Iterator iterss)所有对象的值。
        List<Element> eList = new ArrayList<Element>();
        while (iterss.hasNext()) {
            Element e = (Element) iterss.next();
            eList.add(e);
        }

        for (Field field : fields) {
            field.setAccessible(true);
            // 当前 Node
            Element emt = null;
            // 判断obj此属性 在xml中是否存在（如果不是必须的，有可能不会传值.）
            boolean isContinue = true;
            for (Element e : eList) {
                if (e.getName().equals(field.getName())) {
                    isContinue = false;
                    emt = e;
                } else {

                }
            }
            if (isContinue == true) {
                continue;
            }// class

            String text = emt.getText();
            try {
                // PropertyDescriptor：用来连接 <类当前属性> <get>和<set>方法
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(),
                        cls);
                Method getMethod = pd.getReadMethod();// 获得get方法
                // 当前对象：o
                Object o = getMethod.invoke(obj);// 执行get方法返回一个Object
                // 判断是否为list属性
                if ((".List").equals(field.getType().toString().substring(
                        field.getType().toString().lastIndexOf(".")))) {
                    List list = (ArrayList) o;

                    // 判断是否有对象：有就添加到list对象中
                    for (Element element : eList) {// while (iterss.hasNext())
                        // {//iterss 这时候 里面存的已经是
                        // List中的所有对象了

                        String classForName = field.getGenericType().toString()
                                .substring(
                                        field.getGenericType().toString()
                                                .indexOf("<") + 1,
                                        field.getGenericType().toString()
                                                .lastIndexOf(">"));
                        Object ob = Class.forName(classForName).newInstance();
                        // 将对象塞入list
                        list.add(ob);
                        // 获取节点下所有属性
                        Iterator ite = element.elementIterator();
                        // 给塞入list的对象赋值
                        complexTypeRecursiveXmlToBean(ob, ite);
                    }
                } else {
                    upName = field.getName().substring(0, 1).toUpperCase()
                            + field.getName().substring(1);

                    if ("java".equals(o.getClass().getName().substring(0, 4))) {
                        // 基础类型：给对象塞值
                        obj.getClass().getMethod("set" + upName, String.class)
                                .invoke(obj, text);
                    } else {
                        // 复杂类型：递归
                        Iterator eIter = emt.elementIterator();
                        complexTypeRecursiveXmlToBean(o, eIter);
                    }
                }
            } catch (Exception e) {
                System.out.println("XMLParseUtil.java Error: URL - xmlToBean()-> complexTypeRecursiveXmlToBean() throw out");
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取xmlHeader参数
     * @param paramName
     * @return
     */
    public static XmlHeaderParam getXmlHeaderParam(String paramName){
        XmlHeaderParam headerParam = null;

        if("qunar".equals(paramName)){
            headerParam = new XmlHeaderParam(
                    "http://piao.qunar.com/2013/QMenpiaoRequestSchema",
                    "http://piao.qunar.com/2013/QMenpiaoResponseSchema",
                    "http://piao.qunar.com/2013/QMenpiaoRequestSchema QMRequestDataSchema-2.0.0.xsd",
                    "http://www.w3.org/2001/XMLSchema-instance");
        }else if("ectrip".equals(paramName)){
            headerParam = new XmlHeaderParam(
                    "http://tour.ectrip.com/2014/QMRequestDataSchema",
                    "http://tour.ectrip.com/2014/QMResponseSchema",
                    "http://tour.ectrip.com/2014/QMResponseSchema QMRequestDataSchema-1.1.0.xsd",
                    "http://www.w3.org/2001/XMLSchema-instance");
        }

        return  headerParam;
    }
}
