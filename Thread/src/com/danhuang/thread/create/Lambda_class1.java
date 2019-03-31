package com.danhuang.thread.create;

interface ILike{
	void lambda(int a);
}
public class Lambda_class1 {
	public static void main(String[] args) {
		ILike like = (a)->{	//只有一个参数情况下括号可以省略，只有一行代码，花括号可以省略
			System.out.println("I like lambda --->"+a);
		};
		like.lambda(10);
		//改为
		like = a->System.out.println("I like to->"+a);
		like.lambda(20);
	}
}
