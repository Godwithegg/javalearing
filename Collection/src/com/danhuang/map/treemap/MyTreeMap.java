package com.danhuang.map.treemap;

import java.util.Map;
import java.util.TreeMap;

/**
 * 测试treemap使用
 * 
 * @author danhuang
 *
 */
public class MyTreeMap {
	public static void main(String[] args) {
		Map<Integer, String> treeMap = new TreeMap<>();
		treeMap.put(3, "a");
		treeMap.put(4, "b");
		treeMap.put(2, "c");

		// 按照key自增方式排序
		for (Integer key : treeMap.keySet()) {
			System.out.println(key + "---" + treeMap.get(key));
		}

		Map<Integer, Employee> emps = new TreeMap<>();
		emps.put(2, new Employee(1, "a", 2000));
		emps.put(3, new Employee(2, "b", 3000));
		emps.put(1, new Employee(3, "c", 1000));
		System.out.println(emps);

	}
}

class Employee implements Comparable<Employee> {
	int id;
	String name;
	double salary;

	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public int compareTo(Employee o) {
		return (int) (this.salary - o.salary);
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

}