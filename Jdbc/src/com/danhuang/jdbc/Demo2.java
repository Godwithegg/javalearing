package com.danhuang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试执行sql语句，以及sql注入问题
 * @author danhuang
 *
 */
public class Demo2 {
	public static void main(String[] args) {
		//加载驱动类
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接（连接对象内部其实包含了Socket对象，是一个远程的连接。比较耗时！这是Connection对象管理的一个要点！）
			//真正开发中，为了提高效率，都会使用连接池来管理连接对象！
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
			Statement stmt = conn.createStatement();
//			String id = 7+"";
//			String sql = "insert into test(id,age) values("+id+",8)";
//			stmt.execute(sql);
			
			//测试sql注入,会被恶意攻击清除数据
			String id = "5 or 1=1";
			String sql = "delete from t_user where id="+id;
			stmt.execute(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
