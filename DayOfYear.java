
import java.util.Calendar;
import java.util.Scanner;

/**
 * 计算当天是一年中的第几天
 * @author danhuang
 *
 */
public class DayOfYear{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int year = in.nextInt();
		int month = in.nextInt();
		int day = in.nextInt();
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month-1, day);
		System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
	}
}