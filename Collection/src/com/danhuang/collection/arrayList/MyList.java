package com.danhuang.collection.arrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * 认识集合中和索引相关的方法
 * @author danhuang
 *
 */
public class MyList {
	public static void main(String[] args) {
		//useList();
		listIndex();
	}
	public static void useList() {
		List<String> list1 = new ArrayList<>();
		list1.add("aa");
		list1.add("bb");
		list1.add("cc");
		List<String> list2 = new ArrayList<>();
		list2.add("bb");
		list2.add("cc");
		list2.add("dd");
		
		System.out.println("list1:"+list1);

//		求并集
//		list1.addAll(list2);
//		System.out.println("list1 use addall:"+list1);

//		移出交集
//		list1.removeAll(list2);
//		System.out.println("list1 use removeall:"+list1);

//		取交集
//		list1.retainAll(list2);
//		System.out.println("list1 use retainall:"+list1);

//		list1是否包含list2中所有元素
//		list1.containsAll(list2);
//		System.out.println("list1 use containsall:"+list1);
		
	}
	public static void listIndex() {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("d");
		
		System.out.println(list);
		//在2的位置插入一个内容
		list.add(2,"我");
		System.out.println(list);
		
		//移出位置2的元素
		list.remove(2);
		System.out.println(list);
		
		//替换位置2的元素
		list.set(2, "蛋黄");
		System.out.println(list);
		
		//获得位置2的元素
		System.out.println(list.get(2));
		
		//返回指定元素第一次出现的位置,不包含则返回-1
		int firstIndex = list.indexOf("d");
		System.out.println(firstIndex);
		
		//返回指定元素最后一次出现的位置,不包含则返回-1
		int lastIndex = list.lastIndexOf("d");
		System.out.println(lastIndex);
	}
}
