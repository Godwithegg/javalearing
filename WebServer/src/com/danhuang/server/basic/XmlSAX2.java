package com.danhuang.server.basic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
public class XmlSAX2 {
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
		// 获取数据
		List<Person> persons = handler.getPersons();
		for (Person person : persons) {
			System.out.println(person.getName() + "-->" + person.getAge());
		}
	}
}

class PersonHandler extends DefaultHandler {
	private List<Person> persons;
	private Person person;
	private String tag;// 存储操作的标签

	@Override
	public void startDocument() throws SAXException {
		persons = new ArrayList<>();
	}

	@Override
	public void endDocument() throws SAXException {
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName != null) {
			tag = qName;
		}
		if (tag.equals("person")) {
			person = new Person();
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName != null && qName.equals("person")) {
			persons.add(person);
		}
		tag = null;// tag丢弃掉
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String contents = new String(ch, start, length).trim();
		if (null != tag) { // 处理了空
			if (tag.equals("name")) {
				person.setName(contents);
			} else if (tag.equals("age")) {
				if (contents.length() > 0) {
					person.setAge(Integer.valueOf(contents));
				}
			}
		}
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

}
