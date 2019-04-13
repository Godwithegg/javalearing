package com.danhuang.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 使用反射读取注解的信息，模拟处理注解信息的流程
 * @author danhuang
 *
 */
public class Demo3{
	public static void main(String[] args) {
		try {
			Class clz = Class.forName("com.danhuang.annotation.Student");
			//获得类的所有注解
			Annotation[] annotations = clz.getAnnotations();
			for (Annotation annotation : annotations) {
				System.out.println(annotation);
			}
			//获得类指定的注解
			StudentTable st = (StudentTable) clz.getAnnotation(StudentTable.class);
			System.out.println(st.value());
			
			//获得类的属性的注解
			Field f = clz.getDeclaredField("studentName");
			StudentField sField = f.getAnnotation(StudentField.class);
			System.out.println(sField.columnName()+"-->"+sField.type()+"-->"+sField.length());
			
			//根据获得的表名字段的信息，拼出DDL语句，使用JDBC执行这个SQL，在数据库中生成相关的表
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
