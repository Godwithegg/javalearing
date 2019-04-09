package com.danhuang.highio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 对象流 1、写出后读取 2、读取的顺序与写出保持一致 3、不是所有的对象都可以实现序列化，要实现serializable接口
 * ObectOutputStream ObjectInputStream
 * 
 * @author danhuang
 *
 */
public class ObjectIOStreamDemo2 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// 写出
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("obj.ser")));
		// 操作数据类型数据
		oos.writeUTF("编码辛酸泪");
		oos.writeInt(18);
		oos.writeBoolean(false);
		oos.writeChar('a');
		// 对象
		oos.writeObject("水解其中味");// 字符串实现了serializable接口，因此可以写入
		Employee emp = new Employee("马云", 400);
		oos.writeObject(emp);

		oos.flush();
		oos.close();
		// 读取
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("obj.ser")));
		// 顺序与写出保持一致
		String msg = ois.readUTF();
		int age = ois.readInt();
		boolean flag = ois.readBoolean();
		char ch = ois.readChar();
		Object str = ois.readObject();
		Object people = ois.readObject();
		
		if (str instanceof String) {
			String strObj = (String) str;
			System.out.println(str);
		}
		if (people instanceof Employee) {
			Employee empObj = (Employee) people;
			// name没有实现序列化
			System.out.println(empObj.getName() + "-->" + empObj.getSalary());
		}

	}
}
