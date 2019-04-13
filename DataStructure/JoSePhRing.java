package cn.itcast.mytest;

import java.util.Scanner;

public class sercert
{
	public static void main(String[] args)
	{
		int s = 0;
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();         //输入圈子中所有人的人数
		int k = in.nextInt();         //输入要出圈的人报的数
		for(int i = 1;i <= n ; i ++)   //！！注意，循环n次是最后留下来那个人，而不是淘汰了n个人
		{
			s = (s+k) % i;            //喊道你就出去，这里i是通过逆向思维，每次少一个，少到后面i就出圈，因此逆向从i开始出圈
		}
		System.out.println(s+1);   //+1的原因是因为2%3==0，而实际我们的人头是从0开始算的，因此实际上是3
	}
}