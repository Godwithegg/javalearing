package com.danhuang.server.basic.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebContext {
	private List<Entity> entitys = null;
	private List<Mapping> mappings = null;
	
	//key --> servlet-name value -->servlet-class
	private Map<String, String> entityMap = new HashMap<>();
	//key --> url-pattern value-->servlet-name
	private Map<String, String> mappingMap = new HashMap<>();
	
	public WebContext(List<Entity> entitys, List<Mapping> mappings) {
		this.entitys = entitys;
		this.mappings = mappings;
		//将entityList专成对应的map
		for(Entity entity:entitys) {
			entityMap.put(entity.getName(), entity.getClz());
		}
		//将entity的List转成了对应map
		for(Mapping mapping:mappings) {
			for(String pattern:mapping.getPatterns()) {
				mappingMap.put(pattern,mapping.getName());
			}
		}
	}
	/**
	 * 通过url路径找到对应的class
	 * @param pattern
	 * @return
	 */
	public String getClz(String pattern) {
		String name = mappingMap.get(pattern);
		return entityMap.get(name);
		
	}
}
