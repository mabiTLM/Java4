package makeCardGame230901.cardBundle;

import makeCardGame230901.characterBundle.PlayerCharacter;

public class BattleCombine 
{
	PlayerCharacter playerCharacter;
	Battle battle;
	
	public BattleCombine(PlayerCharacter playerCharacter, Battle battle)
	{
		this.playerCharacter=playerCharacter;
		this.battle=battle;
	}
	public void battleCombine()
	{
		battle.encounter();
		battle.cardShuffle();		
		while(true){
		battle.cardDraw();
		while(true)
		{
		battle.targetLockOn();
		battle.useCard();
		}
		}
	}
}
