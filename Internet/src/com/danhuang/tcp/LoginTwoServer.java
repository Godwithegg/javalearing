package com.danhuang.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 多个客户端请求
 * 创建服务器
 * 1.指定端口 使用serversocket创建服务器
 * 2.阻塞式等待连接accept
 * 3.操作：输入输出流操作
 * 4.释放资源
 * @author danhuang
 *
 */
public class LoginTwoServer {
	public static void main(String[] args) throws IOException {
		// 1.指定端口 使用serversocket创建服务器
		ServerSocket server = new ServerSocket(8888);
		boolean isRunning = true;
		// 2.阻塞式等待连接accept
		while (isRunning) {
			Socket client = server.accept();
			System.out.println("一个客户端建立了连接");
			new Thread(new Channel(client)).start();
		}
		server.close();
	}

	/**
	 * 一个channel就代表一个客户端
	 * @author danhuang
	 *
	 */
	static class Channel implements Runnable {
		private Socket client;
		// 输入流封装
		private DataInputStream dis;
		// 输出流封装
		private DataOutputStream dos;

		public Channel(Socket client) {
			this.client = client;
			try {
				//输入
				dis = new DataInputStream(client.getInputStream());
				//输出
				dos = new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
				release();
			}

		}

		@Override
		public void run() {
			// 3.操作：输入输出流操作
			String uname = "";
			String upwd = "";
			// 分析
			String[] dataArray = receive().split("&");
			for (String info : dataArray) {
				String[] userInfo = info.split("=");
				System.out.println(userInfo[0] + "-->" + userInfo[1]);
				if (userInfo[0].equals("uname")) {
					System.out.println("你的用户名为：" + userInfo[1]);
					uname = userInfo[1];
				} else if (userInfo[0].equals("upwd")) {
					System.out.println("你的密码为:" + userInfo[1]);
					upwd = userInfo[1];
				}
			}

			if (uname.equals("蛋黄") && upwd.equals("123456")) {// 成功
				send("登陆成功，欢迎回来");
			} else {// 失败
				send("用户名或密码错误");
			}
			release();

		}

		// 释放资源
		private void release() {
			// 4.释放资源
			try {
				if (dos != null) {
					dos.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				if (dis != null) {
					dis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (client != null) {
					client.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 接收数据
		private String receive() {

			String datas = "";
			try {
				datas = dis.readUTF();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return datas;
		}

		// 发送数据
		private void send(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
