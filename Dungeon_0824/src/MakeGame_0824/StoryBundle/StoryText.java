package MakeGame_0824.StoryBundle;

import java.util.Scanner;

import MakeGame_0824.CharacterBundle.MainPlayerCharacter;
import MakeGame_0824.CharacterBundle.OwnedItem;
import MakeGame_0824.CharacterBundle.OwnedSkill;
import MakeGame_0824.MapBundle.Inventory;

public class StoryText
{
	MainPlayerCharacter mainChar;
	Inventory inven;
	Scanner scan = new Scanner(System.in);
	public StoryText(MainPlayerCharacter mainChar)
	{
		this.mainChar=mainChar;
	}
	private int currentDay = 0; //경과일에 따른 스토리 변경이 있으므로 여기서 계산합니다.
	private int dayLimit = 30; //끝날때가지 남은시간
	private int time=0; //하루시간 목표치까지 행동하면 날짜가 지난다.
	private int timeLimit=3;
	private int encountProbability= 25;//몹만날 확률도 스토리 영향받게 하기위해 이곳에 생성
	private int eventEncountProbability = 10;
	private int evilCount = 0;
	private int goodCount = 0;
	private boolean watchAgainBadEvent=true;//함정결단1
	private boolean weaponBreakTrap=true;//함정결단1
	private boolean endingCheck=true; //엔딩이후 텍스트 변경도 가능
	
	private int endingNumber = -1; //엔딩조건맞췄을 때 변동
	
	private String[] repeatStory= 
		{
				"쓰러진 사람을 만났습니다.\n1.도와준다.\n2.물건을 훔친다.",
				"여신상이 있습니다.\n1.기도한다.\n2.부순다.",
				"던전안에서 상인과 마주쳤습니다.\n상인 : 물건 좀 사고 가라구.\n1.물건을 산다.\n2.물건을 훔친다.\n3.무시하고 간다.",
				"악마의 석상이 있습니다.\n1.기도한다.\n2.부순다.",
				"함정에 짐이 걸려서 한쪽을 포기해야합니다.\n1.무기를 포기한다.\n2.돈을 포기한다.",
				"이런 날도 있는 법이지.\n누군가 흘린 돈을 주웠습니다.",
				"이런 날도 있는 법이지.\n돈을 잃어버렸습니다.",
				"이런 날도 있는 법이지.\n너무 험하게 다뤘을까요? 무기가 부셔졌습니다.",
				"이런 날도 있는 법이지.\n보석을 주웠습니다.",
				"이런 날도 있는 법이지.\n함정에 걸렸습니다.",	
				"이런 날도 있는 법이지.\n안전해보이는 지역을 발견 했습니다. 잠시 쉬어갑니다."
		};
	
	private String[] endingStory=
		{
				"엔딩0 다시 일상으로\n동생은 완치 됐습니다.쌩쌩한 것이 앞으로 100년은 더 살것처럼보이네요."
				+ "\n이야기는 이걸로 끝입니다. 하지만 던전을 아직 즐기고 싶으시다면 남아있을 수 있습니다.",
				
				"엔딩1 헛된 죽음\n당신은 죽었습니다.\n혼자 남겨진 당신의 동생도 곧 뒤따라가겠지요.",
				
				"엔딩2 너무 늦어 버렸다.\n동생은 이미 싸늘한 시체가 되어있었습니다.",
				
				"엔딩3 체포\n당신의 악행이 너무 퍼졌던 걸까요?\n경비병이 당신을 체포했습니다.\n감옥에서 나갈때에 동생은 이미 죽어있겠죠.",
				
				"엔딩4 명성\n 올바른 행동들이 결실을 맺었습니다.\n나라에서 당신의 노고를 치하하며 치료비를 내려주었습니다."
				+ " 정말 다행이에요.\n이야기는 이걸로 끝입니다. 하지만 던전을 아직 즐기고 싶으시다면 남아있을 수 있습니다."
		};
	
	private String[] houseStory=
		{		
				"동생 : 콜록 콜록... 오늘부터 던전으로 가는거지?\n도시락 싸놨으니까 들고가",
				"동생 : 너무 무리하지는 마",
				"동생 : 미안해 나 때문에..",//엔딩이전
				"동생 : 비싼약을 구하느라 힘들었지? 고마워."
		};
	
