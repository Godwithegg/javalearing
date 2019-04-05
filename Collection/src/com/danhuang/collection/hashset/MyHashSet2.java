package com.danhuang.collection.hashset;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 手动实现hashset
 * 
 * @author danhuang
 *
 */
public class MyHashSet2 {
	HashMap map;
	private static final Object PRESENT = new Object();

	public MyHashSet2() {
		map = new HashMap();
	}

	public void add(Object obj) {
		map.put(obj, PRESENT);
	}

	public int size() {
		return map.size();
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{") ;
		for(Object obj:map.keySet()) {
			sb.append(obj+",");
		}
		sb.setCharAt(sb.length()-1, '}');
		return sb.toString();
	}

	public static void main(String[] args) {
		MyHashSet2 set = new MyHashSet2();
		set.add(2);
		set.add(3);
		System.out.println(set);
	}
}
