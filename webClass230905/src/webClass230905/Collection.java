package webClass230905;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Collection {
	
	public static void main(String[] args)
	{
		//컬렉션
		//동일한 데이터 타입을 묶어 관리하는 자료구조
		//데이터 저장 공간의 크기가 동적으로 변한다.
		
		//1.List
		//배열이랑 비슷함
		//자바에서 인터페이스로 구현되어 있음.
		//ArrayList, Vector, LinkedList등과 같은 클래스가
		//List인터페이스를 구현한다.
		
		//1.1 ArrayList
		//List인터페이스를 구현한 클래스중 하나.
		//동적배열로 구현되어 크기를 동적으로 조절가능
		//요소에 빠르게 접근가능, 추가하거나 제거할때 자동으로 크기를 조절한다.
		
		//List는 인터페이스로써 리스트 동작을 정의.
		//ArrayList는 List를 상속받는다.
		
		//알아야 할것 : ArrayList랑 Array 차이
		
		String[] arrStrings=new String[] {"가","나","다","라","마"};
		arrStrings[1]=null;
		arrStrings[2]=null;
		
		for(int i=0; i <arrStrings.length; i++)
		{
			System.out.println(arrStrings[i]);
		}
		
		List<String> arrList= new ArrayList<>();
		arrList.add("가");
		arrList.add("나");
		arrList.add("다");
		arrList.add("라");
		arrList.add("마");
		arrList.add("바");
		arrList.add("사");
		arrList.add("라");
		System.out.println("데이터 추가후 : " + arrList.size());
		
		for(String string : arrList)
		{
			System.out.println(string);
		}
		arrList.remove("바");
		arrList.remove("다");
		System.out.println("===================");
		for(String string : arrList)
		{
			System.out.println("데이터 삭제후 : "+string);
		}
		arrList.add("경일");
		for(String string : arrList)
		{
			System.out.println(string);
		}
		int index = 2;
		String element = arrList.get(index);
		System.out.println("인데스 : "+index+" 요소 : "+element);
		
		String target = "경일";
		boolean contains = arrList.contains(target);
		
		if(contains) {
			System.out.println(target+"을 찾았다.");
		}
		else {
			System.out.println("없음");
		}
		
		//add : 요소추가->뒤, 지정된 인덱스
		//remove : 삭제 -> 인덱스,Object
		//clear : 모든 데이터 삭제
		//get : 내가 지정한 인덱스의 데이터를 리턴
		//indexOf : 지정된 요소의 첫번째 등장 위치 리턴
		//lastIndexOf : 지정된 요소의 마지막 위치 리턴
		//contains : 있냐 없냐?
		
		//size : 길이
		//isEmpty : 비어있냐 없냐?
		//trimToSize : 안쓰는 데이터 삭제
		
		//sort : 정렬
		//reverse : 반전
		
		//List<String> myList = new ArrayList<>();
		List<String> myList = new LinkedList<>();
		//ArrayList<String>MyList1 = new ArrayList<>();
		//큰 차이는 나지 않지만 유연성이 약간 다르다. List가 인터페이스라서 더 유연하고 일반적인 방법이다.
		
	}

}


