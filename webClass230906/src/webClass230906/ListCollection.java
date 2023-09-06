package webClass230906;

import java.util.LinkedList;
import java.util.List;

public class ListCollection {
	
	public static void main(String[] args)
	{
		//LinkedList
		//노드끼리의 주소 포인터를 서로 가리키고 있음.
		//하나의 노드에는 데이터와 다음 노드를 가리키는 포인터가 있다.
		//중간에 데이터를 insert, delete하기에 유용하다.
		//하지만 특정 위치에 빠르게 엑세스를 하려면 순차적으로 탐색해야하는 단점이 있다.
		
		List<String> linkedList=new LinkedList<>();
		linkedList.add("사과");
		linkedList.add("바나나");
		linkedList.add("체리");
		
		System.out.println("링크드 리스트 순회하기");
		for(String fruit : linkedList)
		{
			System.out.println(fruit);
		}
		linkedList.add(1,"오렌지");//특정위치
		linkedList.remove("바나나");//삭제
		
		String elem=linkedList.get(2);
		System.out.println("2번째 :"+elem);
		
		System.out.println("사이즈 : " +linkedList.size());
		
		boolean isApple=linkedList.contains("사과");
		System.out.println(isApple);
		
		Object[] array = linkedList.toArray();
		
		for(Object object : array)
		{
			System.out.println(object.toString());
		}
		
		linkedList.clear();
		System.out.println("비어있냐? : "+linkedList.isEmpty());
	}

}
