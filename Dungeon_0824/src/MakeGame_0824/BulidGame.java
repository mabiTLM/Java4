package MakeGame_0824;

import MakeGame_0824.CharacterBundle.MainPlayerCharacter;
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
	int money =10000;
	DungeonMap d = new DungeonMap();
	VillageMap v = new VillageMap();
	MainPlayerCharacter c = new MainPlayerCharacter();
	Battle b = new Battle();
	void build() 
	{	
		b.mainChar=c;
		//c.equip();//장비변경탭따로만들것
		
		
		while(true)
		{
			if(c.getHp()<=0)//죽엇을때 끝내기
			{
				break;
			}
			while(true) 
			{
				if(c.getHp()<=0)//죽엇을때 끝내기
				{
					break;
				}
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
			
			//던전입장
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
				if(c.getHp()<=0)//죽엇을때 끝내기
				{
					break;
				}
				int floorTemp = d.getFloor();
				d.minimap();
				d.dungeonMapMove();
				
				int ramdomEncount = (int)(Math.random()*100);//적 조우 확률
				if(ramdomEncount<30)
				{
					b.enemyEncount(); //적 조우
					b.setOwnedItem(c.getOwnedItem());//현재끼고있는 장비를 넣어준다
					while(true) 
					{
						System.out.println(c.getHp());
						b.battleChoice();//선택지
						if(b.getPlayerChoice()==1)
						{
							b.battleCalculator();
							if(b.getEnemyHP()<=0)
								{
								System.out.println("이겼다");
								money += b.getEnemyPrice();
								break;
								}
							b.enemyBattleCalculator();
							if(c.getHp()<=0)
							{
								System.out.print("당신은 죽었습니다.");
								break;
							}
						}
						
						else if(b.getPlayerChoice()==4)
						{
							System.out.println("도망쳤다");
							break;
						}
					}
				}				
				
				if(floorTemp!=d.getFloor()) //층이바뀌면 다시
				{
					break;
				}
				
			}//던전 while
			
			if(d.getFloor()==0)//출구로 나왔을때만
			{
				v.setCurrentLocation(2);
			}
			
			
			//종료 확인단
			
		}
	}
}
