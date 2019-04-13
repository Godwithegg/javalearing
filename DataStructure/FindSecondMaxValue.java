/*
*	o(n)查找数组中第二大的值
*/
public class FindSecondMaxValue
{
	public static void main(String[] args)
	{
		int[] a = {9,9,4,6,6,6,3,5,7,7,7,7,8,7};  //测试数据
		int max1 = a[0];
		int max2 = -Integer.MIN_VALUE;
		int j = 0;
		for(j = 1; j < a.length ; j++)
		{
			if(a[j] == max1)
				continue;
			else
			{
				max2 = a[j];
				break;
			}
		}
		if(max1 < max2)
		{
			int temp = max1;
			max1 = max2;
			max2 = temp;
		}
		for(int i = j ; i < a.length ; i++)
		{
			if(a[i] > max2)
			{
				if(a[i] > max1)
				{
					int temp = max1;
					max1 = a[i];
					a[i] = temp;
				}
				else
				{
					int temp = max2;
					max2 = a[i];
					a[i] = temp;
				}
			}
		}
		System.out.println(max2);
	}
}
