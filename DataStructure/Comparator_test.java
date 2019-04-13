/*
	实现java类中比较和类外比较实现方式
	即comparator和comparable的区别
*/

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
class Student implements Comparable<Student>
{
	private String username;
	private Double price;
	public Student(String username,Double price) 
	{
		this.username = username;
		this.price = price;
	};
	public void setPrice(Double price)
	{
		this.price = price;
	}
	public Double getPrice()
	{
		return price;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	@Override
	public int compareTo(Student o)
	{
		return this.price.compareTo(o.price);
		
	}
	
	
}
class pricecompare implements Comparator<Student>
{
	@Override
	public int compare(Student o1, Student o2)
	{
		return o1.getPrice().compareTo(o2.getPrice());
	}
}
public class sercert
{
	public static void main(String[] args)
	{
		Student s1 = new Student("ni", 120d);
		Student s2 = new Student("wo", 222d);
		List<Student> lists = new ArrayList<>();
		lists.add(s1);
		lists.add(s2);
		Collections.sort(lists);//默认，实现的是compareTo
		Collections.sort(lists,new pricecompare());  //实现的是比较器实现的compare方法
		for (Student student : lists)
		{
			System.out.println(student.getUsername()+":"+student.getPrice());
		}
	}
}

