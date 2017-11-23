package com.zqs.scg.common.utils;

import com.alibaba.fastjson.TypeReference;
import com.zqs.scg.common.http.HttpRequest;
import com.zqs.scg.common.http.HttpResponse;
import com.zqs.scg.common.utils.json.Jsoner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dreampie
 * @date 2015-10-22
 * @what
 */
public class Cookier {

  private HttpRequest request;
  private HttpResponse response;
  private Map<String, Object> cookies;

  public Cookier(HttpRequest request) {
    this(request, null);
  }

  public Cookier(HttpResponse response) {
    this(null, response);
  }

  public Cookier(HttpRequest request, HttpResponse response) {
    Checker.checkArgument(request != null || response != null, "You must set request or response.");
    this.request = request;
    this.response = response;
    this.cookies = new HashMap<String, Object>();
  }

  public String get(String name) {
    return request.getCookiesMap().get(name);
  }

  public <T> T get(String name, TypeReference<T> type) {
    Object result = null;
    if (cookies.containsKey(name)) {
      result = cookies.get(name);
    } else {
      Map<String, String> cookieMap = request.getCookiesMap();
      if (cookieMap.containsKey(name)) {
        result = Jsoner.toObject(cookieMap.get(name), type);
        cookies.put(name, result);
      }
    }
    return (T) result;
  }


  public <T> T get(String name, Class<T> clazz) {
    Object result = null;
    if (cookies.containsKey(name)) {
      result = cookies.get(name);
    } else {
      Map<String, String> cookieMap = request.getCookiesMap();
      if (cookieMap.containsKey(name)) {
        result = Jsoner.toObject(cookieMap.get(name), clazz);
        cookies.put(name, result);
      }
    }
    return (T) result;
  }


  public void save(String name, Object value, int expiration) {
    String v;
    if (value instanceof String) {
      v = (String) value;
    } else {
      v = Jsoner.toJSON(value);
    }
    response.addCookie(name, v, expiration);
  }
}
