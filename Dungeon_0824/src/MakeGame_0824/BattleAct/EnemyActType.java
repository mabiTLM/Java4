package MakeGame_0824.BattleAct;

import MakeGame_0824.CharacterBundle.EnemyCharacter;
import MakeGame_0824.CharacterBundle.MainPlayerCharacter;
import MakeGame_0824.CharacterBundle.OwnedItem;
import MakeGame_0824.CharacterBundle.OwnedSkill;
import MakeGame_0824.MapBundle.Dungeon.DungeonMap;



public class EnemyActType //몹행동패턴
{	
//	OwnedItem[] OwnedItem;
//	OwnedSkill[] OwnedSkill;
	private int enemyActChoice=0;
	private MainPlayerCharacter mainChar;
//	private EnemyCharacter[] eArray;
	
	public void enemyAct(MainPlayerCharacter mainChar,EnemyCharacter[] eArray, int enemyNumber , int enemyActChoice)//공격타입은 아직 더미
	{
		OwnedItem[] o = mainChar.getOwnedItem();
		if(enemyActChoice==0)//무조건 평타
		{
			setEnemyActChoice(0);
			enemyBattleCalculator(mainChar,eArray,enemyNumber);
		}
		else if(enemyActChoice==1)//슬라임 ai
		{
			setEnemyActChoice(0);
			enemyBattleCalculator(mainChar,eArray,enemyNumber);			
			System.out.println("슬라임이 녹고 있다. 방어력이 올라간다.");
			eArray[enemyNumber].setDef(eArray[enemyNumber].getDef()+1);
			if(eArray[enemyNumber].getAtk()-o[1].getWeaponDef()<=0||eArray[enemyNumber].getHp()<=2)
			{
				setEnemyActChoice(5);			
			}
		}
		else if(enemyActChoice==2)//뿔사슴
		{
			setEnemyActChoice(0);
			
			if(eArray[enemyNumber].getHp()<=100)
			{
				System.out.println("뿔사슴이 광포화한 상태입니다.");
				eArray[enemyNumber].setAtk(eArray[enemyNumber].getAtk()+50);
			}
			
			enemyBattleCalculator(mainChar,eArray,enemyNumber);
			enemyBattleCalculator(mainChar,eArray,enemyNumber);
			
			if(eArray[enemyNumber].getHp()<300&&eArray[enemyNumber].getMp()>0)
			{
				System.out.println("뿔사슴이 회복합니다.");
				eArray[enemyNumber].setMp(eArray[enemyNumber].getMp()-1);
				eArray[enemyNumber].setHp(eArray[enemyNumber].getHp()+100);
				System.out.println("적의 체력 : "+eArray[enemyNumber].getHp());
				
			}
			
			
			
		}
	}
	
	
	public void enemyBattleCalculator(MainPlayerCharacter mainChar,EnemyCharacter[] eArray, int enemyNumber) 
	{	//평타
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
	
	public void enemySkill()
	{
		
	}
	
	public void enemyRunAway()
	{
		
	}
	
	public void setEnemyActChoice(int enemyActChoice)
	{
		this.enemyActChoice=enemyActChoice;
	}
	
	public int getEnemyActChoice()
	{
		return enemyActChoice;
	}
	
}
