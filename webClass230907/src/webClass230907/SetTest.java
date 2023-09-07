package webClass230907;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) 
	{
		Set<Integer> set = new HashSet<>();
		set.add(1);
		System.out.println(set.size());
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		set.remove(3);
		set.add(1);
		System.out.println(set.size());
		//System.out.println(set[0]); 배열이 아니기에 불가능
		
		Iterator<Integer> iterator = set.iterator();//주소
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.hasNext());
		set.clear();
		System.out.println(set.size());
	}
}
