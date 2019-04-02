package com.danhuang.collection.linkedList;

/**
 * 定义一个链表 增加get方法
 * 
 * @author danhuang
 *
 */
public class MyLinkedList2 {
	private Node first;
	private Node last;
	private int size;

	public Object get(int index) {
		if (index < 0 || index > size - 1) {
			throw new RuntimeException("索引数字不合法:" + index);
		}
		Node temp = null;
		if (index < (size >> 1)) {
			temp = first;
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
		} else {
			temp = last;
			for (int i = size - 1; i > index; i--) {
				temp = temp.previous;
			}
		}

		return temp.element;
	}

	// []
	// ["a"]
	public void add(Object obj) {
		Node node = new Node(obj);
		if (first == null) {
			first = node;
			last = node;
		} else {
			node.previous = last;
			node.next = null;
			last.next = node;
			last = node;
		}
		size++;
	}

	@Override
	public String toString() {
		// [a,b,c] first=a ,last=c
		StringBuffer sb = new StringBuffer();

		sb.append("[");
		// 挨个遍历链表中的元素
		Node head = first;
		while (head != null) {
			sb.append(head.element + ",");
			head = head.next;
		}
		sb.setCharAt(sb.length() - 1, ']');
		return sb.toString();
	}

	public static void main(String[] args) {
		MyLinkedList2 link = new MyLinkedList2();
		link.add("a");
		link.add("b");
		link.add("c");
		link.add("d");
		link.add("e");
		link.add("f");
		link.add("g");
		System.out.println(link);
		System.out.println(link.get(6));
	}
}
