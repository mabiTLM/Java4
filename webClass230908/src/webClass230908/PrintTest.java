package webClass230908;

@FunctionalInterface
public interface PrintTest {//비어있는 public은 하나밖에 넣을 수 없다.
	void print(String name);
	
	public default int test() {//default가 써진건 이미 코드가 적혀있기에 상관없다.
		return 1;
	}
}
