package MakeGame_0824;

import java.util.Scanner;
import MakeGame_0824.CharacterBundle.EnemyCharacter;
import MakeGame_0824.CharacterBundle.MainPlayerCharacter;
import MakeGame_0824.CharacterBundle.OwnedItem;
import MakeGame_0824.CharacterBundle.OwnedSkill;
import MakeGame_0824.MapBundle.Dungeon.DungeonMap;

public class Battle
{
	
	OwnedItem[] OwnedItem;
	OwnedSkill[] OwnedSkill;
	DungeonMap dungeonMap;
	public EnemyCharacter enemyChar = new EnemyCharacter();
	private MainPlayerCharacter mainChar;
	private EnemyCharacter[] eArray;
	private int playerChoice;
	private int enemyNumber = 0;
	Scanner scan= new Scanner(System.in);
	
	Battle(MainPlayerCharacter mainChar, DungeonMap dungeonMap)
	{
		this.mainChar=mainChar;
		this.dungeonMap=dungeonMap;
	}
	
	void enemyEncount() 
	{
		if(Math.abs(dungeonMap.getFloor())==1) //1층적
		{
			this.eArray = enemyChar.firstEnemyDatabase();
		}
		else if(Math.abs(dungeonMap.getFloor())==2)//2층적 
		{
			this.eArray = enemyChar.secondEnemyDatabase();
		}
		setEnemyNumber((int)(Math.random()*(eArray.length-1)));
		System.out.println("적 : "+eArray[enemyNumber].getName()+"(이)가 나타났다");
		System.out.println("적hp"+eArray[enemyNumber].getHp());
	}
	
	void battleChoice()
	{
			System.out.println("1.싸운다");
			System.out.println("2.스킬");
			System.out.println("3.아이템");
			System.out.println("4.스테이터스");
			System.out.println("5.도망친다");
			String playerChoice = scan.nextLine();
			
			while(true)
			{
				if(playerChoice.isEmpty()==false&playerChoice.replaceAll("[0-9]","").isEmpty()) 
				{
					break;
				}
				else
				{
					System.out.println("숫자만 입력해주세요");
					playerChoice = scan.nextLine();
				}
			}
			
			this.playerChoice=Integer.valueOf(playerChoice);
			setPlayerChoice(this.playerChoice);
	}
	
	void battleCalculator() //통상공격
	{
		
		OwnedItem[] o = mainChar.getOwnedItem();
		int tempDamage = 0;
		int tempProficiency = 0;
		if(mainChar.getOwnedItem()[0].getWeaponType()=="검") //검 사용시 숙련도 가져오기 +숙련도증가
		{
			tempProficiency=(int)mainChar.getProficiency()[0];
			mainChar.setProficiency(mainChar.getProficiency()[0]+0.10, 0);	
		}
		else if(mainChar.getOwnedItem()[0].getWeaponType()=="지팡이") //지팡이 사용시 숙련도 가져오기 +숙련도증가 밸런스상 휘둘러도 올라야?
		{
			tempProficiency=(int)mainChar.getProficiency()[1];
			mainChar.setProficiency(mainChar.getProficiency()[1]+0.10, 1);
		}
		System.out.println("장작한 아이템" + o[0].getItemName());
		System.out.println("공격 " + (o[0].getWeaponAtk()+tempProficiency));
		tempDamage=o[0].getWeaponAtk()+tempProficiency-eArray[enemyNumber].getDef();		
		if(tempDamage<0)
		{
			tempDamage=0;
		}
		
		eArray[enemyNumber].setHp(eArray[enemyNumber].getHp()-tempDamage);
		System.out.println("적 hp :"+eArray[enemyNumber].getHp());
	}
	
	void enemyBattleCalculator() 
	{		
		int tempDamage = 0;
		OwnedItem[] o = mainChar.getOwnedItem();
		System.out.println("적의 공격 " + eArray[enemyNumber].getAtk());
		tempDamage=eArray[enemyNumber].getAtk()-o[1].getWeaponDef();
		if(tempDamage<0)
		{
			tempDamage = 0;
		}
		mainChar.setHp(mainChar.getHp()-tempDamage);
		System.out.println("내 hp :"+mainChar.getHp());
	}
	
