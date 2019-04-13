package com.danhuang.test;

public class TestArrayList {

	private int size;
	private Object[] object;
	private int paraitory;

	public TestArrayList() {
		object = new Object[6];
		paraitory = 6;
	}

	public void add(Object value) {
		if (size >= paraitory) {
			Object[] newObject = new Object[size + (size >> 1)];
			System.arraycopy(object, 0, newObject, 0, size);
			paraitory = size + (size >> 1);
			object = newObject;
		}
		object[size++] = value;
	}

	public Object get(int index) {
		checkIndex(index);
		return object[index];
	}

	public void checkIndex(int index) {
		if (index < 0 || index > size - 1) {
			throw new RuntimeException("数组索引错误");
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for(int i=0;i<size;i++) {
			sb.append(object[i]+",");
		}
		sb.setCharAt(sb.length()-1, ']');
		return sb.toString();
	}
	public static void main(String[] args) {
		TestArrayList myTest = new TestArrayList();
		myTest.add(2);
		myTest.add(3);
		myTest.add(3);
		myTest.add(3);
		myTest.add(3);
		myTest.add(6);
		myTest.add(8);
		myTest.add(3);
	
		System.out.println(myTest);
	}
}
