package MakeGame_0824.MapBundle.Village;

import MakeGame_0824.Battle;
import MakeGame_0824.CharacterBundle.MainPlayerCharacter;
import MakeGame_0824.MapBundle.Dungeon.DungeonMap;
import MakeGame_0824.StoryBundle.IntroStory;
import MakeGame_0824.StoryBundle.StoryText;
import MakeGame_0824.StoryBundle.Tutorial;

public class MoveInVIllage 
{
	MainPlayerCharacter mainChar;
	DungeonMap d;
	VillageMap v;
	StoryText s;
	Tutorial t = new Tutorial(mainChar);
	IntroStory intro = new IntroStory(mainChar);
	
	public MoveInVIllage(MainPlayerCharacter mainChar,DungeonMap d)
	{
		this.mainChar=mainChar;
		this.d=d;
	}
	
	public void combineMoveInVillage(MainPlayerCharacter mainChar,DungeonMap d,VillageMap v,StoryText s)
	{
		intro.introText();
		t.tutorialText();
			while(true) //마을while
			{				
				s.setTime(s.getTime()+1);
				if(s.getTime()>s.getTimeLimit()) //일정 행동이상 할때마다
				{
					s.setTime(0);
					s.setCurrentDay(s.getCurrentDay()+1);
					mainChar.setSp(mainChar.getSp()-1);//날짜바뀌면 스태도 1까인다
				}				
				s.timeRemaining();
				s.endingCheck(mainChar);//엔딩체크가 최우선				
				if(mainChar.getHp()<=0|mainChar.getSp()<=0)//죽엇을때 끝내기
				{
					break;
				}
				System.out.println("현재소지금"+mainChar.getMoney());
				if(v.getCurrentLocation()==0)
				{
					v  = new VillageMapHouse(mainChar,s);
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
					v  = new VillageMapShop(mainChar,s);
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
		}
	}