	private String[] dungeonEntranceStory=
		{
				"던전이다. 문지기가 있다.\n문지기 : 처음보는 얼굴인데 던전에 가기전에 무기는 챙겼나?",
				"문지기 : 1층에서 가장 만만한건 혼 래빗이야.",
				"문지기 : 슬라임은 방어력이 높으니 마법으로 잡으면 편해.",
				"문지기 : 죽고 싶지 않으면 2층은 가지 않는게 좋을거야 물론 1층이라고 안전한건 아니지만",
				"문지기 : 사슴을 조심해 마주치면 바로 도망치는게 좋을거야."
		};
	
	
	private String[] staffStory=
	{
		"스태프 숙련도가 올랐습니다. 매직미사일을 습득합니다. 추가 숙련도를 0.1 얻습니다",
		"스태프 숙련도가 올랐습니다. 메기도를 습득합니다. 추가 숙련도를 0.1 얻습니다"
	};
	
	
	private String[] swordStory=
		{
			"검 숙련도가 올랐습니다. 혼신의 일격을 습득합니다. 추가 숙련도를 0.1 얻습니다",
			"검 숙련도가 올랐습니다. 결사의 일격을 습득합니다. 추가 숙련도를 0.1 얻습니다"
		};
	
	
	public void weaponStory()
	{
		
		if((int)(mainChar.getProficiency()[0]*10)==20)
		{
			System.out.println(swordStory[0]);
			OwnedSkill[] tempOwn = new OwnedSkill[mainChar.getOwnedSkill().length+1];
			
			for(int i = 0; i <mainChar.getOwnedSkill().length; i++)
			{
				tempOwn[i]=mainChar.getOwnedSkill()[i];
			}
			tempOwn[tempOwn.length-1]=new OwnedSkill("혼신의 일격","물리",10,5,"혼신의 일격 : 무기 공격력*10의 물리데미지를 줍니다 소비 sp5");
			mainChar.setOwnedSkill(tempOwn);
			mainChar.setProficiency(2.1, 0);
		}		
		if((int)(mainChar.getProficiency()[1]*10)==20)
		{
			System.out.println(staffStory[0]);
			OwnedSkill[] tempOwn = new OwnedSkill[mainChar.getOwnedSkill().length+1];
			
			for(int i = 0; i <mainChar.getOwnedSkill().length; i++)
			{
				tempOwn[i]=mainChar.getOwnedSkill()[i];
			}
			tempOwn[tempOwn.length-1]=new OwnedSkill("매직미사일","마법",20,1.0,"매직미사일 : 20의 마법데미지를 줍니다. 소비mp 1");
			mainChar.setOwnedSkill(tempOwn);
			mainChar.setProficiency(2.1, 1);
		}
		
		
		if((int)(mainChar.getProficiency()[0]*10)==40)
		{
			System.out.println(swordStory[1]);
			OwnedSkill[] tempOwn = new OwnedSkill[mainChar.getOwnedSkill().length+1];
			
			for(int i = 0; i <mainChar.getOwnedSkill().length; i++)
			{
				tempOwn[i]=mainChar.getOwnedSkill()[i];
			}
			tempOwn[tempOwn.length-1]=new OwnedSkill("결사의 일격","물리",30,10,"결사의 일격 : 무기 공격력*30의 물리데미지를 줍니다 소비 sp10");
			mainChar.setOwnedSkill(tempOwn);
			mainChar.setProficiency(4.1, 0);
		}		
		if((int)(mainChar.getProficiency()[1]*10)==40)
		{
			System.out.println(staffStory[1]);
			OwnedSkill[] tempOwn = new OwnedSkill[mainChar.getOwnedSkill().length+1];
			
			for(int i = 0; i <mainChar.getOwnedSkill().length; i++)
			{
				tempOwn[i]=mainChar.getOwnedSkill()[i];
			}
			tempOwn[tempOwn.length-1]=new OwnedSkill("메기도","마법",60,2.0,"메기도 : 60의 마법데미지를 줍니다. 소비mp2");
			mainChar.setOwnedSkill(tempOwn);
			mainChar.setProficiency(4.1, 1);
		}
		
	}
	
	
	
	
	public void timeRemaining()//남은 시간
	{
		System.out.printf("예상 남은 날짜 : %d\n",getDayLimit()-getCurrentDay());
	}
	
