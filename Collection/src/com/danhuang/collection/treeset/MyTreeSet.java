package com.danhuang.collection.treeset;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 测试TreeSet的使用
 * 
 * @author danhuang
 *
 */
public class MyTreeSet {
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<>();
		set.add(300);
		set.add(200);
		set.add(600);
		System.out.println(set);

		Set<Employee> emp = new TreeSet<>();
		emp.add(new Employee(1, "蛋黄", 2000));
		emp.add(new Employee(2, "蛋清", 100));
		emp.add(new Employee(3, "蛋白", 30000));
		System.out.println(emp);
	}
}

class Employee implements Comparable<Employee> {
	int id;
	String name;
	int salary;

	public Employee(int id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

	@Override
	public int compareTo(Employee o) {
		return (int) (this.salary - o.salary);
	}
}