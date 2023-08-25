package MakeGame_0824;

import MakeGame_0824.CharacterBundle.MainPlayerCharacter;

public class Exe 
{
	public static void main(String[] args)
	{
		BulidGame b= new BulidGame();
		b.build();
		
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
//		DungeonFirstMap d =new DungeonFirstMap();
//		d.MapSetting();
//		d.minimap();
//		d.dungeonMapMove();
		
		//장비장착테스트
//		MainPlayerCharacter c = new MainPlayerCharacter();
//		c.equip();
//		OwnedItem[] i = c.getOwnedItem(); //주소값이!!!
//		System.out.println(i[0].getItemName());
            
        
		
	}

}
