package com.danhuang.tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 模拟登录 多个客户端
 * 创建客户端
 * 1.建立连接：使用socket创建客户端 + 服务的地址和端口
 * 2.操作：输入输出流操作
 * 3.释放资源
 * @author danhuang
 *
 */
public class LoginTwoClient {
	public static void main(String[] args) throws UnknownHostException, IOException {

		//1.建立连接：使用socket创建客户端+服务的地址和端口
		Socket client = new Socket("localhost", 8888);
		//2.操作：输入与输出流操作 先请求后响应
		new Send(client).send();
		new Received(client).received();

		client.close();
	}

	//发送
	static class Send {
		private Socket client;
		private DataOutputStream dos;
		private BufferedReader console;
		private String msg;
		public Send(Socket client) {
			console = new BufferedReader(new InputStreamReader(System.in));
			this.msg = init();
			this.client = client;
			
			try {
				dos = new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		private String init() {
			try {
				System.out.println("请输入用户名：");
				String uname = console.readLine();
				System.out.println("请输入密码：");
				String upwd = console.readLine();
				return "uname="+uname+"&"+"upwd="+upwd;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "";
			
		}
		public void send() {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//接收
	static class Received{
		private Socket client;
		private DataInputStream dis;
		public Received(Socket client) {
			this.client = client;
			try {
				dis = new DataInputStream(client.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void received() {
			String result;
			try {
				result = dis.readUTF();
				System.out.println(result);
			} catch (IOException e) {
				e.printStackTrace();
			}			
			//3.释放资源
		}
		
	}
}
