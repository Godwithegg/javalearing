package com.danhuang.map.hashmap;

/**
 * 自定义一个hashmap 实现了put方法增加键值对，并解决了键重复的时候覆盖相应的节点
 * 
 * @author danhuang
 *
 */
public class MyHashMap {
	Node[] table;// 位桶数组。bucket array
	int size; // 存放的键值对的个数

	public MyHashMap() {
		table = new Node[16]; // 长度一般定义成2的整数幂
	}

	public void put(Object key, Object value) {
		Node node = new Node();
		node.hash = myHash(key.hashCode(), table.length);
		node.key = key;
		node.value = value;
		Node temp = table[node.hash];
		if (temp == null) {
			// 数组为空则直接将新节点放进去
			table[node.hash] = node;
		} else {
			// 此处数组不为空,则遍历对应的链表
			while (temp.next != null) {

				// 判断key如果重复，则覆盖
				if (temp.key.equals(key)) {
					// System.out.println("key重复");
					temp.value = value;
					size++;
					return;
				} else {
					// key不重复,则遍历下一个
					temp = temp.next;
				}
			}
			temp.next = node;
			size++;
		}
	}

	public int myHash(int v, int length) {
		// System.out.println(v & (length - 1)); 该效率高
		// System.out.println(v % (length));
		return v & (length - 1); // 位运算计算hash码
	}

	public static void main(String[] args) {
		MyHashMap m = new MyHashMap();
		m.put(10, "aa");
		m.put(20, "bb");
		m.put(30, "cc");
		m.put(53, "gg");
		System.out.println(m);
	}

}

/**
 * 用于hashmap中
 * 
 * @author danhuang
 *
 */
class Node {
	int hash;
	Object key;
	Object value;
	Node next;

}
