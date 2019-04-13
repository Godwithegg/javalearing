package com.danhuang.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 单向
 * 创建服务器
 * 1.指定端口 使用serversocket创建服务器
 * 2.阻塞式等待连接accept
 * 3.操作：输入输出流操作
 * 4.释放资源
 * @author danhuang
 *
 */
public class LoginServer {
	public static void main(String[] args) throws IOException {
		// 1.指定端口 使用serversocket创建服务器
		ServerSocket server = new ServerSocket(8888);
		// 2.阻塞式等待连接accept
		Socket client = server.accept();
		System.out.println("一个客户端建立了连接");
		// 3.操作：输入输出流操作
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String datas = dis.readUTF();
		//分析
		String[] dataArray = datas.split("&");
		for (String info : dataArray) {
			String[] userInfo = info.split("=");
			System.out.println(userInfo[0]+"-->"+userInfo[1]);
			if(userInfo[0].equals("uname")) {
				System.out.println("你的用户名为："+userInfo[1]);
			}else if(userInfo[0].equals("upwd")){
				System.out.println("你的密码为:"+userInfo[1]);
			}
		}
		// 4.释放资源
		dis.close();
		client.close();
		server.close();
	}
}
