package cn.itcast.Tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class serverSocket
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket serverSocket = new ServerSocket(9989);
		System.out.println("打开监听端口");
		Socket socket = serverSocket.accept();
		System.out.println("开始监听");
		
		
		InputStream inputStream = socket.getInputStream();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String data = null;
		while((data = bufferedReader.readLine())!=null)
		{
			System.out.println("我是服务器，客户端说："+data);
		}
		socket.shutdownInput();
		
		PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		printWriter.write('b');
		printWriter.flush();

		printWriter.close();
		socket.close();
		serverSocket.close();
		inputStream.close();
		bufferedReader.close();
	}
}
