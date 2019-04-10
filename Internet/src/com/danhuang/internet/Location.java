package com.danhuang.internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP：定位一个节点：计算机、路由、通信设备
 * InetAddress:
 * 1.getLocalHost:本机
 * 2.getByName：根据域名DNS或者IP地址去解析IP地址
 * 两个成员方法：
 * 1.getHostAddress：返回主机地址
 * 2.getHostName:返回计算机名
 * @author danhuang
 *
 */
public class Location {
	public static void main(String[] args) throws UnknownHostException {
		// 使用getLocalHost方法创建InetAddress对象 本机
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress());// 返回：192.168.1.110
		System.out.println(addr.getHostName()); // 输出计算机名

		System.out.println("----------------");
		// 根据域名得到InetAddress对象
		addr = InetAddress.getByName("www.163.com");
		System.out.println(addr.getHostAddress());// 返回163服务器的ip：61.135.253.15
		System.out.println(addr.getHostName());// 输出：www.163.com

		System.out.println("----------------");
		// 根据ip得到InetAddress对象
		addr = InetAddress.getByName("61.135.253.15");
		System.out.println(addr.getHostAddress());// 返回163服务器的ip：61.135.253.15
		System.out.println(addr.getHostName());// 输出ip而不是域名。如果这个ip地址不存在或DNS服务器不允许进行IP地址和域名映射，getHostName方法就直接返回这个IP地址

	}
}
