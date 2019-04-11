package com.danhuang.server.basic.servlet;

import java.util.HashSet;
import java.util.Set;

public class Mapping {
	private String name;
	private Set<String> patterns;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getPatterns() {
		return patterns;
	}

	public void setPatterns(Set<String> patterns) {
		this.patterns = patterns;
	}

	public Mapping() {
		patterns = new HashSet<String>();
	}

	public void addPattern(String pattern) {
		this.patterns.add(pattern);
	}

}
