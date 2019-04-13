
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
/**
 * 
* 类名称：Binary_conversion
* 类描述：输入两个十进制整数分别为要转化的数和转化的进制 
* 创建人：林灿煌
* 创建时间：2019年2月7日 下午7:45:30 
* @version
 */
public class Binary_conversion
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		Stack<Integer> a = new Stack<>();
		while(n > 0)
		{
			a.push(n%k);
			n /= k;
		}
		while(!a.empty())
		{
			int b = a.pop();
			if(b<10)
				System.out.print(b);
			else
				System.out.print((char)(55+b));
		}
	}
}