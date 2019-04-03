package com.danhuang.map;

/**
 * 自定义一个hashmap 
 * 实现get方法，根据键对象获得对应的值对象
 * 
 * @author danhuang
 *
 */
public class MyHashMap3 {
	Node[] table;// 位桶数组。bucket array
	int size; // 存放的键值对的个数

	public MyHashMap3() {
		table = new Node[16]; // 长度一般定义成2的整数幂
	}

	public Object get(Object key) {

		int hash = myHash(key.hashCode(), table.length);

		if (table[hash] != null) {
			Node temp = table[hash];
			while (temp != null) {
				if (temp.key.equals(key)) {
					return temp.value;
				}
				temp = temp.next;
			}
		}

		return null;
	}

	public void put(Object key, Object value) {
		// 如果要完善，还需要考虑数据扩容！！！

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

	@Override
	public String toString() {
		// {key:value,key:value}
		StringBuilder sb = new StringBuilder("{");
		// 遍历数组
		for (int i = 0; i < table.length; i++) {
			Node temp = table[i];
			// 遍历链表
			while (temp != null) {
				sb.append(temp.key + ":" + temp.value + ",");
				temp = temp.next;
			}
		}
		sb.setCharAt(sb.length() - 1, '}');
		return sb.toString();
	}

	public static void main(String[] args) {
		MyHashMap3 m = new MyHashMap3();
		m.put(10, "aa");
		m.put(20, "bb");
		m.put(30, "cc");
		m.put(53, "gg");
		System.out.println(m.get(53));
		System.out.println(m);
	}

}
