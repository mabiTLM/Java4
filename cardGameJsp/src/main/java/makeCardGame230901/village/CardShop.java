package makeCardGame230901.village;

import java.io.Serializable;
import java.util.Scanner;
import makeCardGame230901.cardBundle.CARDTYPE;
import makeCardGame230901.cardBundle.TotalCardBase;
import makeCardGame230901.cardBundle.cardSortBundle.SortCard;
import makeCardGame230901.characterBundle.PlayerCharacter;

public class CardShop implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = -7335692219932781123L;
  TotalCardBase totalCardBase = new TotalCardBase();
  SortCard sortCard = new SortCard();

  /**
   * 가격을 표시하는 카드상세.
   **/
  public void watchCardDataDetail(TotalCardBase[] cardSet) {
    for (int i = 0; i < cardSet.length; i++) {
      System.out
          .print((i + 1) + "." + cardSet[i].getCardName() + " : " + cardSet[i].getCardValue());
      if (cardSet[i].getCardType() == CARDTYPE.Attack) {
        System.out.print("공격력");
      }

      else if (cardSet[i].getCardType() == CARDTYPE.Defend) {
        System.out.print("방어도");
      }

      else if (cardSet[i].getCardType() == CARDTYPE._HEAL_) {
        System.out.print("회복");
      }

      System.out.print(" /소비마나 : " + cardSet[i].getCardConsumeMana());

      if (!cardSet[i].getEffect().equals("통상")) {
        if (cardSet[i].getEffectValue() == 0) {
          System.out.print(" /효과 : " + cardSet[i].getEffect());
        } else {
          System.out.print(" /효과 : " + cardSet[i].getEffectValue() + cardSet[i].getEffect());
        }
      }

      if (cardSet[i].getVolatility()) {
        System.out.print(" 휘발성");
      } else {
        System.out.print("");
      }
      System.out.println(" /가격 : " + cardSet[i].getCardPrice());
    }
  }

  void buyItem(PlayerCharacter player) {
    Scanner scan = new Scanner(System.in);
    while (true) {
      // 상점 카드목록을 보여준다
      watchCardDataDetail(totalCardBase.shopSellCard());

      System.out.println("어느 카드를 살래? 0.돌아가기 ,00.덱과 인벤확인");
      String choice = scan.nextLine();
      if (choice.equals("0")) {
        break;
      } else if (choice.equals("00")) {
        player.DeckOpen();
        scan.nextLine();
        player.InventoryOpen();
        scan.nextLine();

      } else if (Integer.valueOf(choice) > 0
          && Integer.valueOf(choice) < totalCardBase.shopSellCard().length + 1) {
        int cardNumber = Integer.valueOf(choice);
        int result =
            player.getMoney() - totalCardBase.shopSellCard()[cardNumber - 1].getCardPrice();
        if (result >= 0) {
          player.setMoeny(result);
          player.setCardInventory(sortCard.sortAddCard(player.getCardInventory(),
              totalCardBase.shopSellCard(), cardNumber));
        } else {
          System.out.println("돈이 부족합니다.");
          scan.nextLine();
        }
      } else {
        System.out.println("다시골라줘");
        scan.nextLine();
      }
    }
  }
}
