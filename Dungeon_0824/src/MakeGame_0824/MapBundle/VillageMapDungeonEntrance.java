package MakeGame_0824.MapBundle;

import java.util.Scanner;

public class VillageMapDungeonEntrance extends VillageMap 
{
	@Override
	public void villageMapMove()
	{
		setCurrentLocation(2);
		printMap();
		Scanner scan = new Scanner(System.in);
		System.out.println("뭐를 할까요?");
		System.out.println("1.대화한다.");
		System.out.println("2.마을 광장으로");
		System.out.println("3.인벤토리");
		System.out.println("4.던전에 들어간다");
		
		String move = scan.nextLine();
		
		if(move.equals("1"))
		{
			System.out.println("던전이다");
		}
		
		else if(move.equals("2"))
		{
			setCurrentLocation(1);
		}
		
		else if(move.equals("3"))
		{
			i.inventoryOpen(c);
		}
		
		
		else if(move.equals("4"))
		{
			setCurrentLocation(100);
		}
	}
}
