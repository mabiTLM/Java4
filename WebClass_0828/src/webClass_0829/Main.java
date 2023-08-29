package webClass_0829;

public class Main 
{
	public static void main(String[] args)
	{
		YellowRace JKH = new YellowRace();
		JKH.move();
		Person[] people = new Person[] {JKH, new WhiteRace()}; //업캐스팅
		//JKH.skinColor; 은되지만
		//people[0].skinColor 은 안된다. Person[]를 갖게되서 Person이 가지고 있어야한다.
		people[0].move();
	}
}
