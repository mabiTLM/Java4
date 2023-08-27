package MakeGame_0824.MapBundle;

import MakeGame_0824.Inventory;
import MakeGame_0824.CharacterBundle.MainPlayerCharacter;

public class VillageMap 
{
	public MainPlayerCharacter mainChar;
	public Inventory i = new Inventory();
	private String[] map = {"집","마을 광장","던전입구"};
	
	private int currentLocation = 0;
	
	public VillageMap(MainPlayerCharacter mainChar)
	{
		this.mainChar=mainChar;
	}
	
	public void villageMapMove() // 공통부분 일부만 만들고 상속받아서 오버라이드
	{
		setCurrentLocation(0);
		printMap();
		System.out.println("뭐를 할까요?");
		System.out.println("1.대화한다.");
		//나중에 숫자 이외 입력시 예외처리 넣을곳
	}
	
	
	void printMap() 
	{
		for(int i = 0; i < map.length; i++)
		{
			if(map[currentLocation].equals(map[i]))
			System.out.print("["+map[currentLocation]+"]");
			else
			{
				System.out.print(map[i]);
			}
			if(i!=map.length-1) 
			{
				System.out.print("-");
			}
		}
		System.out.println();
	}
	
	
	
	public void setCurrentLocation(int location) 
	{
		currentLocation=location;
	}
	
	public int getCurrentLocation() 
	{
		return currentLocation;
	}
	
	public String[] getMap() 
	{
		return map;
	}
}
