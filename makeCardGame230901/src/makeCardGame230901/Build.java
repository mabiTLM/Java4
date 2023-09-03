package makeCardGame230901;

import makeCardGame230901.cardBundle.Battle;
import makeCardGame230901.cardBundle.BattleCombine;
import makeCardGame230901.characterBundle.PlayerCharacter;
import makeCardGame230901.village.MoveInVillage;

public class Build {
	PlayerCharacter player = new PlayerCharacter();
	Battle battle = new Battle(player);
	BattleCombine battleCombine = new BattleCombine(player,battle);
	MoveInVillage moveInvillage = new MoveInVillage(); 
	void build()
	{
		while(moveInvillage.getLocationVillage()) 
		{
			moveInvillage.MoveVillage(player);
		}
		battleCombine.battleCombine();
	}

}
