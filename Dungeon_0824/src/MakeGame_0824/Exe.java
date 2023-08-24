package MakeGame_0824;

public class Exe 
{
	public static void main(String[] args)
	{
//		BulidGame b= new BulidGame();
//		b.build();
		
		//스텟 테스트
//		MainPlayerCharacter m = new MainPlayerCharacter();		
//		m.Status();
		
		//이동테스트
//		VillageMap v = new VillageMap();
//
//
//		while(true) 
//		{
//			if(v.getCurrentLocation()==0)
//			{
//				v  = new VillageMapHouse();
//			}
//			else if(v.getCurrentLocation()==1)
//			{
//				v  = new VillageMapPlaza();
//			}
//			else if(v.getCurrentLocation()==2)
//			{
//				v  = new VillageMapDungeonEntrance();
//			}
//			v.villageMapMove();
//		}

		//미니맵테스트
//		DungeonMiniMap d =new DungeonMiniMap();
//		d.minimap();
		
		MainPlayerCharacter c = new MainPlayerCharacter();
		c.equip();
		
		System.out.println("현재 장착한 아이템은 ");
		for(int i = 0; i < c.getOwnedItem().length;i++)
		{
			System.out.println();
		}
		
	}

}
