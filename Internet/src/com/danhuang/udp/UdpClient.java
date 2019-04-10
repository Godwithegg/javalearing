package com.danhuang.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 发送端
 * 1.使用DatagramSocket 指定端口创建发送端
 * 2.准备数据 一定要转成字节数组 
 * 3.封装成DatagramPacket包裹，需要指定目的地
 * 4.发送包裹sent(DatagramPacket p)
 * 5.释放资源
 * @author danhuang
 *
 */
public class UdpClient {
	public static void main(String[] args) throws IOException {
		System.out.println("发送方启动中");
		// 1.使用DatagramSocket 指定端口创建发送端
		DatagramSocket client = new DatagramSocket(8888);
		// 2.准备数据 一定要转乘字节数组
		String data = "蛋黄派";
		byte[] datas = data.getBytes();
		// 3.封装成DatagramPacket包裹，需要指定目的地
		DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost", 9999));
		// 4.发送包裹sent(DatagramPacket p)
		client.send(packet);
		// 5.释放资源
		client.close();
	}
}
