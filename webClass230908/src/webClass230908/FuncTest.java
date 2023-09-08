package webClass230908;

public class FuncTest {
	public static void test() {
//		PrintTest t = new PrintTest() {
//			@Override
//			public void print() {
//				System.out.println("인터페이스로 클래스를 바로 생성한다.");
//			}
//		};
//		
//		t.print();
//		action(()->{
//			System.out.println("람다 테스트");
//		});
//		action((name)->{
//			System.out.println("람다 테스트");
//		});
		
		action(new FuncTest() :: print);//이렇게 쓰면 주소만 갖고와서 따로만들 수 있다.
		
		action1((name)->{
			System.out.println("임");
		}
		);
	}

	private static void action(PrintTest printTest) {
		printTest.print("권");
	}
	private static void action1(PrintTest printTest) {
		printTest.print("임");
	}
	
	private void print(String name) //그냥 메서드라 안된다.
	{
		System.out.println(name+"람다 테스트");
	}
	
//	private static void print() //그냥 메서드라 안된다.
//	{
//		printTest.print("권");
//	}
}