	public void repeatStoryEvent(Inventory inven)
	{
		int temp=(int)(Math.random()*(repeatStory.length+1));
		
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
		else if(temp==1)//여신상
			{
			System.out.println(repeatStory[temp]);
			while(true)
			{
				String tempChoice=scan.nextLine();
				if(tempChoice.equals("1"))
				{
					setGoodCount(getGoodCount()+1);
					System.out.println("최대스텟이 5 올라갑니다.");
					mainChar.setMaxHp(mainChar.getMaxHp()+5);
					mainChar.setMaxMp(mainChar.getMaxMp()+5);
					mainChar.setMaxSp(mainChar.getMaxSp()+5);
					break;
					}
				else if(tempChoice.equals("2"))
				{
					mainChar.setMoeny(mainChar.getMoney()+10000);
					System.out.println("금으로 만들어진 부분을 슬쩍했습니다. +10000골드");
					break;
					}
				else
				{
					System.out.println("다시 선택하세요");
					}
				}
			}
		else if(temp==2)//상인과의 조우
			{
			System.out.println(repeatStory[temp]);
			while(true)
			{
				System.out.println("소지금"+mainChar.getMoney());
				String tempChoice=scan.nextLine();
				if(tempChoice.equals("1"))
				{
					inven.buyItem(mainChar, this);
					break;
					
				}
				else if(tempChoice.equals("2"))
				{
					setEvilCount(getEvilCount()+1);
					mainChar.setHp(mainChar.getHp()-100);
					System.out.println("던전에서 장사를 하는 사람이 약할리가 없지요. 반격당해서 100의 피해를 입었습니다.");
					break;
					
				}
				else if(tempChoice.equals("3"))
				{
					break;
					
				}
				else
				{
					System.out.println("다시 선택하세요");
					
				}
				
			}
		}
		else if(temp==3)//악마상
		{
		System.out.println(repeatStory[temp]);
		while(true)
		{
			String tempChoice=scan.nextLine();
			if(tempChoice.equals("1"))
			{
				System.out.println("적이나 이벤트와 조우할 확률이 올라갑니다.");
				setEventEncountProbability(getEventEncountProbability()+5);
				setEncountProbability(getEncountProbability()+5);
				break;
				
			}
			else if(tempChoice.equals("2"))
			{
				System.out.println("적이나 이벤트와 조우할 확률이 내려갑니다.");
				setEventEncountProbability(getEventEncountProbability()-5);
				setEncountProbability(getEncountProbability()-5);
				break;
				
			}
			else
			{
				System.out.println("다시 선택하세요");
				
			}
			
		}
	}
		
		else if(temp==4&&getWatchAgainBadEvent()&&!mainChar.getOwnedItem()[0].getItemName().equals("맨손"))//함정에서의 결단
		{
			System.out.println(repeatStory[temp]);
			while(true)
			{
				String tempChoice=scan.nextLine();
				if(tempChoice.equals("1"))
				{
					System.out.println(mainChar.getOwnedItem()[0].getItemName() + "를 잃어버렸습니다.");
					OwnedItem[] hand = {new OwnedItem("맨손","무기","주먹", 1, 0,"맨손 : 공격력 1")};
					mainChar.setOwnedItem(hand, 0);
					this.setWatchAgainBadEvent(false);
					break;
					
				}
				else if(tempChoice.equals("2"))
				{
					System.out.println("돈을 잃어버렸습니다.");
					mainChar.setMoeny(0);
					this.setWatchAgainBadEvent(false);
					break;
					
				}
				else
				{
					System.out.println("다시 선택하세요");
					
				}
				
			}
		
		}
		else if(temp==5)//돈을 주운날
		{
			int getMoneyEvent = (int)((Math.random()*20000)+100);
			System.out.println(repeatStory[temp] + getMoneyEvent+"골드");			
			mainChar.setMoeny(getMoneyEvent+mainChar.getMoney());		
		}
		else if(temp==6)//돈을 잃은날
		{
			int loseMoneyEvent = (int)((Math.random()*5000)+100);
			System.out.println(repeatStory[temp]);
			mainChar.setMoeny(mainChar.getMoney()-loseMoneyEvent);		
		}
		else if(temp==7&&getWeaponBreakTrap()&&!mainChar.getOwnedItem()[0].getItemName().equals("맨손"))//무기가 부셔진날 반복x
		{
			System.out.println(repeatStory[temp]);
			System.out.println(mainChar.getOwnedItem()[0].getItemName() + "가 부셔젔습니다.");
			OwnedItem[] hand = {new OwnedItem("맨손","무기","주먹", 1, 0,"맨손 : 공격력 1")};
			mainChar.setOwnedItem(hand, 0);
			this.setWeaponBreakTrap(false);
		}
		
		else if(temp==8)//보석줍기
		{
			int jewel = (int)((Math.random()*100001));
			String tempJewel = "";
			
			if(jewel>=100001)
			{
				tempJewel="검은 보석";
			}
			else if(jewel>=50001)
			{
				tempJewel="노란 보석";
			}
			else if(jewel>=10001)
			{
				tempJewel="파란 보석";
			}
			else
			{
				tempJewel="붉은 보석";
			}
			
			System.out.println(repeatStory[temp] + "  "+tempJewel);
			String[] tempInven = {};
			if(mainChar.getInventory()[mainChar.getInventory().length-1].isEmpty()==false)//인벤토리 늘리기
			{
				tempInven = new String[mainChar.getInventory().length+5];
				for(int i = 0; i<tempInven.length; i++)
				{
					tempInven[i]="";
				}
				for(int j = 0; j<mainChar.getInventory().length; j++)
				{
					tempInven[j]=mainChar.getInventory()[j];
				}
				mainChar.setInventory(tempInven);
			}
			tempInven = mainChar.getInventory();
				for(int i = 0; i<tempInven.length; i++)
				{
					if(tempInven[i].isEmpty())
					{
						tempInven[i]=tempJewel;
						mainChar.setInventory(tempInven);
						break;
					}
				}
		}
		
		else if(temp==9)//함정
		{
			int tempDamage = (int)((Math.random()*30)+1);
			System.out.println(repeatStory[temp] + tempDamage + "의 데미지를 입습니다.");
			mainChar.setHp(mainChar.getHp()-tempDamage);
		}
		else if(temp==10)//휴식 쉬어가는기간
		{
			int tempHeal = (int)((Math.random()*60)+1);
			System.out.println(repeatStory[temp] + tempHeal + "회복합니다.");
			mainChar.setHp(mainChar.getHp()+tempHeal);
		}
		
	}	
	
	
	public void endingCheck(MainPlayerCharacter mainChar)
	{
		if((mainChar.getHp()<=0|mainChar.getSp()<=0)&&getEndingCheck())//사망을 최우선으로
		{
			System.out.println(getEndingStory()[1]);
			setEndingCheck(false);
		}
		else if(getDayLimit()-getCurrentDay()<=0&&getEndingCheck())//시간초과 배드엔딩시 체력0만들어서 게임 끝내기
		{
			mainChar.setHp(0);
			System.out.println(getEndingStory()[2]);
			setEndingCheck(false);
		}
		else if(getEvilCount()>=10&&getEndingCheck())//체포
		{
			mainChar.setHp(0);
			System.out.println(getEndingStory()[3]);
			setEndingCheck(false);
		}
		else if(getGoodCount()>=50&&getEndingCheck())//명성
		{
			System.out.println(getEndingStory()[4]);
			setEndingCheck(false);
		}
		else if(getDayLimit()>=36000&&getEndingCheck())//치료완료
		{
			System.out.println(getEndingStory()[0]);
			setEndingCheck(false);
		}
		
	}
	
	
	//set모음
	public void setCurrentDay(int currentDay)
	{
		this.currentDay=currentDay;
	}
	public void setTimeLimit(int timeLimit)
	{
		this.timeLimit=timeLimit;
	}
	public void setDayLimit(int dayLimit)
	{
		this.dayLimit=dayLimit;
	}
	public void setTime(int time)
	{
		this.time=time;
	}
	public void setWatchAgainBadEvent(boolean watchAgainBadEvent)
	{
		this.watchAgainBadEvent=watchAgainBadEvent;
	}
	public void setEvilCount(int evilCount)
	{
		this.evilCount=evilCount;
	}
	public void setGoodCount(int goodCount)
	{
		this.goodCount=goodCount;
	}
	public void setEndingCheck(boolean endingCheck)
	{
		this.endingCheck=endingCheck;
	}
	
