package webClass230908;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ModuleTest {
	
	public static void main(String[] args)
	{
		StreamModule<ArrayList> test = new StreamModule();
		List<String> arr = new ArrayList();
		
		arr.add("확인용");
		
		for(String output : arr)
		{
			System.out.println(test.changeStream(output));
		}
	}

}
