package com.danhuang.server.http;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 目标:封装响应信息
 * 1、内容可以动态添加
 * 2、关注状态码，拼接好响应的协议信息
 * @author danhuang
 *
 */
public class Server4 {
	private ServerSocket serverSocket;

	public static void main(String[] args) {
		Server4 server = new Server4();
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
		BufferedWriter bw = null;
		try {
			Socket client = serverSocket.accept();
			System.out.println("一个客户端建立了连接");
			// 获取请求协议
			Request request = new Request(client);
			
			Response response = new Response(client);
			//关注了内容
			response.print("<html>");
			response.print("<head>");
			response.print("<title>");
			response.print("服务器相应成功");
			response.print("</title>");
			response.print("</head>");
			response.print("<body>");
			response.print("蛋黄终于回来了。。");
			response.print("</body>");
			response.print("</html>");
			//关注了状态码
			response.pushToBrowser(200);

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("客户端错误");
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 停止服务
	public void stop() {

	}
}
