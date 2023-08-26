package MakeGame_0824.MapBundle;

import java.util.Scanner;

public class VillageMapHouse extends VillageMap
{
	
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
		while(true) 
		{
			if(move.isEmpty()==false&move.replaceAll("[0-9]","").isEmpty()) 
			{
				break;
			}
			else
			{
				System.out.println("숫자만 입력해주세요");
				move = scan.nextLine();
			}
		}
		
		if(1==Integer.valueOf(move))
		{
			System.out.println("안녕!");
		}
		
		else if(2==Integer.valueOf(move))
		{
			setCurrentLocation(1);
		}
		else if(3==Integer.valueOf(move))
		{
			i.inventoryOpen(c);
		}
		else if(4==Integer.valueOf(move))
		{
			c.setHp(300);
			c.setMp(10);
			c.setSp(10);
		}
		else
		{
			System.out.println("다시 입력해주세요");
		}
	}
}
