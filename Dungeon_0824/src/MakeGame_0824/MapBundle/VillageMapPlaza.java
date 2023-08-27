package MakeGame_0824.MapBundle;

import java.util.Scanner;

import MakeGame_0824.CharacterBundle.MainPlayerCharacter;

public class VillageMapPlaza extends VillageMap

{
	public VillageMapPlaza(MainPlayerCharacter mainChar) {
		super(mainChar);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void villageMapMove()
	{
		setCurrentLocation(1);
		printMap();
		System.out.println("	ㄴ상점");
		Scanner scan = new Scanner(System.in);
		System.out.println("뭐를 할까요?");
		System.out.println("1.대화한다.");
		System.out.println("2.집으로");
		System.out.println("3.던전입구로");
		System.out.println("4.상점으로");
		System.out.println("5.인벤토리");
		
		
		String move = scan.nextLine();
		
		if(move.equals("1"))
		{
			System.out.println("던전에 가기전에 준비를 단단히 하고 가자");
		}
		else if(move.equals("2")|move.equals("집"))
		{
			setCurrentLocation(0);
		}
		else if(move.equals("3")|move.equals("던전입구"))
		{
			setCurrentLocation(2);
		}
		else if(move.equals("4")|move.equals("상점"))
		{
			setCurrentLocation(3);		
		}
		else if(move.equals("5"))
		{
			i.inventoryOpen(mainChar);
		}
		else
		{
			System.out.println("다시 입력해주세요");
		}
	}
}
