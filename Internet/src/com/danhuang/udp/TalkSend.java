package com.danhuang.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 发送端
 * @author danhuang
 *
 */
public class TalkSend implements Runnable {
	private DatagramSocket client;
	private BufferedReader reader;
	private String toIP ;
	private int toPort;
	public TalkSend(int port,String toIP,int toPort) {
		this.toIP = toIP;
		this.toPort = toPort;
		try {
			client = new DatagramSocket(port);
			reader = new BufferedReader(new InputStreamReader(System.in));
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			String data;
			try {
				data = reader.readLine();
				byte[] datas = data.getBytes();
				// 3.封装成DatagramPacket包裹，需要指定目的地
				DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,
						new InetSocketAddress(this.toIP, this.toPort));
				// 4.发送包裹sent(DatagramPacket p)
				client.send(packet);
				if (data.equals("byte")) {
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		// 5.释放资源
		client.close();
	}

}
