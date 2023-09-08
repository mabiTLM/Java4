package webClass230908;

import java.util.Collection;
import java.util.stream.Stream;

public class StreamModule <T extends Collection>{
	
	public Stream<T> changeStream(T t)
	{
		Stream<T> result = t.stream();
		return result;
	}

}
