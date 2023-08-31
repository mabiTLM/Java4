package MakeGame_0824.MapBundle.Village;

import java.util.Scanner;

import MakeGame_0824.CharacterBundle.MainPlayerCharacter;
import MakeGame_0824.MapBundle.Dungeon.DungeonMap;
import MakeGame_0824.StoryBundle.StoryText;

public class VillageMapDungeonEntrance extends VillageMap 
{
	public VillageMapDungeonEntrance(MainPlayerCharacter mainChar) {
		super(mainChar);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void villageMapMove(DungeonMap d)
	{
		setCurrentLocation(2);
		printMap();
		Scanner scan = new Scanner(System.in);
		System.out.println("뭐를 할까요?");
		System.out.println("1.대화한다.");
		System.out.println("2.마을 광장으로");
		System.out.println("3.인벤토리");
		System.out.println("4.던전에 들어간다");
		System.out.println("5.스테이터스");
		
		String move = scan.nextLine();
		
		if(move.equals("1"))
		{
			int temp=(int)(Math.random()*(storyT.getDungeonEntranceStory().length-1)+1);
			System.out.println(storyT.getDungeonEntranceStory(temp));
		}
		
		else if(move.equals("2")|move.equals("마을 광장"))
		{
			setCurrentLocation(1);
		}
		
		else if(move.equals("3"))
		{
			i.inventoryOpen(mainChar,d);
		}
		else if(move.equals("집"))
		{
			setCurrentLocation(0);
		}
		else if(move.equals("상점"))
		{
			setCurrentLocation(3);		
		}	
		else if(move.equals("4"))
		{
			setCurrentLocation(100);
		}
		else if(move.equals("5"))
		{
			mainChar.status();
		}
		else
		{
			System.out.println("다시 입력해주세요");
		}
	}
}
