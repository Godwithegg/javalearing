
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

/**
 * hashmap统计所有单词总数，只包括单词和空格
 * @author danhuang
 *
 */
@SuppressWarnings("all")
public class CountWord {
	public static void main(String[] args) {
		HashMap<String, Integer> hashMap = new HashMap<>();
		Scanner in = new Scanner(System.in);
		String key = null;
		while(!(key = in.next()).equals("#")) {
			if(hashMap.get(key) != null && !key.equals(" ")) {
				hashMap.put(key, hashMap.get(key)+1);
			}else if(!key.equals(" ")) {
				hashMap.put(key, 1);
			}
		}
		int total = 0;
		Set<Entry<String, Integer>> set = hashMap.entrySet();
		for (Entry<String, Integer> entry : set) {
			total ++;
		}
		System.out.println(total);
	}
}