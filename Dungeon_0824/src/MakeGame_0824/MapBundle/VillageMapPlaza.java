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
		
		String move = scan.nextLine();
		
		if(1==Integer.valueOf(move))
		{
			System.out.println("어디가니?");
		}
		
		if(2==Integer.valueOf(move))
		{
			setCurrentLocation(0);
		}
		if(3==Integer.valueOf(move))
		{
			setCurrentLocation(2);
		}
	}
}
