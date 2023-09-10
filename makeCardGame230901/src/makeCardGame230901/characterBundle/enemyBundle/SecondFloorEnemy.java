package makeCardGame230901.characterBundle.enemyBundle;

import makeCardGame230901.characterBundle.MONSTEREFFECT;

public class SecondFloorEnemy extends EnemyCharacter {
	@Override
	public EnemyCharacter[] stageData()
	{
		stageEnemy = new EnemyCharacter[3];
		stageEnemy[0] = new EnemyCharacter("슬라임",30,30,10,0,100,10,0);
		stageEnemy[1] = new EnemyCharacter("도적",30,30,10,0,100,20,1,MONSTEREFFECT.ATTACKUP,3);
		stageEnemy[2] = new EnemyCharacter("작은 골렘",50,50,50,50,100,5,2,MONSTEREFFECT.SHIELD,50);
		return stageEnemy;
	}
	
	@Override
	public EnemyCharacter[] stageEliteData()
	{
		stageEnemy = new EnemyCharacter[3];
		stageEnemy[0] = new EnemyCharacter("골렘",100,100,100,50,1000,8,2,MONSTEREFFECT.SHIELD,100);
		stageEnemy[1] = new EnemyCharacter("상급 닌자",50,50,10,0,1000,30,1,MONSTEREFFECT.ATTACKUP,5);
		stageEnemy[2] = new EnemyCharacter("킹 슬라임",50,50,10,20,1000,10,4,MONSTEREFFECT.USESKILL,0);
		return stageEnemy;
	}
	
	@Override
	public EnemyCharacter[] stageBossData()
	{
		stageEnemy = new EnemyCharacter[1];
		stageEnemy[0] = new EnemyCharacter("글라스기브넨",1000,0,1000,0,100,1000,100,10,3);
		return stageEnemy;
	}
}
