package MakeGame_0824;

import java.util.Scanner;
import MakeGame_0824.CharacterBundle.EnemyCharacter;
import MakeGame_0824.CharacterBundle.MainPlayerCharacter;

public class Battle
{
	
	OwnedItem[] OwnedItem;
	OwnedSkill[] OwnedSkill;
	public EnemyCharacter enemyChar = new EnemyCharacter();
	private MainPlayerCharacter mainChar;
	private EnemyCharacter[] eArray;
	private int playerChoice;
	private int enemyNumber = 0;
	Scanner scan= new Scanner(System.in);
	
	Battle(MainPlayerCharacter mainChar)
	{
		this.mainChar=mainChar;
	}
	
	void enemyEncount() 
	{
		this.eArray = enemyChar.firstEnemyDatabase();
		setEnemyNumber((int)(Math.random()*2));
		System.out.println("적 : "+eArray[enemyNumber].getName()+"(이)가 나타났다");
		System.out.println("적hp"+eArray[enemyNumber].getHp());
	}
	
	void battleChoice()
	{
			System.out.println("1.싸운다");
			System.out.println("2.스킬");
			System.out.println("3.아이템");
			System.out.println("4.방어");
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
	
	void battleCalculator() 
	{
		//임시 변수명 코드 확정될때 수정할 것
		//MainPlayerCharacter m = new MainPlayerCharacter(); //캐릭터 자료불러오고
		//m.equip(); //장비장착
		//OwnedItem[] o= m.getOwnedItem(); //장비 장착한걸 클래스화
		OwnedItem[] o = mainChar.getOwnedItem();
		System.out.println("장작한 아이템" + o[0].getItemName());
		System.out.println("공격 " + o[0].getWeaponAtk());
		eArray[enemyNumber].setHp(eArray[enemyNumber].getHp()-o[0].getWeaponAtk());
		System.out.println("적 hp :"+eArray[enemyNumber].getHp());
	}
	
	void enemyBattleCalculator() 
	{		
		OwnedItem[] o = getOwnedItem();
		System.out.println("적의 공격 " + eArray[enemyNumber].getAtk());
		mainChar.setHp(mainChar.getHp()-eArray[enemyNumber].getAtk());
	}
	
	void usePlayerSkill()
	{	
		OwnedSkill[] o = getOwnedSkill();
		int useSkillNumber=-1;
		
		System.out.print("가지고 있는 스킬 목록 ");
		for(OwnedSkill OwnedSkill:o)
		{			
			System.out.print(OwnedSkill.getName()+", ");
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
				if(mainChar.getSp()-o[useSkillNumber].getConsumeSp()>=0)
				{
				System.out.println("공격 " + o[useSkillNumber].getAtk());
				eArray[enemyNumber].setHp(eArray[enemyNumber].getHp()-o[useSkillNumber].getAtk());
				System.out.println("적 hp :"+eArray[enemyNumber].getHp());
				mainChar.setSp(mainChar.getSp()-o[useSkillNumber].getConsumeSp());
				}
				else
				{
					System.out.println("sp가 부족해서 스킬발동에 실패했다.");
				}
			}
			else if(o[useSkillNumber].getType().equals("힐")) //회복타입
			{
				System.out.println("회복합니다.");
				
				if(mainChar.getMp()-o[useSkillNumber].getConsumeMp()>=0)
				{
					if(mainChar.getHp()+(int)o[useSkillNumber].getHeal()>=300)
					{
						mainChar.setHp(300);
					}
					else
					{
						mainChar.setHp(mainChar.getHp()+(int)o[useSkillNumber].getHeal());
						System.out.println("내 hp :"+mainChar.getHp());
					}
				}
				else
				{
					System.out.println("mp가 부족해서 스킬발동에 실패했다.");					
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
		return eArray[enemyNumber].getPrice();
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
