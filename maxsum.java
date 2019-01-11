package cn.itcast.mytest;

public class sercert
{
	public static void main(String[] args)
	{
		int [] a = {6,-3,-2,7,-15,1,2,2};      //定义一个任意数组
		int [] dp = new int[1024];              //用来判断每一次求和的数组
		int maxsum = a[0]; 
		for(int i = 0 ; i < a.length; i ++)      //循环遍历一次数组
		{
			if(dp[i] + a[i] < 0)                //如果这个数组 前n个和+当前数<0 那么就没有加的必要了
			{
				dp[i+1] = a[i];                    //重新计数判断,令这个负数为起止位是防止原数组全负的情况
			}
			else dp[i+1] =  dp[i] + a[i];     //否则加上当前数
			if(dp[i+1] > maxsum)              //如果此时数列和大于假定的最大数，那么替换
			{
				maxsum = dp[i+1];              
			}
		}
		System.out.println(maxsum);          //输出最大数
	}
}