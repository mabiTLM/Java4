package makeCardGame230901.characterBundle;

import makeCardGame230901.cardBundle.TotalCardBase;
import makeCardGame230901.cardBundle.cardSortBundle.SortCard;

public class PlayerReset {

  TotalCardBase[] tempPlayerinven;
  TotalCardBase[] tempDeck;
  SortCard sortCard = new SortCard();

  int tempMaxHp;
  int tempMaxMp;

  public void setResetData(PlayerCharacter player) {
    this.tempPlayerinven = player.getCardInventory();
    this.tempDeck = sortCard.deepCopyDeck(player.getCardDeck());
    this.tempMaxHp = player.getMaxHp();
    this.tempMaxMp = player.getMaxMp();
  }

  public void getResetData(PlayerCharacter player) {
    player.setCardInventory(tempPlayerinven);
    player.setCardDeck(tempDeck);
    player.setMaxHp(tempMaxHp);
    player.setMaxMp(tempMaxMp);
  }

}
