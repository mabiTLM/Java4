package makeCardGame230901.battleBundle.enemyActBunble;

import makeCardGame230901.battleBundle.Battle;
import makeCardGame230901.characterBundle.PlayerCharacter;
import makeCardGame230901.characterBundle.enemyBundle.EnemyCharacter;

public class EnemyActAi extends EnemyBattleAct {
	EnemyCharacter actEnemy;
	public EnemyActAi(PlayerCharacter player, Battle battle) {
		super(player, battle);
	}
	
	/**
	 *0.슬라임 1.도적 2.골렘 3.보스 
	 **/	
	public void totalAi(int actMonsterNumber)
	{
		actEnemy = battle.getCurrentEnemy()[actMonsterNumber];
		actEnemy.setEnemyRepeat(actEnemy.getEnenmyRepeat()+1);
		int ai = actEnemy.getAiPattern();		
		if(actEnemy.getHp()<=0)
		{
			battle.monsterDie();
		}		
		else if(ai==0)
		{
			slimeAi(actMonsterNumber);
		}
		else if(ai==1)
		{
			theifAi(actMonsterNumber);
		}
		else if(ai==2)
		{
			golemAi(actMonsterNumber);
		}
		else if(ai==3)
		{
			bossAi(actMonsterNumber);
		}		
	}
	
	
	private void slimeAi(int actMonsterNumber)
	{
		if(actEnemy.getEnenmyRepeat()%2==0)
		{
			badSlimeCardAdd(actMonsterNumber);
		}
		else {
			plainAttack(actMonsterNumber);
		}		
	}
	
	private void golemAi(int actMonsterNumber)
	{
		actEnemy = battle.getCurrentEnemy()[actMonsterNumber];
		if(actEnemy.getEnenmyRepeat()%2==0)
		{
			defUp(actMonsterNumber);
		}
		else
		{
			plainAttack(actMonsterNumber);
		}
	}	
	
	private void theifAi(int actMonsterNumber)
	{
		actEnemy = battle.getCurrentEnemy()[actMonsterNumber];
		if(actEnemy.getEnenmyRepeat()%3==2)
		{
			plainAttack(actMonsterNumber);
		}
		else
		{
			atkUp(actMonsterNumber);			
		}
	}
	
	private void bossAi(int actMonsterNumber)
	{
		actEnemy = battle.getCurrentEnemy()[actMonsterNumber];
		if(actEnemy.getEnenmyRepeat()%4==0)
		{
			fearCardStun(actMonsterNumber);
		}
		else if(actEnemy.getEnenmyRepeat()%4==1)
		{
			plainAttack(actMonsterNumber);
		}
		else if(actEnemy.getEnenmyRepeat()%4==2)
		{
			readyReflect(actMonsterNumber);
		}
		else if(actEnemy.getEnenmyRepeat()%4==3)
		{
			reflectAttack(actMonsterNumber);
		}
	}

}
