package makeCardGame230901;

import makeCardGame230901.cardBundle.TotalCardBase;
import makeCardGame230901.characterBundle.PlayerCharacter;

public class PlayerReset {
	
	TotalCardBase[] tempPlayerinven;
	TotalCardBase[] tempDeck;
	
	int tempMaxHp;
	int tempMaxMp;
	
	void setResetData(PlayerCharacter player)
	{
		this.tempPlayerinven=player.getCardInventory();
		this.tempDeck=player.getCardDeck();
		this.tempMaxHp=player.getMaxHp();
		this.tempMaxMp=player.getMaxMp();
	}
	
	void getResetData(PlayerCharacter player)
	{
		player.setCardInventory(tempPlayerinven);
		player.setCardDeck(tempDeck);
		player.setMaxHp(tempMaxHp);
		player.setMaxMp(tempMaxMp);
	}

}
