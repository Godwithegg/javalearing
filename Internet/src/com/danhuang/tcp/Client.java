package com.danhuang.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 熟悉流程
 * 创建客户端
 * 1.建立连接：使用socket创建客户端 + 服务的地址和端口
 * 2.操作：输入输出流操作
 * 3.释放资源
 * @author danhuang
 *
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//1.建立连接：使用socket创建客户端+服务的地址和端口
		Socket client = new Socket("localhost", 8888);
		//2.操作：输入与输出流操作
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		String data = "hello";
		dos.writeUTF(data);
		dos.flush();
		//3.释放资源
		dos.close();
		client.close();
	}
}
