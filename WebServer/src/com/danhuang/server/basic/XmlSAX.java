package com.danhuang.server.basic;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 熟悉SAX的解析流程
 * 
 * @author danhuang
 *
 */
public class XmlSAX {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// SAX解析
		// 1.获取解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 2.从解析工厂获取解析器
		SAXParser parse = factory.newSAXParser();
		// 3.编写处理器
		// 4.加载文档Document注册处理器
		PersonHandler handler = new PersonHandler();
		// 5.解析
		parse.parse(
				Thread.currentThread().getContextClassLoader().getResourceAsStream("com/danhuang/server/basic/p.xml"),
				handler);
		// 4.编写处理器
	}
}

class PHandler extends DefaultHandler {
	@Override
	public void startDocument() throws SAXException {
		System.out.println("解析文档开始");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("解析文档结束");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println(qName + "-->解析开始");
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println(qName + "-->解析结束");
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String contents = new String(ch, start, length).trim();
		if(contents.length() > 0) {
			System.out.println("内容为" + "-->" + contents);
		}else {
			System.out.println("内容为" + "--> 空");
		}
	}
}
