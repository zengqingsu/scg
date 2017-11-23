package com.zqs.scg.common.utils.poi;

import com.zqs.scg.common.errorcode.ErrorCode;
import com.zqs.scg.common.exception.BusinessException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangxuan on 2017/8/3.
 */
public class ExcelImporter {

    private final static String excel2003L = ".xls";
    private final static String excel2007U = ".xlsx";

    /**
     * 获取IO流中的数据，组装成List<List<Object>>对象
     * @param in
     * @param fileName
     * @return
     * @throws Exception
     */
    public static List<List<Object>> getListByExcel(InputStream in, String fileName) throws RuntimeException, IOException {

        List<List<Object>> list = null;


        // 创建Excel工作簿
        Workbook work = getWorkbook(in, fileName);
        if (null == work)
            throw new RuntimeException("创建Excel工作簿为空！");

        Sheet sheet = null;
        Row row = null;
        Cell cell = null;

        list = new ArrayList<>();
        // 遍历Excel中所有的Sheet
        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);
            if (sheet == null)
                continue;

            // 遍历当前sheet中所有行
            for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
                row = sheet.getRow(j);
                if (row == null || row.getFirstCellNum() == j)
                    continue;

                // 遍历所有的列
                List<Object> li = new ArrayList<>();
                for (int k = row.getFirstCellNum(); k <= row.getLastCellNum(); k++) {
                    cell = row.getCell(k);
                    if (cell != null)
                        li.add(getCellValue(cell));
                    else
                        li.add("");
                }
                list.add(li);
            }
        }
        work.close();
        return list;
    }

    /**
     * 根据文件后缀，自适应上传文件版本
     * @param in
     * @param fileName
     * @return
     * @throws Exception
     */
    private static Workbook getWorkbook(InputStream in, String fileName) throws IOException {
        Workbook wb = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));


        if (excel2003L.equals(fileType)) {
            wb = new HSSFWorkbook(in); // 2003
        } else if (excel2007U.equals(fileType)) {
            wb = new XSSFWorkbook(in); // 2007
        } else {
            throw new BusinessException(ErrorCode.ERROR_UPLOAD_WRONG_TYPE.getCode(), ErrorCode.ERROR_UPLOAD_WRONG_TYPE.getMsg());
        }
        return wb;
    }

    /**
     * 对表格中的数值进行格式化
     * @param cell
     * @return
     */
    private static Object getCellValue(Cell cell) {
        Object value = null;
        DecimalFormat df = new DecimalFormat("0");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        DecimalFormat df2 = new DecimalFormat("0.00");

        switch (cell.getCellTypeEnum()) {
            case STRING:
                value = cell.getRichStringCellValue().getString();
                break;
            case NUMERIC:
                if ("General".equals(cell.getCellStyle().getDataFormatString())) {
                    value = df.format(cell.getNumericCellValue());
                } else if ("m/d/yy".equals(cell.getCellStyle().getDataFormatString())) {
                    value = sdf.format(cell.getDateCellValue());
                } else {
                    value = df2.format(cell.getNumericCellValue());
                }
                break;
            case BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
            case BLANK:
                value = "";
                break;
            default:
                break;
        }
        return  value;
    }
}
