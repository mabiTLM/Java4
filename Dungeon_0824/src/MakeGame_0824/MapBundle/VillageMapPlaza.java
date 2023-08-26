package MakeGame_0824.MapBundle;

import java.util.Scanner;

public class VillageMapPlaza extends VillageMap

{
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
			setCurrentLocation(3);		
		}
		else if(move.equals("5"))
		{
			i.inventoryOpen(c);
		}
	}
}
