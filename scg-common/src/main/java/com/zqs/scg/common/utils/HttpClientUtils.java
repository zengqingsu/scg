package com.zqs.scg.common.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class HttpClientUtils {

	private List<HttpHeader> headers = new ArrayList<>(); 

	public HttpClientUtils(String headerKey, String headerValue) {
		headers.add(new HttpHeader(headerKey, headerValue));
	}

	public String httpPostWithJSON(String url, String json) throws Exception {

		String result = null;

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");
		
		httpPost.addHeader("pagodaRequestKey", "b0e3202f-0825-4a6d-9a60-b5a5e785d403");

//		if (headers != null && headers.size() > 1) {
//			for (HttpHeader header : headers) {
//				
//				httpPost.addHeader(header.getHeaderKey(), header.getHeaderValue());
//			}
//		}

		StringEntity se = new StringEntity(json);
		se.setContentEncoding("UTF-8");
		se.setContentType("application/json");// 发送json数据需要设置contentType
		httpPost.setEntity(se);
		CloseableHttpResponse response = httpClient.execute(httpPost);
		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {

			HttpEntity entity = response.getEntity();

			result = EntityUtils.toString(entity);

		}
		return result;
	}

	class HttpHeader {

		public String headerKey;
		public String headerValue;

		public HttpHeader() {
		}
		
		public HttpHeader(String headerKey, String headerValue) {
			this.headerKey = headerKey;
			this.headerValue = headerValue;
		}

		public String getHeaderKey() {
			return headerKey;
		}

		public void setHeaderKey(String headerKey) {
			this.headerKey = headerKey;
		}

		public String getHeaderValue() {
			return headerValue;
		}

		public void setHeaderValue(String headerValue) {
			this.headerValue = headerValue;
		}

	}

}
