package cn.itcast.mytest;

public class binarySearch
{
	static int[] a = {1,3,4,6,7,9,11};
	static int findvalue = 6;               //欲查找的值
	public static void main(String[] args)
	{
		int index = binarySearch(0, a.length, findvalue);     //下标
		System.out.println(index);
	}
	public static int binarySearch(int left,int right,int key)
	{
		int mid = (left + right) / 2;
		if(a[mid] == findvalue)
		{
			return mid;
		}
		else if(a[mid] > key)
		{
			right = mid - 1;
		}
		else left = mid + 1;
		return binarySearch(left, right, key);
		
	}
	
}