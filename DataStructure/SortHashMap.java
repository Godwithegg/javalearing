

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class SortHashMap
{
	public static void main(String[] args)
	{
		HashMap<Integer, User> user = new HashMap<>();
		user.put(2, new User("灿",13));
		user.put(1, new User("林", 12));
		user.put(3, new User("煌", 14));
		HashMap<Integer, User> sortUser = sortHashMap(user);

		System.out.println(sortUser);
	}
	
	
	public static HashMap<Integer, User> sortHashMap(HashMap<Integer, User> hash)
	{
		Set<Entry<Integer, User>> keyValue = hash.entrySet();
		List<Entry<Integer, User>> keyList = new ArrayList<>(keyValue);
		Collections.sort(keyList,new Comparator<Entry<Integer, User>>()
		{

			@Override
			public int compare(Entry<Integer, User> o1, Entry<Integer, User> o2)
			{
				return o1.getValue().getAge()-o2.getValue().getAge();
			}
			
		});
		LinkedHashMap<Integer, User> linkedHashMap = new LinkedHashMap<>();
		for (Entry<Integer, User> entry : keyList)
		{
			linkedHashMap.put(entry.getKey(), entry.getValue());
		}
		return linkedHashMap;
		
	}
}

class User
{
	private String name;
	private int age;
	public User(String name,int age)
	{
		this.age = age;
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	@Override
	public String toString()
	{
		return "User [name=" + name + ", age=" + age + "]";
	}
	
}