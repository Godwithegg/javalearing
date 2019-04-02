package com.danhuang.collection.linkedList;

/**
 * 定义一个链表
 * @author danhuang
 *
 */
public class MyLinkedList {
	private Node first;
	private Node last;
	private int size;
	
	//[]
	//["a"]
	public void add(Object obj) {
		Node node = new Node(obj);
		if(first == null) {
			first = node;
			last = node;
		}else {
			node.previous = last;
			node.next = null;
			last.next = node;
			last = node;
		}
	}
	@Override
	public String toString() {
		//[a,b,c] first=a ,last=c
		StringBuffer sb = new StringBuffer();
		
		sb.append("[");
		//挨个遍历链表中的元素
		Node head = first;
		while(head != null) {
			sb.append(head.element+",");
			head = head.next;
		}
		sb.setCharAt(sb.length()-1, ']');
		return sb.toString();
	}
	public static void main(String[] args) {
		MyLinkedList link = new MyLinkedList();
		link.add("a");
		link.add("b");
		link.add("c");
		System.out.println(link);
	}
}