	void usePlayerSkill()
	{	
		OwnedSkill[] o = mainChar.getOwnedSkill();
		int useSkillNumber=-1;
		
		System.out.println("가지고 있는 스킬 목록 ");
		
		for(int i = 0; i < o.length;i++)
		{
			System.out.println(o[i].getSkillDescription());
		}
		
		System.out.print("사용할 스킬 : ");
		String temp = scan.nextLine();
		
		for(int i = 0; i<o.length; i++)
		{
			if(o[i].getName().equals(temp))
			{
				useSkillNumber=i;
				System.out.println("사용한 스킬 : " + o[useSkillNumber].getName());
				break;
			}
		}
		
		if(useSkillNumber==-1)
		{
			System.out.println("스킬을 잘 못 사용했다");
		}
		else
		{
			if(o[useSkillNumber].getType().equals("물리"))//물리 타입 기술 사용시
			{
				if(mainChar.getSp()-o[useSkillNumber].getConsumeSp()>0)
				{
					int tempProficiency = 0;
					int tempDamage = 0;
					if(mainChar.getOwnedItem()[0].getWeaponType()=="검") //검 사용시 숙련도 가져오기 +숙련도증가
					{
						tempProficiency=(int)mainChar.getProficiency()[0];
						mainChar.setProficiency(mainChar.getProficiency()[0]+0.10, 0);	
					}
					else if(mainChar.getOwnedItem()[0].getWeaponType()=="지팡이") //지팡이 숙련도
					{
						tempProficiency=(int)mainChar.getProficiency()[1];
						mainChar.setProficiency(mainChar.getProficiency()[0]+0.10, 1);	
					}
					System.out.println("공격 " + (o[useSkillNumber].getAtk()+tempProficiency)*mainChar.getOwnedItem()[0].getWeaponAtk());
					tempDamage=(o[useSkillNumber].getAtk()+tempProficiency)*mainChar.getOwnedItem()[0].getWeaponAtk()-eArray[enemyNumber].getDef();
					if(tempDamage<0)
					{
						tempDamage=0;
					}
					eArray[enemyNumber].setHp(eArray[enemyNumber].getHp()-tempDamage);
					System.out.println("적 hp :"+eArray[enemyNumber].getHp());
					mainChar.setSp(mainChar.getSp()-o[useSkillNumber].getConsumeSp());
				}
				else
				{
					System.out.println("sp가 부족해서 스킬발동에 실패했다.");
				}
			}
			else if(o[useSkillNumber].getType().equals("회복")) //회복타입
			{
				System.out.println("회복합니다.");
				
				if(mainChar.getMp()-o[useSkillNumber].getConsumeMp()>=0)
				{
					mainChar.setHp(mainChar.getHp()+o[useSkillNumber].getHpHeal());
					System.out.println("내 hp :"+mainChar.getHp());
				}
				else
				{
					System.out.println("mp가 부족해서 스킬발동에 실패했다.");					
				}
			}
			
			
			else if(o[useSkillNumber].getType().equals("마법"))//마법 타입 기술 사용시 마법은 방어 관통이다
			{
				if(mainChar.getMp()-o[useSkillNumber].getConsumeMp()>=0)
				{
					int tempProficiency = 1;
					if(mainChar.getOwnedItem()[0].getWeaponType()=="지팡이") //지팡이 숙련도
					{
						tempProficiency=(int)mainChar.getProficiency()[1];
						mainChar.setProficiency(mainChar.getProficiency()[0]+0.10, 1);	
					}
					System.out.println("공격 " + o[useSkillNumber].getAtk()*tempProficiency);
					eArray[enemyNumber].setHp(eArray[enemyNumber].getHp()-o[useSkillNumber].getAtk()*tempProficiency);
					System.out.println("적 hp :"+eArray[enemyNumber].getHp());
					mainChar.setMp(mainChar.getMp()-(int)o[useSkillNumber].getConsumeMp());
				}
				else
				{
					System.out.println("mp가 부족해서 스킬발동에 실패했다.");
				}
			}
		}
		
	}
	
	
	void battelFinish()
	{
		
		//인벤가득차면 5칸 늘려준다
		if(mainChar.getInventory()[mainChar.getInventory().length-1].isEmpty()==false)
		{
			String[] temp = new String[mainChar.getInventory().length+5];
			for(int i = 0; i<temp.length; i++)
			{
				temp[i]="";
			}
			for(int i = 0; i<mainChar.getInventory().length; i++)
			{
				temp[i]=mainChar.getInventory()[i];
			}
			mainChar.setInventory(temp);
		}
		
		
		int temp = (int)(Math.random()*100);//드랍확률
		
		if(eArray[enemyNumber].getDropPercent()>temp)//드랍확률이상이면 나온다
		{
			for(int i = 0; i <eArray[enemyNumber].getDropItem().length;i++)
			{
				for(int j = 0; j <mainChar.getInventory().length;j++) 
				{
					if(mainChar.getInventory()[j].isEmpty()&eArray[enemyNumber].getDropPercent()>temp)//가진 아이템별 드랍확률다르게 조정
					{
						mainChar.getInventory()[j]=eArray[enemyNumber].getDropItem()[i];
						System.out.println(mainChar.getInventory()[j]+"를 얻었다");
						temp = (int)(Math.random()*100);
						break;
					}
				}
				
			}
		}		
	}
	
	
	
	//set모음
	void setOwnedItem(OwnedItem[] OwnedItem)
	{
		this.OwnedItem = OwnedItem;
	}
	
	void setOwnedSkill(OwnedSkill[] OwnedSkill)
	{
		this.OwnedSkill = OwnedSkill;
	}
	
	void setEnemyNumber(int enemyNumber)
	{
		this.enemyNumber=enemyNumber;
	}
	
	void setPlayerChoice(int playerChoice)
	{
		this.playerChoice=playerChoice;
	}
	
	
	//진짜 변수가 아닌 get이기에 주의
	int getEnemyHP() 
	{
		return eArray[enemyNumber].getHp();
	}
	int getEnemyPrice()
	{
		return eArray[enemyNumber].getDropMoney();
	}
	////////////////
	
	//get모음
	int getPlayerChoice()
	{
		return playerChoice;
	}
		
	OwnedItem[] getOwnedItem()
	{
		return OwnedItem;
	}
	
	OwnedSkill[] getOwnedSkill()
	{
		return OwnedSkill;
	}
	
	
}
