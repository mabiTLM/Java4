package webClass_0829;

interface Human 
{	// API => Application Programming Interface
	// 프로그램과 프로그램 사이에 데이터를 전달해주는 녀석?
	// Web API / API 문서 프론트엔드와 백엔드도 다른 프로그램이다.
	// UI => User Interface => 화면에 보이는 거
	// Interface 는 어떠한 무언가와 어떠한 무언가를 연결하여 중간 과정에서 통신을 처리한다.
	// 간단히 말하면 서로 간에 대화를 가능하게 해준다.
	
	/**
	 * 이동하는 메서드
	 **/	
	void move();	//주석처리가능
}

interface Animal
{//interface == abstract class 비슷하다~
	void eat();
}

public sealed class Person
	implements Human,Animal
	permits YellowRace, WhiteRace
{
	String species;
	public static final int number = 1;
	
	Person()
	{
		species = "human";
	}
	
	
	@Override
	public void move() //추상화 됐어도 확실하게 퍼블릭인지 알려줘야한다.
	{
		System.out.println("사람이 움직인다");
	}
	
	@Override
	public void eat() {}
	
}
