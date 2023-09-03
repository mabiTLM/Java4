package makeCardGame230901.cardBundle;

import makeCardGame230901.characterBundle.PlayerCharacter;

public class BattleCombine 
{
	PlayerCharacter player;
	Battle battle;
	private int playerTurnGaze =0;//행동게이지
	private int[] enemyTurnGaze;
	
	public BattleCombine(PlayerCharacter playerCharacter, Battle battle)
	{
		this.player=playerCharacter;
		this.battle=battle;
	}
	public void battleCombine()
	{
		//조우시 행동
		battle.encounter();
		battle.cardShuffle();
		//속도계산
		enemyTurnGaze= new int[battle.currentEnemy.length];//적숫자가 랜덤이라서 여기서 생성, 적이죽었을때는??
	
		while(true) {
			//행동게이지 개념
			playerTurnGaze = playerTurnGaze+player.getSpeed();//속도만큼 행동게이지증가
			for(int i = 0; i <enemyTurnGaze.length;i++)
			{
				enemyTurnGaze[i]=enemyTurnGaze[i]+battle.currentEnemy[i].getSpeed();//적 행동게이지 증가
				if(enemyTurnGaze[i]>100&&enemyTurnGaze[i]>playerTurnGaze)//행동게이지가 차고 적이 높을경우 상대턴부터 받는다.
				{
					battle.currentEnemy[i].setEnemyTurn(true);
					battle.setPlayerTurn(false);
				}
				if(playerTurnGaze>=100&&playerTurnGaze>=enemyTurnGaze[i])//행동게이지 100이상이고 적보다 높을때만
				{
					battle.setPlayerTurn(true);
				}
			}
			//여기까지 행동게이지 처리
			
			
			
			if(battle.getPlayerTurn()) 
			{
				battle.cardDraw();
			}			
			while(battle.getPlayerTurn()) 
			{
				battle.targetLockOn(this);
				if(player.getHand().length<1|battle.getPlayerTurn()==false)
				{
					playerTurnGaze=playerTurnGaze-100;//행동끝났으면 수치낮추기
					break;
				}
			}
			if(battle.currentEnemy.length<1)
			{
				break;
			}
			
			//모든 몬스터 제거시 실행종료
			
			
			//몬스터행동
			
			for(int i = 0; i <battle.currentEnemy.length; i++) //적의 수만큼 반목
			{
				while(battle.currentEnemy[i].getEnemyTurn())//턴이 켜져있을 때
				{
					System.out.println("적행동실험");
					
					//행동끝난 후
					enemyTurnGaze[i]= enemyTurnGaze[i]-100;
					battle.currentEnemy[i].setEnemyTurn(false);
				}
				
				
			}
		}
		
	}
	
	//set모음
	public void setEnemyTurnGaze(int[] enemyTurnGaze)
	{
		this.enemyTurnGaze=enemyTurnGaze;
	}
	
	//get모음
	public int[] getEnemyTurnGaze()
	{
		return enemyTurnGaze;
	}
}
