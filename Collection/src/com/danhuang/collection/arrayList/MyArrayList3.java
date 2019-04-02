package com.danhuang.collection.arrayList;

/**
 * 自定义一个ArrayList，体会底层原理
 * 增加数组扩容
 * 
 * @author danhuang
 *
 */
public class MyArrayList3<E> {
	private Object[] elementData;
	private int size;
	private static final int DEFAULT_CAPACITY = 10;

	public MyArrayList3() {
		elementData = new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList3(int capacity) {
		elementData = new Object[capacity];
	}

	public void add(E element) {
		//什么时候扩容
		if(size == elementData.length) {
			//扩容操作,这里+优先级比>>高
			Object[] newArray = new Object[elementData.length + (elementData.length>>1)];//10->10+10/2=15
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			elementData = newArray;
		}
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
		MyArrayList3<String> s1 = new MyArrayList3(10);
		for(int i=0;i<11;i++)
			s1.add("gao"+i);
		System.out.println(s1);
	}
}
