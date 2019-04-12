package com.danhuang.server.http;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 目标:封装请求信息中的参数转乘map
 * @author danhuang
 *
 */
public class Server5 {
	private ServerSocket serverSocket;

	public static void main(String[] args) {
		Server5 server = new Server5();
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
			Request2 request = new Request2(client);
			
			Response response = new Response(client);
			//关注了内容
			response.print("<html>");
			response.print("<head>");
			response.print("<title>");
			response.print("服务器相应成功");
			response.print("</title>");
			response.print("</head>");
			response.print("<body>");
			response.print("蛋黄终于回来了。。"+request.getParameter("uname"));
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
