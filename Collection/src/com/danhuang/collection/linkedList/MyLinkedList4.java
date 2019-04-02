package com.danhuang.collection.linkedList;

/**
 * 定义一个链表 增加小的封装，增加泛型
 * 
 * @author danhuang
 *
 */
public class MyLinkedList4<E> {
	private Node first;
	private Node last;
	private int size;

	public E get(int index) {
		checkRange(index);
		Node node = getNode(index);
		return node != null ? (E)node.element : null;
	}

	private void checkRange(int index) {
		if (index < 0 || index > size - 1) {
			throw new RuntimeException("索引数字不合法:" + index);
		}
	}

	private Node getNode(int index) {
		checkRange(index);
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
		return temp;
	}

	// []
	// ["a"]
	public void add(E element) {
		Node node = new Node(element);
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

	public void add(int index, E element) {
		if(index < 0 || index > size) {
			throw new RuntimeException("不能插入该位置:"+index);
		}
		Node node = new Node(element);
		if (index == size) {
			last.next = node;
			node.previous = last;
			last = node;
			size++;
			return;
		}
		Node temp = getNode(index);
		Node up = temp.previous;
		if (up != null) {
			up.next = node;
			node.previous = up;
			node.next = temp;
			temp.previous = node;
		} else {
			node.next = temp;
			temp.previous = node;
			first = node;
		}

		size++;
	}

	public void remove(int index) {
		checkRange(index);
		Node temp = getNode(index);
		if (temp != null) {
			Node up = temp.previous;
			Node down = temp.next;
			if (up != null) {
				up.next = down;
			}
			if (down != null) {
				down.previous = up;
			}
			// 被删除的是第一个元素时
			if (index == 0) {
				first = down;
			}
			// 被删除的是最后一个元素时
			if (index == size - 1) {
				last = up;
			}
			size--;
		}
	}

	@Override
	public String toString() {
		// [a,b,c] first=a ,last=c
		StringBuffer sb = new StringBuffer();
		if (size == 0) {
			return "[]";
		}
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
		MyLinkedList4<String> link = new MyLinkedList4<>();
		link.add("a");
		link.add("b");
		link.add("c");
		link.add("d");
		link.add("e");
		link.add("f");
		link.add("g");
		System.out.println(link);
		System.out.println(link.get(5));
		link.remove(5);
		System.out.println(link);
		link.remove(1);
		System.out.println(link);
		link.add(5, "蛋黄");
		System.out.println(link);
	}
}
