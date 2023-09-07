package webClass230907;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();//키와 데이터를 붙여준다. 키가 중복됐는지 체크한다.
		
		map.put("권",7);
		map.put("남",8);
		map.put("임",23);
		map.put("김",3);
		map.put("가",3);
		map.put("나",3);
		map.put("다",3);
		map.put("라",3);
		map.put("정",7);
		System.out.println(map);
		System.out.println(map.size());		
		System.out.println(map.get("정"));//이름이 있기에 이름으로 가져 올 수 있다.
		map.put("정", 13);
		System.out.println(map.size());		
		System.out.println(map.get("정"));//값은 바뀐다.
		map.remove("정");
		
		Set<String> keySet = map.keySet();//키를 셋으로 가져온다.
		System.out.println(keySet);
		Iterator<String> iterator = keySet.iterator();//주소
		System.out.println(iterator.next());//넣는 순서가 랜덤이다
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
	}
}
