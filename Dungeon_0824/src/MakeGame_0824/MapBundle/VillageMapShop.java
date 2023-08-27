package MakeGame_0824.MapBundle;

import java.util.Scanner;

import MakeGame_0824.CharacterBundle.MainPlayerCharacter;

public class VillageMapShop extends VillageMap 
{
	public VillageMapShop(MainPlayerCharacter mainChar) {
		super(mainChar);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void villageMapMove()
	{
		setCurrentLocation(3);
		printMap();
		Scanner scan = new Scanner(System.in);
		System.out.println("뭐를 할까요?");
		System.out.println("1.대화한다.");
		System.out.println("2.마을 광장으로");
		System.out.println("3.구매한다");
		System.out.println("4.판매한다");
		System.out.println("5.인벤토리");
		
		String move = scan.nextLine();
		
		if(move.equals("1"))
		{
			System.out.println("물건 좀 사고갈래?");
		}
		
		else if(move.equals("2")|move.equals("마을 광장"))
		{
			setCurrentLocation(1);
		}
		
		else if(move.equals("3"))
		{
			i.buyItem(mainChar);
		}
		else if(move.equals("4"))
		{
			i.sellItem(mainChar);
		}		
		
		else if(move.equals("5"))
		{
			i.inventoryOpen(mainChar);
		}
		else if(move.equals("집"))
		{
			setCurrentLocation(0);
		}
		else if(move.equals("던전입구"))
		{
			setCurrentLocation(2);
		}
		else
		{
			System.out.println("다시 입력해주세요");
		}
	}
	
	@Override
	void printMap()
	{
		for(int i = 0; i < getMap().length; i++)
		{
				System.out.print(getMap()[i]);
				if(i!=getMap().length-1) 
				{
					System.out.print("-");
				}
		}
		System.out.println();
		System.out.println("	ㄴ[상점]");
	}

}
