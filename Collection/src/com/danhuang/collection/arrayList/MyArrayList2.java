package com.danhuang.collection.arrayList;

/**
 * 自定义一个ArrayList，体会底层原理
 * 增加泛型
 * 
 * @author danhuang
 *
 */
public class MyArrayList2<E> {
	private Object[] elementData;
	private int size;
	private static final int DEFAULT_CAPACITY = 10;

	public MyArrayList2() {
		elementData = new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList2(int capacity) {
		elementData = new Object[capacity];
	}

	public void add(E element) {
		elementData[size++] = element;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (int i = 0; i < size; i++) {
			sb.append(elementData[i]);
			if (i != size - 1) {
				sb.append(",");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	public static void main(String[] args) {
		MyArrayList2<String> s1 = new MyArrayList2(20);
		s1.add("a");
		s1.add("b");
		System.out.println(s1);
	}
}
