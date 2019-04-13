package cn.itcast.mytest;


public class sercert
{
	public static void main(String[] args)
	{
		System.out.println(quickPow(2, 10, 100));      //test
	}
	public static int quickPow(int a,int b,int mod)    //快速幂解a^b%mod a≠0
	{
		if(b == 0) return 1;   //如果这个数是0次方
		int s = 0;
		s = a;
		b --;
		while(b > 0)
		{
			if(b % 2 == 0)
			{
				b = b >> 1;           //如果现在还是偶次幂，则减半
				a = a * a % mod;      //将底数乘方
			}
			else 
			{
				s = s * a % mod;      //奇数幂的话则提取一个底数，乘上总数
				b --;                 //指数-1
			}
			
		}
		return s;          //返回快速幂结果
	}
}