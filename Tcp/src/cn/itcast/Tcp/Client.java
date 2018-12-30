package cn.itcast.Tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client
{
	public static void main(String[] args) throws Exception
	{
		Socket socket = new Socket("localhost", 9989);
		PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
		String x=null;
		printWriter.write('a');
		printWriter.flush();
		
		socket.shutdownOutput();
		
		InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String data = null;
		while((data = bufferedReader.readLine())!=null)
		{
			System.out.println("我是客户端，服务器说："+data);
		}
		
		
		bufferedReader.close();
		printWriter.close();
		socket.close();
	}
}
