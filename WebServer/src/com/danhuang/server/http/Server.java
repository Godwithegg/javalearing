package com.danhuang.server.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 目标:使用serversocket建立与浏览器的连接获取请求协议
 * 
 * @author danhuang
 *
 */
public class Server {
	private ServerSocket serverSocket;

	public static void main(String[] args) {
		Server server = new Server();
		server.start();

	}

	// 启动服务
	public void start() {
		try {
			serverSocket = new ServerSocket(8888);
			receive();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("服务器启动失败");
		}
	}

	// 接收连接处理
	public void receive() {

		try {
			Socket client = serverSocket.accept();
			System.out.println("一个客户端建立了连接");
			// 获取请求协议
			InputStream is = client.getInputStream();
			byte[] datas = new byte[1024 * 1024];
			int len = is.read(datas);
			String requestInfo = new String(datas, 0, len);
			System.out.println(requestInfo);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("客户端错误");
		}
	}

	// 停止服务
	public void stop() {

	}
}
