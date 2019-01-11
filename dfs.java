package cn.itcast.mytest;

import java.util.Scanner;

public class sercert
{
	static int MAX = 1024;
	static char [][] maze = new char[sercert.MAX][sercert.MAX];
	static boolean [][] mark = new boolean[sercert.MAX][sercert.MAX];
	static boolean flag ;
	static int [][] d = {{1,0},{0,1},{-1,0},{0,-1}};
	static int N;
	static int M;
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		in.nextLine();
		for(int i = 1 ; i <= N ;i ++)
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
		dfs(1, 1);
		System.out.println(flag);
	}
	public static void dfs(int x,int y)
	{
		mark[x][y] = true;
		if(x == N && y == M)
		{
			flag = true;
			return ;
		}
		for(int i = 0 ;i < 4; i ++)
		{
			int nx = x + d[i][0];
			int ny = y + d[i][1];
			if(nx >= 1 && nx <= N && ny >= 1 && ny <= M && maze[nx][ny] != '#' && !mark[nx][ny])
			{
				dfs(nx, ny);
				mark[nx][ny] = false;
			}
		}
		return ;
	}
}