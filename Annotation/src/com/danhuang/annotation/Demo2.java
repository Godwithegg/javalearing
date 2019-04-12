package com.danhuang.annotation;

public class Demo2 {
	
	@MyAnnotation1(studentName = "蛋",age=12,id=12,schools= {"a"})
	public void test() {
		
	}
	//只有一个可省略名字
	@MyAnnotation2("aaa")
	public void test1() {
		
	}
}
