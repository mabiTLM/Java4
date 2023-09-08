package webClass230908;

import java.util.Collection;
import java.util.stream.Stream;

public class StreamModule <T extends Collection>{
	
	private T t;
	
	public Stream<T> changeStream(T t)//넣은걸 스트림으로 바꿔서 리턴한다.
	{
		this.t=t;
		Stream<T> result = t.stream();
		return result;
	}
	
	public void print(T t)//넣은걸 스트림으로 바꿔서 출력한다.
	{
		this.t=t;
		Stream<T> result = t.stream();
		result.forEach(item->System.out.println(item));
	}
	
	
//	@Override
//	public String toString() //제네릭이면 내부에서 바뀌긴힘들것같다.
//	{
//		return t+"";
//	}

}
