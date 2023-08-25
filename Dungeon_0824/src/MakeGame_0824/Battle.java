package MakeGame_0824;

import java.util.Scanner;
import MakeGame_0824.CharacterBundle.EnemyCharacter;
import MakeGame_0824.CharacterBundle.MainPlayerCharacter;

public class Battle
{
	OwnedItem[] OwnedItem;
	public EnemyCharacter enemyChar = new EnemyCharacter();
	public MainPlayerCharacter mainChar = new MainPlayerCharacter();
	private EnemyCharacter[] eArray;
	private int playerChoice;
	private int enemyNumber = 0;
	
	void enemyEncount() 
	{
		OwnedItem[] o = getOwnedItem();
		this.eArray = enemyChar.firstEnemyDatabase();
		setEnemyNumber((int)(Math.random()*2));
		System.out.println("적 : "+eArray[enemyNumber].getName()+"(이)가 나타났다");
		System.out.println("적hp"+eArray[enemyNumber].getHp());
	}
	
	void battleChoice()
	{
			System.out.println("1.싸운다");
			System.out.println("2.아이템");
			System.out.println("3.방어");
			System.out.println("4.도망친다");
			Scanner scan= new Scanner(System.in);
			String playerChoice = scan.nextLine();
			this.playerChoice=Integer.valueOf(playerChoice);
			setPlayerChoice(this.playerChoice);
	}
	
	void battleCalculator() 
	{
		//임시 변수명 코드 확정될때 수정할 것
		//MainPlayerCharacter m = new MainPlayerCharacter(); //캐릭터 자료불러오고
		//m.equip(); //장비장착
		//OwnedItem[] o= m.getOwnedItem(); //장비 장착한걸 클래스화
		OwnedItem[] o = getOwnedItem();
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
		System.out.println("내 hp :"+mainChar.getHp());
	}
	
	
	//set모음
	void setOwnedItem(OwnedItem[] OwnedItem)
	{
		this.OwnedItem = OwnedItem;
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
	
	
}
