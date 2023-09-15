package makeCardGame230901.village;

import java.io.Serializable;
import java.util.Scanner;
import makeCardGame230901.cardBundle.cardSortBundle.SortCard;
import makeCardGame230901.characterBundle.PlayerCharacter;

public class EditDeck implements Serializable // 덱 수정하기 추가할때 제거할때
{
  /**
   * 
   */
  private static final long serialVersionUID = -5268548532628917832L;
  private int choice = 0;
  SortCard sortCard = new SortCard();

  void edit(PlayerCharacter player) {
    Scanner scan = new Scanner(System.in);
    while (true) {
      try {
        player.DeckOpen();
        System.out.println("1.카드추가");
        System.out.println("2.카드제거");
        System.out.println("3.돌아가기");
        choice = scan.nextInt();
        scan.nextLine();
        if (choice == 1) {
          addCard(player);
        } else if (choice == 2) {
          reduceCard(player);
        } else if (choice == 3) {
          break;
        }
      } catch (Exception e) {
        scan.nextLine();
        e.printStackTrace();
      }
    }
  }

  void addCard(PlayerCharacter player)// 덱목록과 소지카드목록을 보여주고 넣는다.
  {
    Scanner scan = new Scanner(System.in);
    while (true) {
      try {
        player.DeckOpen();
        System.out.println();
        player.InventoryOpen();
        System.out.println("몇번 카드를 넣나요? 0.돌아가기");
        // 인벤비었을때 잘라줘야하는곳
        choice = scan.nextInt();// 카드고르고
        scan.nextLine();
        if (choice == 0) {
          System.out.println("돌아갑니다.");
          break;
        } else if (choice > player.getCardInventory().length) {
          System.out.println("인벤토리보다 큽니다.");

        } else {
          player.setCardDeck(
              sortCard.sortAddCard(player.getCardDeck(), player.getCardInventory(), choice));// 카드를
                                                                                             // 넣는다.
          // 넣었으니 이제 인벤토리에서 카드를 줄이자.
          player.setCardInventory(sortCard.sortRemoveCard(player.getCardInventory(), choice));
        }
      } catch (Exception e) {
        scan.nextLine();
        e.printStackTrace();
      }
    }

  }

  void reduceCard(PlayerCharacter player) {
    Scanner scan = new Scanner(System.in);
    while (true) {
      try {
        player.DeckOpen();
        System.out.println("몇번 카드를 빼나요? 0.돌아가기");
        choice = scan.nextInt();// 카드고르고
        scan.nextLine();
        System.out.println();
        if (choice == 0) {
          System.out.println("돌아갑니다.");
          break;
        } else if (choice > player.getCardDeck().length) {
          System.out.println("덱보다 큽니다.");

        } else {
          player.setCardInventory(
              sortCard.sortAddCard(player.getCardInventory(), player.getCardDeck(), choice));
          // 카드를 넣는다.
          // 넣었으니 이제 덱에서 카드를 줄이자.
          player.setCardDeck(sortCard.sortRemoveCard(player.getCardDeck(), choice));
        }
      } catch (Exception e) {
        scan.nextLine();
        e.printStackTrace();
      }
    }

  }
}