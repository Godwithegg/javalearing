package com.danhuang.map.hashmap;

/**
 * 自定义一个hashmap 增加泛型
 * 
 * @author danhuang
 *
 */
public class MyHashMap4<K,V> {
	Node1[] table;// 位桶数组。bucket array
	int size; // 存放的键值对的个数

	public MyHashMap4() {
		table = new Node1[16]; // 长度一般定义成2的整数幂
	}

	public V get(K key) {

		int hash = myHash(key.hashCode(), table.length);

		if (table[hash] != null) {
			Node1 temp = table[hash];
			while (temp != null) {
				if (temp.key.equals(key)) {
					return (V)temp.value;
				}
				temp = temp.next;
			}
		}

		return null;
	}

	public void put(K key, V value) {
		// 如果要完善，还需要考虑数据扩容！！！

		Node1 node = new Node1();
		node.hash = myHash(key.hashCode(), table.length);
		node.key = key;
		node.value = value;
		Node1 temp = table[node.hash];
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
			Node1 temp = table[i];
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
		MyHashMap4<Integer,String> m = new MyHashMap4<>();
		m.put(10, "aa");
		m.put(20, "bb");
		m.put(30, "cc");
		m.put(53, "gg");
		System.out.println(m.get(53));
		System.out.println(m);
	}

}

class Node1<K, V> {
	int hash;
	K key;
	V value;
	Node1 next;
}