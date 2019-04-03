package com.danhuang.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试hashmap的使用
 * 
 * @author danhuang
 *
 */
public class MyMap {
	public static void main(String[] args) {
		Map<Integer, String> m1 = new HashMap<>();
		
		m1.put(1, "one");
		m1.put(2, "two");
		m1.put(3, "three");
		
		System.out.println(m1.get(1));
		System.out.println(m1.size());
		System.out.println(m1.isEmpty());
		System.out.println(m1.containsKey(2));
		System.out.println(m1.containsValue("four"));
		
		Map<Integer, String> m2 = new HashMap<>();
		m2.put(4, "四");
		m2.put(5, "五");
		m1.putAll(m2);
		System.out.println(m1);
		//map中键不能重复,如果重复（根据equals方法来判断的），则新值覆盖旧值
		m1.put(3, "三");
		System.out.println(m1);
	}
}
