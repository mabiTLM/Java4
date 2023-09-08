package webClass230908;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ModuleTest {
	
	public static void main(String[] args)
	{
		Stream streamTest;
		StreamModule<List> test = new StreamModule();
		List<ArrayList> arr = new ArrayList();
		List<String> str = new ArrayList();
		str.add("이건되나?");
		str.add("형태가 어떤거지");
		arr.add((ArrayList) str);
		
		for(ArrayList output : arr)
		{
			System.out.println(output);
		}
		streamTest = test.changeStream(arr);//스트림으로 바꿔주는 거 완료
		
		test.changeStream(arr).forEach(item->System.out.println(item));//스트림을 따로 정의 안해줘도되는 이 모양이 그나마 가장 나은듯하다.
		streamTest.forEach(item->System.out.println(item));
		//streamTest.forEach(item->System.out.println(item)); 이것도 결국 2연속은 안되니까 매번 다시 만들어줘야한다.
		
		test.print(arr);//그냥 이렇게 쓰면될것같다.
	}

}
