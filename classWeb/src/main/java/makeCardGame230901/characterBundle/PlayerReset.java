package makeCardGame230901.characterBundle;

import java.io.Serializable;
import makeCardGame230901.cardBundle.TotalCardBase;
import makeCardGame230901.cardBundle.cardSortBundle.SortCard;

public class PlayerReset implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 8749993498957871748L;
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
