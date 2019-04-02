package com.danhuang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 * 
  * 项目名称:  jdbc_template
  * 包:      com.danhuang.jdbc    
  * 类名称:   JdbcDemo 
  * 类描述:   JDBC操作
  * 创建人:   danhuang   
  * 创建时间:  2019年2月18日 上午11:23:47   
  *
 */
public class JdbcDemo
{
	public static void main(String[] args) throws Exception
	{

		//1注册驱动
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		//开发中遵循原则：编译时不依赖，运行时才依赖，解决该问题用反射创建
		Class.forName("com.mysql.jdbc.Driver");
		
		//2获取连接
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybtis","root","123456");
		//3获取操作数据库的预处理对象
		PreparedStatement ps = connection.prepareStatement("select * from items");
		//4执行sql语句并返回结果
		ResultSet rs = ps.executeQuery();
		//5封装结果集
		while(rs.next()) 
		{
			System.out.println(rs.getString("name"));
		}
		//6释放资源
		rs.close();
		ps.close();
		connection.close();

	}
}
