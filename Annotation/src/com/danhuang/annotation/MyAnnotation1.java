package com.danhuang.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//表示该注解修饰范围，方法、类
@Target(value= {ElementType.METHOD,ElementType.TYPE})
//表示注解运行时有效
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation1 {
	
	String studentName() default "";
	int age() default 0;
	int id() default -1;
	String[] schools() default {"清华"};
}
