package com.danhuang.map.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试map的常用方法
 * 
 * @author danhuang
 *
 */
public class MyMap2 {
	public static void main(String[] args) {
		Employee e1 = new Employee(1001, "蛋黄", 500000);
		Employee e2 = new Employee(1002, "蛋白", 50000);
		Employee e3 = new Employee(1003, "蛋清", 5000);

		Map<Integer, Employee> map = new HashMap<>();
		map.put(1001, e1);
		map.put(1002, e2);
		map.put(1002, e3);

		Employee e = map.get(1001);
		System.out.println(e);

	}
}

// 雇员信息
class Employee {
	private int id;
	private String ename;
	private double salary;

	public Employee(int id, String ename, double salary) {
		super();
		this.id = id;
		this.ename = ename;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", ename=" + ename + ", salary=" + salary + "]";
	}

}