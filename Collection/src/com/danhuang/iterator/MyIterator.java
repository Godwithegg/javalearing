package com.danhuang.iterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 测试迭代器遍历List、Set、Map
 * 
 * @author danhuang
 *
 */
public class MyIterator {
	public static void main(String[] args) {
		// testIteratorList();
		// testIteratorSet();
		// testIteratorMap();
		testIteratorMapByKey();
	}

	/**
	 * 使用iterator遍历List
	 */
	public static void testIteratorList() {
		List<String> list = new ArrayList<>();
		list.add("aa");
		list.add("bb");
		list.add("cc");

		for (Iterator<String> iter = list.iterator(); iter.hasNext();) {
			String temp = iter.next();
			System.out.println(temp);
		}
	}

	/**
	 * 使用iterator遍历Set
	 */
	public static void testIteratorSet() {
		Set<String> set = new HashSet<>();
		set.add("aa");
		set.add("bb");
		set.add("cc");
		for (Iterator iter = set.iterator(); iter.hasNext();) {
			System.out.println(iter.next());
		}
	}

	public static void testIteratorMap() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "aa");
		map.put(2, "bb");
		map.put(3, "cc");

		Set<Entry<Integer, String>> se = map.entrySet();
		for (Iterator iter = se.iterator(); iter.hasNext();) {
			Entry<Integer, String> entry = (Entry<Integer, String>) iter.next();
			System.out.println(entry.getKey() + "--" + entry.getValue());

		}
	}

	public static void testIteratorMapByKey() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "aa");
		map.put(2, "bb");
		map.put(3, "cc");

		Set<Integer> se = map.keySet();
		for (Iterator<Integer> iter = se.iterator(); iter.hasNext();) {
			Integer temp = iter.next();
			System.out.println(temp + "--" + map.get(temp));
		}
	}

}
