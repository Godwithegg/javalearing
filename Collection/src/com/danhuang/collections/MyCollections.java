package com.danhuang.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections辅助类的使用
 * @author danhuang
 *
 */
public class MyCollections {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		for(int i = 0 ; i < 10;i++) {
			list.add("danhuang"+i);
		}
		System.out.println(list);
		
		//随机排列list中的元素
		Collections.shuffle(list);
		System.out.println(list);
		
		//反转list(逆序排列）
		Collections.reverse(list);
		System.out.println(list);
		
		//排序,自定义类用comparable接口
		Collections.sort(list);
		System.out.println(list);
		
		System.out.println(Collections.binarySearch(list, "danhuang7"));
		System.out.println(Collections.binarySearch(list, "danhuang20"));
		
	}
}
