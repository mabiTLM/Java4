package MakeGame_0824.MapBundle;

import java.util.Scanner;

public class VillageMapPlaza extends VillageMap

{
	@Override
	public void villageMapMove()
	{
		setCurrentLocation(1);
		printMap();
		System.out.println("	ㄴ장비 상점-소모품상점");
		Scanner scan = new Scanner(System.in);
		System.out.println("뭐를 할까요?");
		System.out.println("1.대화한다.");
		System.out.println("2.집으로");
		System.out.println("3.던전입구로");
		System.out.println("4.장비 상점으로");
		System.out.println("5.소모품 상점으로");
		System.out.println("6.인벤토리");
		
		
		String move = scan.nextLine();
		
		if(move.equals("1"))
		{
			System.out.println("어디가니?");
		}
		else if(move.equals("2"))
		{
			setCurrentLocation(0);
		}
		else if(move.equals("3"))
		{
			setCurrentLocation(2);
		}
		else if(move.equals("4"))
		{
		
		}
		else if(move.equals("5"))
		{
			
		}
		else if(move.equals("6"))
		{
			i.inventoryOpen(c);
		}
	}
}
