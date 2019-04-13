package cn.itcast.mytest;

public class sercert
{
	public static void main(String[] args)
	{
		int[] a = new int[] {2,3,4,1,2,4,6,3};
		int start = 0;
		int end = a.length-1;
		quickSort(a,start,end);
		for (int i : a)
		{
			System.out.print(i+" ");
		}
	}
	public static void quickSort(int[] a,int low,int high)
	{
		int start = low;
		int end = high;
		int key = a[low];
		while(start < end)   //一次排序  从后面开始
		{
			while(start < end && a[end] >= key)   //比关键值大的话，顺序不发生改变
			{
				end--;      //尾指针减一
			}
			if(key >= a[end])      //条件不满足的话交换
			{
				int temp = a[start];
				a[start] = a[end];
				a[end] = temp;
			}
			while(start < end && a[start] <= key)   //然后从前面开始，比比关键值小的
			{
				start++;
			}
			if(key <= a[start])    
			{
				int temp = a[start];
				a[start] = a[end];
				a[end] = temp;
			}
		}
		if(low < start)       //跑动的是start和end，因此应该是(low,start)和(end,high)这两个递归
		quickSort(a, low, start-1);       //递归求解
		if(end < high)
		quickSort(a, end+1, high);
	}
}
