package webClass230908;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest
{
	public static void test()
	{
		Set<String> set = new HashSet<String>();
		set.add("권");
		set.add("임");
		set.add("김");
		set.add("이");
		set.add("남");
		set.add("송");
		set.add("박");
		set.add("한");
		set.add("주");
//		set.toArray();
		Stream<String> stream = set.stream();
		stream.forEach(item->System.out.println(item));//매개변수하나라 ()괄호가 필요없고 한번돌려서 {}가없다
		
		
		List<String> list = new ArrayList();
		
		list.add("권");
		list.add("임");
		list.add("김");
		list.add("이");
		list.add("남");
		list.add("송");
		list.add("박");
		list.add("한");
		list.add("주");
		
		Stream<String> stream1 = list.stream();
		stream1.forEach(item->System.out.println(item));//매개변수하나라 ()괄호가 필요없고 한번돌려서 {}가없다
		
		Set<Student> students = new HashSet<Student>();
		students.add(new Student("권",85));
		students.add(new Student("임",98));
		students.add(new Student("김",90));
		students.add(new Student("이",80));
		students.add(new Student("남",90));
		students.add(new Student("송",70));
		students.add(new Student("박",75));
		students.add(new Student("한",100));
		students.add(new Student("주",80));
		
		Stream<Student> stream2 = students.stream();
		IntStream scores = stream2.mapToInt(item->item.getScore()).map(i->-i).sorted().map(i->-i);
		
//		stream2.forEach(item->System.out.println(item.getName() + " : " +item.getScore()));//매개변수하나라 ()괄호가 필요없고 한번돌려서 {}가없다
//		stream2.forEach(item->System.out.println(item.toString()));
		//scores.forEach(item->System.out.println(item));
		
		double avg = scores.average().getAsDouble();
		
		System.out.println("avg : "+avg);
		
		IntStream scoresDis = students.stream().mapToInt(item->item.getScore()).distinct();
		//int[] temp = scoresDis.toArray();
		scoresDis.forEach(item->System.out.print(item+ ", "));
		System.out.println();
		
		Stream<Student> stream3 = students.stream().sorted(Comparator.reverseOrder());
		stream3.forEach(item->System.out.println(item));
		
		System.out.println();
		//Stream<Student> stream4 = students.stream().filter(item->item.getName().startsWith("김"));
		Stream<Student> stream4 = students.stream().filter(item->{return item.getScore()>avg;});
		//필터안에 들어있는 람다식은 boolean값을 내보낸다.
		stream4.forEach(item->System.out.println(item));
		
		//스트림을 일일히 안만들어도된다? 그냥 매게변수 넣으면 새로운거 리턴해주는거 만드는건가?
	}
}
