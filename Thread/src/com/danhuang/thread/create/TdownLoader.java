package com.danhuang.thread.create;

public class TdownLoader extends Thread {

	private String url;// 远程路径
	private String name;// 存储名字

	public TdownLoader(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}

	@Override
	public void run() {
		WebDownLoader wd = new WebDownLoader();
		wd.downLoad(url, name);
	}
	
	public static void main(String[] args) {
		TdownLoader td1 = new TdownLoader("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=574921756,1100726233&fm=173&app=49&f=JPEG?w=218&h=146&s=9446D2B2D27113989429BD3703005021", "D:\\beautiful.jpg");
		TdownLoader td2 = new TdownLoader("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2241104856,2567260193&fm=173&app=49&f=JPEG?w=218&h=146&s=A23354859EB3B04B082BCD800300C08B", "ugly.jpg");
		TdownLoader td3 = new TdownLoader("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=574921756,1100726233&fm=173&app=49&f=JPEG?w=218&h=146&s=9446D2B2D27113989429BD3703005021", "nomal.jpg");
		
		//启动三个线程
		td1.start();
		td2.start();
		td3.start();
	}
}
