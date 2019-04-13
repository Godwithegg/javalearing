package cn.itcast.mytest;

public class sercert
{
	private static int[] a = new int[10005];         //筛选素数的数组，1为素数，默认0为合数
	private static int [] dp = new int[10005];         //排除素数的数组
	private final static int N = 10000;                  //想要找的素数范围
	public static void main(String[] args)
	{
		primeInit();
		for(int i = 0; i <= 100 ;i ++)                   //输出0-100的素数测试代码是否正确
		{
			if(sercert.a[i] == 1)
				System.out.print(i+" ");
		}
	}
	public static void primeInit()
	{
		for(int i = 2;i <= sercert.N ; i++)          //从2开始到N筛选出素数
		{
			if(sercert.dp[i] == 1)continue;           //如果这个数已经被排除掉了
				sercert.a[i] = 1;             //这个数是素数
			for(int j = 0; j*i < N; j += sercert.a[i])          //含有因式a[i]的项排掉
			{
				sercert.dp[i*j] = 1;
			}
		}
	}
}