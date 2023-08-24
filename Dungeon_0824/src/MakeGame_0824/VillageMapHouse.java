package MakeGame_0824;

import java.util.Scanner;

public class VillageMapHouse extends VillageMap
{
	@Override
	void villageMapMove()
	{
		setCurrentLocation(0);
		printMap();
		Scanner scan = new Scanner(System.in);
		System.out.println("뭐를 할까요?");
		System.out.println("1.대화한다.");
		System.out.println("2.마을 광장으로");
		
		String move = scan.nextLine();
//		if(move.replaceAll("[0-9]","").isEmpty())
		
		if(1==Integer.valueOf(move))
		{
			System.out.println("안녕!");
		}
		
		if(2==Integer.valueOf(move))
		{
			setCurrentLocation(1);
		}
	}
}
