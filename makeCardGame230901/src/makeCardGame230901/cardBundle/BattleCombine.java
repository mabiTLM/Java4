package makeCardGame230901.cardBundle;

import makeCardGame230901.characterBundle.PlayerCharacter;

public class BattleCombine 
{
	PlayerCharacter player;
	Battle battle;
	
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
		while(true){
			//플레이어 행동
			battle.cardDraw();
			while(true) {
				battle.targetLockOn();
				if(player.getHand().length<1|battle.getPlayerTurn()==false)
				{
					break;
				}
			}
			
			
			//몬스터행동
		}
		
	}
}
