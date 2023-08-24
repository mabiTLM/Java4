package MakeGame_0824;

import java.util.Scanner;

public class VillageMapDungeonEntrance extends VillageMap 
{
	@Override
	void villageMapMove()
	{
		setCurrentLocation(2);
		printMap();
		Scanner scan = new Scanner(System.in);
		System.out.println("뭐를 할까요?");
		System.out.println("1.대화한다.");
		System.out.println("2.마을 광장으로");
		System.out.println("3.던전에 들어간다");
		
		String move = scan.nextLine();
		
		if(1==Integer.valueOf(move))
		{
			System.out.println("던전이다");
		}
		
		if(2==Integer.valueOf(move))
		{
			setCurrentLocation(1);
		}
		if(3==Integer.valueOf(move))
		{
			setCurrentLocation(100);
		}
	}
}
