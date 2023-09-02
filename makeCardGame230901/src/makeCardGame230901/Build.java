package makeCardGame230901;

import makeCardGame230901.cardBundle.Battle;
import makeCardGame230901.cardBundle.BattleCombine;
import makeCardGame230901.characterBundle.PlayerCharacter;

public class Build {
	PlayerCharacter playerCharacter = new PlayerCharacter();
	Battle battle = new Battle(playerCharacter);
	BattleCombine battleCombine = new BattleCombine(playerCharacter,battle);
	void build()
	{
		battleCombine.battleCombine();
	}

}
