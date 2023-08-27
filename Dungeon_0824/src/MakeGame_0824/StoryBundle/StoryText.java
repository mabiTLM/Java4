package MakeGame_0824.StoryBundle;

import java.util.Scanner;

import MakeGame_0824.CharacterBundle.MainPlayerCharacter;

public class StoryText
{
	MainPlayerCharacter mainChar;
	Scanner scan = new Scanner(System.in);
	public StoryText(MainPlayerCharacter mainChar)
	{
		this.mainChar=mainChar;
	}
	private int currentDay = 0; //경과일에 따른 스토리 변경이 있으므로 여기서 계산합니다.
	private int dayLimit =40; //끝날때가지 남은시간
	private int time=0; //하루시간 10번 행동하면 날짜가 지난다.
	private int encountProbability= 25;//몹만날 확률도 스토리 영향받게 하기위해 이곳에 생성
	private int evilCount = 0;
	private int goodCount = 0;
	private boolean watchAgain=true;
	
	private String[] repeatStory= 
		{
				"쓰러진 사람을 만났습니다.\n1.도와준다.\n2.물건을 훔친다."
		};
	private String[] endingStory=
		{
				"엔딩0 다시 일상으로\n동생은 완치 됐습니다.쌩쌩한 것이 앞으로 100년은 더 살것처럼보이네요.\n이야기는 이걸로 끝입니다. 하지만 던전을 아직 즐기고 싶으시다면 남아있을 수 있습니다.",
				"엔딩1 헛된 죽음\n당신은 죽었습니다.\n혼자 남겨진 당신의 동생도 곧 뒤따라가겠지요.",
				"엔딩2 너무 늦어 버렸다.\n동생은 이미 싸늘한 시체가 되어있었습니다.",
				"엔딩3 체포\n당신의 악행이 너무 퍼졌던 걸까요?\n경비병이 당신을 체포했습니다.\n감옥에서 나갈때에 동생은 이미 죽어있겠죠."
		};
	
	private String[] dungeonEntranceStory=
		{
				"던전이다. 문지기가 있다.",
				"문지기 : 슬라임은 방어력이 높으니 마법으로 잡으면 편해",
				"문지기 : 죽고 싶지 않으면 2층은 가지 않는게 좋을거야 물론 1층이라고 안전한건 아니지만",
		};
	
	
	
	public void timeRemaining()//남은 시간
	{
		System.out.printf("예상 남은 날짜 : %d\n",getDayLimit()-getCurrentDay());
	}
	
	public void repeatStoryEvent()
	{
		int temp=(int)(Math.random()*repeatStory.length);
		
		if(temp==0)//쓰러진 사람
		{
			System.out.println(repeatStory[temp]);
			while(true) 
			{
				String tempChoice=scan.nextLine();
				if(tempChoice.equals("1"))
				{
					setGoodCount(getGoodCount()+1);
					System.out.println("도와준사람이 감사인사를 하고 떠나갑니다.");
					break;
				}
				else if(tempChoice.equals("2"))
				{
					setEvilCount(getEvilCount()+1);
					mainChar.setMoeny(mainChar.getMoney()+10000);
					System.out.println("쓰러진 사람의 짐속에는 무려 10000골드가 있었습니다.");
					break;
				}
				else
				{
					System.out.println("다시 선택하세요");
				}
			}
			
		}
	}
	
	
	public void endingCheck()
	{
		if(mainChar.getHp()<=0|mainChar.getSp()<=0)//사망을 최우선으로
		{
			System.out.println(getEndingStory()[1]);
		}
		else if(getDayLimit()-getCurrentDay()<=0)//시간초과 배드엔딩시 체력0만들어서 게임 끝내기
		{
			mainChar.setHp(0);
			System.out.println(getEndingStory()[2]);
		}
		else if(getEvilCount()>=10)
		{
			mainChar.setHp(0);
			System.out.println(getEndingStory()[3]);
		}
		else if(getDayLimit()>=36000)//완료
		{
			while(watchAgain) 
			{
				System.out.println(getEndingStory()[0]);
				setWatchAgain(false);
			}
		}
		
	}
	
	
	//set모음
	public void setCurrentDay(int currentDay)
	{
		this.currentDay=currentDay;
	}
	public void setDayLimit(int dayLimit)
	{
		this.dayLimit=dayLimit;
	}
	public void setTime(int time)
	{
		this.time=time;
	}
	public void setWatchAgain(boolean watchAgain)
	{
		this.watchAgain=watchAgain;
	}
	public void setEvilCount(int evilCount)
	{
		this.evilCount=evilCount;
	}
	public void setGoodCount(int goodCount)
	{
		this.goodCount=goodCount;
	}
	
	
	//get모음
	
	public String[] getDungeonEntranceStory()
	{
		return dungeonEntranceStory;
	}	
	public String getDungeonEntranceStory(int num) //내부겟
	{
		return dungeonEntranceStory[num];
	}
	
	public int getTime()
	{
		return time;
	}
	
	public int getCurrentDay()
	{
		return currentDay;
	}
	
	public int getDayLimit()
	{
		return dayLimit;
	}
	public int getEvilCount()
	{
		return evilCount;
	}
	public int getGoodCount()
	{
		return goodCount;
	}
	
	public String[] getRepeatStory()
	{
		return repeatStory;
	}
	
	public String[] getEndingStory()
	{
		return endingStory;
	}
	
	public int getEncountProbability()
	{
		return encountProbability;
	}
}
