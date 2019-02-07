package cn.itcast.mytest;

import java.util.Scanner;

public class sercert
{
	static int MAX = 1024;           //设置迷宫的规模
	static char [][] maze = new char[MAX][MAX];           //定义一个迷宫
	static boolean [][] mark = new boolean[MAX][MAX];     //判断路是否可通
	static boolean flag ;       //true代表能到终点，false不能
	static int [][] d = {{1,0},{0,1},{-1,0},{0,-1}};      //下一步的方向
	static int N;     //定义迷宫长
	static int M;     //迷宫宽
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		in.nextLine();       //接受空行，类似c中getchar
		for(int i = 1 ; i <= N ;i ++)          //输入一个N行M列的迷宫
		{
			String s = in.nextLine();
			for(int k = 0 ; k < s.length(); k ++)
			{
				maze[i][k+1] = s.charAt(k);
			}
		}
		for(int i = 1 ;i <= N ;i ++)
		{
			for(int j = 1 ; j <= M ;j ++)
			{
				System.out.print(maze[i][j]+" ");
			}
			System.out.println();
		}
		dfs(1, 1);           //从(1,1)是否能到N,M
		System.out.println(flag);
	}
	public static void dfs(int x,int y)
	{
		mark[x][y] = true;         //该处已经走过
		if(x == N && y == M)      //到达重点，返回
		{
			flag = true;
			return ;
		}
		for(int i = 0 ;i < 4; i ++)       //从四个方向分别判断
		{
			int nx = x + d[i][0];
			int ny = y + d[i][1];
			if(nx >= 1 && nx <= N && ny >= 1 && ny <= M && maze[nx][ny] != '#' && !mark[nx][ny]) //该方向能走且没走过
			{
				dfs(nx, ny);       //进行下一步判断
				mark[nx][ny] = false;  //走完则清除标记
			}
		}
		return ;
	}
}
