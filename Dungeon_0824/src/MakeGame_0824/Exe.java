package MakeGame_0824;

public class Exe 
{
	public static void main(String[] args)
	{
//		MainPlayerCharacter m = new MainPlayerCharacter();		
//		m.Status();
		VillageMap v = new VillageMap();


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
			v.villageMapMove();
		}
	}

}
