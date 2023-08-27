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
import MakeGame_0824.MapBundle.VillageMapShop;

public class BulidGame
{
	MainPlayerCharacter mainChar = new MainPlayerCharacter();
	DungeonMap d = new DungeonMap();
	VillageMap v = new VillageMap(mainChar);	
	Battle b = new Battle(mainChar);
	void build()
	{
		while(true)
		{
			if(mainChar.getHp()<=0)//죽엇을때 끝내기
			{
				break;
			}
			while(true) 
			{
				if(mainChar.getHp()<=0)//죽엇을때 끝내기
				{
					break;
				}
				System.out.println("현재소지금"+mainChar.getMoney());
				if(v.getCurrentLocation()==0)
				{
					v  = new VillageMapHouse(mainChar);
				}
				else if(v.getCurrentLocation()==1)
				{
					v  = new VillageMapPlaza(mainChar);
				}
				else if(v.getCurrentLocation()==2)
				{
					v  = new VillageMapDungeonEntrance(mainChar);
				}
				else if(v.getCurrentLocation()==3)
				{
					v  = new VillageMapShop(mainChar);
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
				if(mainChar.getHp()<=0)//죽엇을때 끝내기
				{
					break;
				}
				System.out.println("현재소지금"+mainChar.getMoney());
				int floorTemp = d.getFloor();
				d.minimap();
				d.dungeonMapMove();
				
				// 여기 밑에서부터 전투인데 통채로 뜯어서 클래스화 가능해보입니다. 배틀클래스가 너무 길기에 적행동을 나누는게 좋아보입니다.
				int ramdomEncount = (int)(Math.random()*100);//적 조우 확률
				if(ramdomEncount<20)
				{
					b.enemyEncount(); //적 조우
					b.setOwnedItem(mainChar.getOwnedItem());//현재끼고있는 장비를 넣어준다
					b.setOwnedSkill(mainChar.getOwnedSkill());
					while(true) 
					{
						b.battleChoice();//싸움 선택지
						if(b.getPlayerChoice()==1)
						{
							b.battleCalculator();
							if(b.getEnemyHP()<=0)
								{
								System.out.println("이겼다");
								mainChar.setMoeny(mainChar.getMoney()+b.getEnemyPrice()); 
								b.battelFinish();
								break;
								}
							b.enemyBattleCalculator();
							if(mainChar.getHp()<=0)
							{
								System.out.print("당신은 죽었습니다.");
								break;
							}
						}
						
						else if(b.getPlayerChoice()==2)
						{
							b.usePlayerSkill();//스킬 목록 밑 스킬 발동 구현
							
							if(b.getEnemyHP()<=0)
							{
							System.out.println("이겼다");
							mainChar.setMoeny(mainChar.getMoney()+b.getEnemyPrice());
							b.battelFinish();
							break;
							}							
							b.enemyBattleCalculator();
							if(mainChar.getHp()<=0)
							{
								System.out.print("당신은 죽었습니다.");
								break;
							}
						}
						else if(b.getPlayerChoice()==3)
						{
							v.i.inventoryOpen(mainChar);
						}
						
						else if(b.getPlayerChoice()==4)
						{
							mainChar.Status();
						}
						
						else if(b.getPlayerChoice()==5)
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
