package com.metastudio.kuafus.mall.net;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.HashMap;

/**
 * 
 * 
 * 查询版本升级信息
 * 
 * @author liudewei
 *
 */
public class NetCheckUp {
	public static HashMap<String, String> getData(final String path) {
		HashMap<String, String> data = new HashMap<String, String>();
		Document document;
		try {
			document = DocumentHelper.parseText(HttpRequest.sendGet(path));
			Element rootElement = document.getRootElement();
			data.put("version", rootElement.element("version").getText());
			data.put("path", rootElement.element("path").getText());
			data.put("new", rootElement.element("new").getText());

		} catch (Exception e) {
			return null;
		}

		return data;
	}
}
