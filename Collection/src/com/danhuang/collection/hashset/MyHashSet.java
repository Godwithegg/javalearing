package com.danhuang.collection.hashset;

import java.util.HashSet;
import java.util.Set;

/**
 * 测试hashSet基本用法
 * Set没有顺序，不可重复
 * list有顺序，可重复
 * @author danhuang
 *
 */
public class MyHashSet {
	
	public static void main(String[] args) {
		Set<String> set1 = new HashSet<>();
		
		set1.add("aa");
		set1.add("bb");
		set1.add("cc");
		set1.add("cc");
		System.out.println(set1);
		
		set1.remove("aa");
		System.out.println(set1);
		
		Set<String> set2 = new HashSet<>();
		set2.add("aa");
		set2.add("dd");
		set1.addAll(set2);
		System.out.println(set1);
	}
}
