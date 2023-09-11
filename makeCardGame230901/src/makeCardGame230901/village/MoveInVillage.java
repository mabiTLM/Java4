package makeCardGame230901.village;

import java.util.Scanner;
import makeCardGame230901.characterBundle.PlayerCharacter;

public class MoveInVillage {
  private boolean locationVillage = true;
  int choice = 0;
  EditDeck editDeck = new EditDeck();
  CardShop cardShop = new CardShop();
  Scanner scan = new Scanner(System.in);

  public void MoveVillage(PlayerCharacter player) {
    while (true) {
      try {
        player.setHp(player.getMaxHp());// 마을에선 풀피로
        System.out.println("소지금 : " + player.getMoney());
        System.out.println("1.덱수정");
        System.out.println("2.모험으로");
        System.out.println("3.상점으로");
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
