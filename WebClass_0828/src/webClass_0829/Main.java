package webClass_0829;


interface InterfaceTest {
	//얘는 왜 다중 상속이 가능할까? << 이름 밖에 없으니까
	/* public abstract */void methodTest();
	static void staticMethodTest() {
		System.out.println("정적 메서드 가능?!");
		privateStaticMehodeTest();
	}
	
	private void privateMehodeTest(){
		System.out.println("private 메서드 가능?!");
	}
	private static void privateStaticMehodeTest(){
		System.out.println("private 정적 메서드 가능?!");
	}
	
	static int add(int ...args)
	{
		return 1;
	}
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
