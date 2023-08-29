package webClass_0829;


interface InterfaceTest {
	
	/*public static final*/int NUMBER = 1; //상수는 대문자로 적는다.
	
	//얘는 왜 다중 상속이 가능할까? << 이름 밖에 없으니까
	/* public abstract */void methodTest();
	static void staticMethodTest() {
		System.out.println("정적 메서드 가능?!");
		privateStaticMethodTest();
	}
	
	private void privateMethodTest(){
		System.out.println("private 메서드 가능?!");
	}
	private static void privateStaticMethodTest(){
		System.out.println("private 정적 메서드 가능?!");
	}
	
	static int add(int ...args)
	{
		return 1;
	}
	
	
	default void defaultMethodTest() {
		privateMethodTest();
	}
}

class ClassTest implements InterfaceTest
{
	@Override
	public void methodTest() {}
	
//	@Override
//	public	void defaultMethodTest() {
//		InterfaceTest.super.defaultMethodTest(); //내부적 내용이 있기에 무조건 한번 실행해야한다. 다중상속이 가능하기에 누구것인지 적는다.
//	}
	
}


public class Main 
{
	public static void main(String[] args)
	{
		InterfaceTest.staticMethodTest();
		YellowRace JKH = new YellowRace();
		JKH.move();
		Person[] people = new Person[] {JKH, new WhiteRace()}; //업캐스팅
		//JKH.skinColor; 은되지만
		//people[0].skinColor 은 안된다. Person[]를 갖게되서 Person이 가지고 있어야한다.
		//people[0].move();
		
	}
}
