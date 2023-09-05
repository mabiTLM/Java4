package makeCardGame230901.characterBundle;

import makeCardGame230901.cardBundle.TotalCardBase;

public class PlayerReset {
	
	TotalCardBase[] tempPlayerinven;
	TotalCardBase[] tempDeck;
	
	int tempMaxHp;
	int tempMaxMp;
	
	public void setResetData(PlayerCharacter player)
	{
		this.tempPlayerinven=player.getCardInventory();
		this.tempDeck=player.getCardDeck();
		this.tempMaxHp=player.getMaxHp();
		this.tempMaxMp=player.getMaxMp();
	}
	
	public void getResetData(PlayerCharacter player)
	{
		player.setCardInventory(tempPlayerinven);
		player.setCardDeck(tempDeck);
		player.setMaxHp(tempMaxHp);
		player.setMaxMp(tempMaxMp);
	}

}
