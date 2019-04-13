
import java.util.Scanner;

public class HashmapSort {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i = 0;i < n ; i ++) {
			System.out.println(fibonacci(i));
		}
	}

	public static int fibonacci(int a) {
		if(a < 2)
			return 1;
		return fibonacci(a-1)+fibonacci(a-2);
	}

}