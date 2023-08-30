package MakeGame_0824.BattleAct;

import MakeGame_0824.CharacterBundle.EnemyCharacter;
import MakeGame_0824.CharacterBundle.MainPlayerCharacter;
import MakeGame_0824.CharacterBundle.OwnedItem;
import MakeGame_0824.CharacterBundle.OwnedSkill;
import MakeGame_0824.MapBundle.Dungeon.DungeonMap;



public class EnemyActType //몹행동패턴
{	
	OwnedItem[] OwnedItem;
	OwnedSkill[] OwnedSkill;
	DungeonMap dungeonMap;
//	private MainPlayerCharacter mainChar;
//	private EnemyCharacter[] eArray;
//	private int enemyNumber = 0;
	
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
}
