package MakeGame_0824;

import MakeGame_0824.MapBundle.DungeonFirstMap;

import MakeGame_0824.MapBundle.DungeonFirstMapReverse;
import MakeGame_0824.MapBundle.DungeonMap;
import MakeGame_0824.MapBundle.DungeonSecondMap;
import MakeGame_0824.MapBundle.VillageMap;
import MakeGame_0824.MapBundle.VillageMapDungeonEntrance;
import MakeGame_0824.MapBundle.VillageMapHouse;
import MakeGame_0824.MapBundle.VillageMapPlaza;

public class BulidGame
{
	DungeonMap d = new DungeonMap();
	VillageMap v = new VillageMap();
	void build() 
	{
		while(true)
		{
			while(true) 
			{
				if(v.getCurrentLocation()==0)
				{
					v  = new VillageMapHouse();
				}
				else if(v.getCurrentLocation()==1)
				{
					v  = new VillageMapPlaza();
				}
				else if(v.getCurrentLocation()==2)
				{
					v  = new VillageMapDungeonEntrance();
				}
				else if(v.getCurrentLocation()==100)
				{
					System.out.println("던전으로 들어갑니다");
					d.setFloor(1);
					v.setCurrentLocation(99);
					break;
				}
				else
				{
					break;
				}
				v.villageMapMove();
			}//마을 while 끝
			
			
			
			
			
				
			if(d.getFloor()==1) //층수조절
			{
				d= new DungeonFirstMap();
				d.MapSetting();
				//반복을 막기 위해 층수를 음수로 빼둡니다
			}
			else if(d.getFloor()==-1)
			{
				d= new DungeonFirstMapReverse();
				d.MapSetting();
			}
			else if(d.getFloor()==2)
			{
				d= new DungeonSecondMap();
				d.MapSetting();
			}
			
			while(true) 
			{	
				int floorTemp = d.getFloor();
				d.minimap();
				d.dungeonMapMove();
				
				if(floorTemp!=d.getFloor()) //층이바뀌면 다시
				{
					break;
				}
				
			}
			
			if(d.getFloor()==0)//출구로 나왔을때만
			{
				v.setCurrentLocation(2);
			}
			
			
			//종료 확인단
			
		}
	}
}
