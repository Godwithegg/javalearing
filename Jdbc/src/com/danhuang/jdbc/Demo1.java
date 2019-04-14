package com.danhuang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 测试跟数据库建立连接
 * @author danhuang
 *
 */
public class Demo1 {
	public static void main(String[] args) {
		//加载驱动类
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接（连接对象内部其实包含了Socket对象，是一个远程的连接。比较耗时！这是Connection对象管理的一个要点！）
			//真正开发中，为了提高效率，都会使用连接池来管理连接对象！
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
			System.out.println(conn);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
