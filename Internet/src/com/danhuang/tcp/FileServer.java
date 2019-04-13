package com.danhuang.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 存储文件
 * 创建服务器
 * 1.指定端口 使用serversocket创建服务器
 * 2.阻塞式等待连接accept
 * 3.操作：输入输出流操作
 * 4.释放资源
 * @author danhuang
 *
 */
public class FileServer {
	public static void main(String[] args) throws IOException {
		// 1.指定端口 使用serversocket创建服务器
		ServerSocket server = new ServerSocket(8888);
		// 2.阻塞式等待连接accept
		Socket client = server.accept();
		System.out.println("一个客户端建立了连接");
		// 3.操作：文件存储
		InputStream is = new BufferedInputStream(client.getInputStream());
		OutputStream os = new BufferedOutputStream(new FileOutputStream("src/tcp.png"));
		byte[] flush = new byte[1024];
		int len = -1;
		while((len = is.read(flush)) != -1) {
			os.write(flush, 0, len);
		}
		os.flush();
		//3.释放资源
		is.close();
		os.close();
		
		
		// 4.释放资源
		is.close();
		client.close();
		server.close();
	}
}
