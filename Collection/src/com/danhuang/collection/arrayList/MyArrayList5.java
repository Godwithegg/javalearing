package com.danhuang.collection.arrayList;

import javax.management.RuntimeErrorException;

/**
 * 自定义一个ArrayList，体会底层原理 增加删除
 * 
 * @author danhuang
 *
 */
public class MyArrayList5<E> {
	private Object[] elementData;
	private int size;
	private static final int DEFAULT_CAPACITY = 10;

	public MyArrayList5() {
		elementData = new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList5(int capacity) {
		if (capacity < 0) {
			throw new RuntimeException("容器的容量不能为负");
		} else if (capacity == 0) {
			elementData = new Object[DEFAULT_CAPACITY];
		} else {
			elementData = new Object[capacity];
		}
	}

	public void add(E element) {
		// 什么时候扩容
		if (size == elementData.length) {
			// 扩容操作,这里+优先级比>>高
			Object[] newArray = new Object[elementData.length + (elementData.length >> 1)];// 10->10+10/2=15
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			elementData = newArray;
		}
		elementData[size++] = element;
	}

	public E get(int index) {
		checkRange(index);
		return (E) elementData[index];
	}

	public void set(E element, int index) {
		checkRange(index);
		elementData[index] = element;
	}

	public void checkRange(int index) {
		// 判断索引是否合法[0,size)
		if (index < 0 || index > size - 1) {
			// 不合法
			throw new RuntimeException("索引不合法" + index);
		}
	}

	public void remove(E element) {
		// element,将它和所有元素挨个比较，获得第一个比较为true的，返回
		for (int i = 0; i < size; i++) {
			if (element.equals(get(i))) {// 容器中所有的比较操作都是用equals而不是==
				// 将该元素从此处移除
				remove(i);
			}
		}
	}

	public void remove(int index) {
		// a,b,c,d,e,f,g,h
		// a,b,c,e,f,g,h
		int numMoved = elementData.length - index - 1;
		if (numMoved > 0) {
			System.arraycopy(elementData, index + 1, elementData, index, numMoved);
		}

		elementData[--size] = null;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0 ? true : false;
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
		MyArrayList5<String> s1 = new MyArrayList5(10);
		for (int i = 0; i < 11; i++)
			s1.add("gao" + i);
		System.out.println(s1);
		s1.set("lab", 10);
		System.out.println(s1.get(10));
		s1.remove(3);
		System.out.println(s1.get(3));
		System.out.println(s1.isEmpty());
		System.out.println(s1.size());
	}
	
}
