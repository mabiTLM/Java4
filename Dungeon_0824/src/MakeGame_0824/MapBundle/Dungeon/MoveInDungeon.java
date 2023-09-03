package MakeGame_0824.MapBundle.Dungeon;

import java.util.Random;

import MakeGame_0824.BattleAct.Battle;
import MakeGame_0824.BattleAct.EnemyActType;
import MakeGame_0824.CharacterBundle.MainPlayerCharacter;
import MakeGame_0824.MapBundle.Inventory;
import MakeGame_0824.MapBundle.Village.VillageMap;
import MakeGame_0824.StoryBundle.StoryText;

public class MoveInDungeon 
{
	MainPlayerCharacter mainChar;
	DungeonMap d;
	StoryText s;
	Battle b;
	VillageMap v;
	Inventory i;
	EnemyActType enemyActType = new EnemyActType();
	Random random = new Random();
	
	public MoveInDungeon(MainPlayerCharacter mainChar,DungeonMap d,StoryText s,Battle b,VillageMap v)
	{
		this.mainChar=mainChar;
		this.d=d;
		this.s=s;
		this.b=b;
		this.v=v;
	}
	
	public void moveFloor()
	{
		if(d.getFloor()==1) //층수조절
			{
			d= new DungeonFirstMap();
			d.MapSetting();
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
	}
	
	public void moveInDungeon(MainPlayerCharacter mainChar,DungeonMap d, StoryText s,Battle b,VillageMap v,Inventory i)
	{
		
		while(true) 
		{

			s.setTime(s.getTime()+1);
			if(s.getTime()>s.getTimeLimit())//일정 행동이상 할때마다
			{
				s.setTime(0);
				s.setCurrentDay(s.getCurrentDay()+1);
				mainChar.setSp(mainChar.getSp()-1);//날짜바뀌면 스태도 1까인다
			}
			s.timeRemaining();
			s.endingCheck(mainChar);//엔딩체크가 최우선
			if(mainChar.getHp()<=0||mainChar.getSp()<=0)//죽엇을때 끝내기
			{
				break;
			}
			System.out.println("현재소지금"+mainChar.getMoney());
			int floorTemp = d.getFloor();
			d.minimap();
			d.dungeonMapMove(mainChar);
			
			// 여기 밑에서부터 전투
			int ramdomEncount = (int)(random.nextInt(100));//적 조우 확률
			if(ramdomEncount<s.getEncountProbability())
			{
				b.enemyEncount(); //적 조우
				b.setOwnedItem(mainChar.getOwnedItem());//현재끼고있는 장비를 넣어준다
				b.setOwnedSkill(mainChar.getOwnedSkill());
				while(true) 
				{
					b.battleChoice();//싸움 선택지
					//플레이어행동				
					
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
					}
					else if(b.getPlayerChoice()==3)
					{
						v.i.inventoryOpen(mainChar,d);
						continue; //적에게 행동권을 안준다.
					}
					
					else if(b.getPlayerChoice()==4)
					{
						mainChar.status();
						continue; //적에게 행동권을 안준다.
					}
					
					else if(b.getPlayerChoice()==5)
					{
						int temp = (int)(random.nextInt(100));
						if(temp<85)//도망칠 확률 
						{
							System.out.println("도망쳤다.");
							break;
						}
						else
						{
							System.out.println("도망에 실패했다.");
						}
					}					
					s.weaponStory();
					
					//b.enemyBattleCalculator();
					//적 행동단
					enemyActType.enemyAct(mainChar, b.getErray(), b.getEnemyNumber(),b.getEnemyBattleType());
					if(enemyActType.getEnemyActChoice()==5) 
					{
						System.out.println("적이 도망쳤다");
						break;
					}
					
					
					
					if(mainChar.getHp()<=0||mainChar.getSp()<=0)//죽엇을때 끝내기
					{
						System.out.println("당신은 죽었습니다.");
						break;
					}
					
				}//전투단 끝
				if(mainChar.getHp()<=0||mainChar.getSp()<=0)//죽엇을때 끝내기
				{
					break;
				}
				s.weaponStory();
			}
			
			int repeatStoryEncount = (int)(random.nextInt(100));//스토리
			if(repeatStoryEncount<s.getEventEncountProbability())
			{
				s.repeatStoryEvent(i);
			}
			
			if(floorTemp!=d.getFloor()) //층이바뀌면 다시
			{
				break;
			}
			
	}//던전 while	
	}
	
}