	public void setEventEncountProbability(int eventEncountProbability)
	{
		if(eventEncountProbability<1)
		{
			eventEncountProbability=2;
		}
		this.eventEncountProbability=eventEncountProbability;
	}
	public void setEncountProbability(int encountProbability)
	{
		if(encountProbability<1)
		{
			encountProbability=2;
		}
		this.encountProbability=encountProbability;
	}
	
	public void setWeaponBreakTrap(boolean weaponBreakTrap)
	{
		this.weaponBreakTrap = weaponBreakTrap;
	}
	
	
	
	//get모음
	
	public String[] getHouseStory() //내부겟
	{
		return houseStory;
	}
	
	public String getHouseStory(int num) //내부겟
	{
		return houseStory[num];
	}
	
	public int getEventEncountProbability()
	{
		return eventEncountProbability;
	}
	
	public String[] getDungeonEntranceStory()
	{
		return dungeonEntranceStory;
	}	
	public String getDungeonEntranceStory(int num) //내부겟
	{
		return dungeonEntranceStory[num];
	}
	
	public boolean getWeaponBreakTrap()
	{
		return weaponBreakTrap;
	}
	
	
	
	public int getTimeLimit()
	{
		return timeLimit;
	}
	public String[] getStaffStory()
	{
		return staffStory;
	}
	public String getStaffStory(int num) //내부겟
	{
		return staffStory[num];
	}
	
	public String[] getSwordStory() //내부겟
	{
		return swordStory;
	}
	public String getSwordStory(int num) //내부겟
	{
		return swordStory[num];
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
	
	public boolean getEndingCheck()
	{
		return endingCheck;
	}
	public boolean getWatchAgainBadEvent()
	{
		 return watchAgainBadEvent;
	}
}
