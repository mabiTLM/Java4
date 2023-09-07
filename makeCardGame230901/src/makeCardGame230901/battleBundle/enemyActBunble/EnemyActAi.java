package makeCardGame230901.battleBundle.enemyActBunble;

import makeCardGame230901.battleBundle.Battle;
import makeCardGame230901.characterBundle.EnemyCharacter;
import makeCardGame230901.characterBundle.PlayerCharacter;

public class EnemyActAi extends EnemyBattleAct {
	EnemyCharacter actEnemy;
	public EnemyActAi(PlayerCharacter player, Battle battle) {
		super(player, battle);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 *0.슬라임 1.도적 2.골렘 3.보스 
	 **/	
	public void totalAi(int actMonsterNumber)
	{
		actEnemy = battle.getCurrentEnemy()[actMonsterNumber];
		int ai = actEnemy.getAiPattern();		
		if(ai==0)
		{
			onlyAttack(actMonsterNumber);
		}
		else if(ai==1)
		{
			onlyAttack(actMonsterNumber);
		}
		else if(ai==2)
		{
			golemAi(actMonsterNumber);
		}
		else if(ai==3)
		{
			onlyAttack(actMonsterNumber);
		}
		
		actEnemy.setEnemyRepeat(actEnemy.getEnenmyRepeat()+1);
	}
	
	
	private void onlyAttack(int actMonsterNumber)
	{
		plainAttack(actMonsterNumber);
	}
	
	private void golemAi(int actMonsterNumber)
	{
		actEnemy = battle.getCurrentEnemy()[actMonsterNumber];
		if(actEnemy.getEnenmyRepeat()%3==0)
		{
			
		}
	}

}
