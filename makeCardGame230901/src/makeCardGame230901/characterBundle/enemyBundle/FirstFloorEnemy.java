package makeCardGame230901.characterBundle.enemyBundle;

import makeCardGame230901.characterBundle.MONSTEREFFECT;

public class FirstFloorEnemy extends EnemyCharacter {
	
	@Override
	public EnemyCharacter[] stageData()
	{
		stageEnemy = new EnemyCharacter[3];
		stageEnemy[0] = new EnemyCharacter("슬라임",20,20,5,0,100,5,0);
		stageEnemy[1] = new EnemyCharacter("도적",20,20,5,0,100,11,1,MONSTEREFFECT.ATTACKUP,3);
		stageEnemy[2] = new EnemyCharacter("작은 골렘",50,50,20,20,100,4,2,MONSTEREFFECT.SHIELD,20);
		return stageEnemy;
	}
	
	@Override
	public EnemyCharacter[] stageEliteData()
	{
		stageEnemy = new EnemyCharacter[2];
		stageEnemy[0] = new EnemyCharacter("골렘",100,100,100,50,1000,4,2,MONSTEREFFECT.SHIELD,50);
		stageEnemy[1] = new EnemyCharacter("상급 닌자",50,50,10,0,1000,20,1,MONSTEREFFECT.ATTACKUP,5);
		return stageEnemy;
	}
	
	@Override
	public EnemyCharacter[] stageBossData()
	{
		stageEnemy = new EnemyCharacter[1];
		stageEnemy[0] = new EnemyCharacter("글라스기브넨",500,0,500,0,50,1000,100,10,3);
		return stageEnemy;
	}
}
