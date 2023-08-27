package MakeGame_0824.MapBundle;

import java.util.Scanner;

import MakeGame_0824.CharacterBundle.MainPlayerCharacter;

public class VillageMapHouse extends VillageMap
{
	
	public VillageMapHouse(MainPlayerCharacter mainChar) {
		super(mainChar);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void villageMapMove()
	{
		setCurrentLocation(0);
		printMap();
		Scanner scan = new Scanner(System.in);
		System.out.println("뭐를 할까요?");
		System.out.println("1.대화한다.");
		System.out.println("2.마을 광장으로");
		System.out.println("3.인벤토리");
		System.out.println("4.휴식한다");
		String move = scan.nextLine();
		
		if(move.equals("1"))
		{
			System.out.println("안녕!");
		}
		
		else if(move.equals("2"))
		{
			setCurrentLocation(1);
		}
		else if(move.equals("3"))
		{
			i.inventoryOpen(mainChar);
		}
		else if(move.equals("4"))
		{
			mainChar.setHp(300);
			mainChar.setMp(10);
			mainChar.setSp(10);
		}
		else
		{
			System.out.println("다시 입력해주세요");
		}
	}
}
