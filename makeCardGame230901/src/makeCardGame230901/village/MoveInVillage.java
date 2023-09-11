package makeCardGame230901.village;

import java.io.Serializable;
import java.util.Scanner;
import makeCardGame230901.characterBundle.PlayerCharacter;

public class MoveInVillage implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 3651758746650752453L;
  private boolean locationVillage = true;
  int choice = 0;
  EditDeck editDeck = new EditDeck();
  CardShop cardShop = new CardShop();

  public void MoveVillage(PlayerCharacter player) {
    Scanner scan = new Scanner(System.in);
    while (true) {
      try {
        player.setHp(player.getMaxHp());// 마을에선 풀피로
        System.out.println("소지금 : " + player.getMoney());
        System.out.println("1.덱수정");
        System.out.println("2.모험으로");
        System.out.println("3.상점으로");
        System.out.println("4.메뉴열기");
        choice = scan.nextInt();
        scan.nextLine();
        if (choice == 1) {
          editDeck.edit(player);
        } else if (choice == 2) {
          if (player.getCardDeck().length < 8) {
            System.out.println("덱은 8장 이상이어야한다.");
          } else {
            locationVillage = false;
          }
        } else if (choice == 3) {
          cardShop.buyItem(player);
        } else if (choice == 4) {
          player.setOpenMenu(true);
        }
        break;
      } catch (Exception e) {
        scan.nextLine();
        e.printStackTrace();
      }
    }


  }

  public void setLocationVillage(boolean locationVillage) {
    this.locationVillage = locationVillage;
  }

  public boolean getLocationVillage() {
    return locationVillage;
  }
}
