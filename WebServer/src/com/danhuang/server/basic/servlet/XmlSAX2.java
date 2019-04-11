package com.danhuang.server.basic.servlet;

import java.util.ArrayList;
import java.util.List;

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
public class XmlSAX2 {
	public static void main(String[] args) throws Exception {
		// SAX解析
		// 1.获取解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 2.从解析工厂获取解析器
		SAXParser parse = factory.newSAXParser();
		// 3.编写处理器
		// 4.加载文档Document注册处理器
		WebHandler handler = new WebHandler();
		// 5.解析
		parse.parse(Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("com/danhuang/server/basic/servlet/web.xml"), handler);
		// 获取数据
		WebContext context = new WebContext(handler.getEntitys(), handler.getMappings());
		//假设你输入了 /login
		String className = context.getClz("/login");
		Class clz = Class.forName(className);
		Servlet servlet = (Servlet)clz.getConstructor().newInstance();
		//System.out.println(servlet);
		servlet.service();
	}
}

class WebHandler extends DefaultHandler {
	private List<Entity> entitys;
	private List<Mapping> mappings;
	private Entity entity;

	public List<Entity> getEntitys() {
		return entitys;
	}

	public void setEntitys(List<Entity> entitys) {
		this.entitys = entitys;
	}

	public List<Mapping> getMappings() {
		return mappings;
	}

	public void setMappings(List<Mapping> mappings) {
		this.mappings = mappings;
	}

	private Mapping mapping;
	private boolean isMapping = false;
	private String tag;// 存储操作的标签

	@Override
	public void startDocument() throws SAXException {
		entitys = new ArrayList<>();
		mappings = new ArrayList<>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName != null) {
			tag = qName;
		}
		if (tag.equals("servlet")) {
			entity = new Entity();
			isMapping = false;
		} else if (tag.equals("servlet-mapping")) {
			mapping = new Mapping();
			isMapping = true;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName != null) {
			if (qName.equals("servlet")) {
				entitys.add(entity);
			} else if (qName.equals("servlet-mapping")) {
				mappings.add(mapping);
			}
		}
		tag = null;// tag丢弃掉
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String contents = new String(ch, start, length).trim();
		if (null != tag) { // 处理了空
			if (isMapping) {// 操作servlet-mapping
				if (tag.equals("servlet-name")) {
					mapping.setName(contents);
				} else if (tag.equals("url-pattern")) {
					if (contents.length() > 0) {
						mapping.addPattern(contents);
					}
				}
			} else {// 操作servlet
				if (tag.equals("servlet-name")) {
					entity.setName(contents);
				} else if (tag.equals("servlet-class")) {
					if (contents.length() > 0) {
						entity.setClz(contents);
					}
				}
			}

		}
	}

}
