package MakeGame_0824;

public class BulidGame
{
	DungeonMiniMap d = new DungeonMiniMap();
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
					break;
				}
				v.villageMapMove();
			}//마일 while 끝
			
			
			System.out.println("던전으로 들어갑니다");
			while(true) 
			{
				d.minimap();
				d.dungeonMapMove();
				System.out.println("이벤트");
			}
			
			
			//종료 확인단
			
		}
	}
}
