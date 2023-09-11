package makeCardGame230901.mapBundle;

import java.util.Random;
import java.util.Scanner;
import makeCardGame230901.cardBundle.CardType;
import makeCardGame230901.cardBundle.TotalCardBase;
import makeCardGame230901.cardBundle.cardSortBundle.SortCard;
import makeCardGame230901.characterBundle.PlayerCharacter;
import makeCardGame230901.village.CardShop;

public class EventInDungeon {
  private PlayerCharacter player;
  private TotalCardBase cardData = new TotalCardBase();
  private SortCard sortCard = new SortCard();
  private TotalCardBase[] cardShopInDungeon = cardData.dungeonShopCard();
  CardShop cardShop = new CardShop();
  Scanner scan = new Scanner(System.in);


  Random random = new Random();
  String[] story = {"랜덤카드 파워강화", "이벤트 카드를 얻습니다.", "선택 : 현재와 미래", "재빠른 선택", "돈놓고 돈먹기", "함정"};

  public EventInDungeon(PlayerCharacter player) {
    this.player = player;
  }


  public void event() {
    int temp = random.nextInt(story.length);
    System.out.println(story[temp]);
    switch (temp) {
      case 0:
        cardEnhancedEvent();
        break;
      case 1:
        cardAddEvent(cardData.totalCard());
        break;
      case 2:
        getMoneyOrHealth();
        break;
      case 3:
        speedOrDraw();
        break;
      case 4:
        gambleEvent();
        break;
      case 5:
        trapEvent();
        break;
    }
    scan.nextLine();
  }


  public void cardEnhancedEvent() {
    while (true) {
      int randomCard = random.nextInt(player.getCardDeck().length) + 1;
      if (player.getCardDeck()[randomCard - 1].getEnforce() == false) {
        int temp = random.nextInt(2);
        if (temp == 0) {
          sortCard.enhanceCardPower(player.getCardDeck(), randomCard);
        } else if (temp == 1) {
          sortCard.enhanceCardMana(player.getCardDeck(), randomCard);
        }
        break;
      }
    }
  }


  public void cardAddEvent(TotalCardBase[] getCardEvent) {
    TotalCardBase[] tempEventCard = new TotalCardBase[3];

    for (int i = 0; i < 3; i++) {
      int tempRandomEventNumber = random.nextInt(getCardEvent.length);
      tempEventCard[i] = getCardEvent[tempRandomEventNumber];
    }
    while (true) {
      try {
        sortCard.watchCard(tempEventCard, player);
        System.out.println("몇번째 카드를 가지나요? 0.고르지 않는다.");
        int temp = scan.nextInt();
        scan.nextLine();
        if (temp > 0 && temp < 4) {
          player.setCardDeck(sortCard.sortAddCard(player.getCardDeck(), tempEventCard, temp));
          break;
        } else if (temp == 0) {
          break;
        } else {
          System.out.println("다시 골라주세요");
        }
      } catch (Exception e) {
        scan.nextLine();
        e.printStackTrace();
      }
    }

  }


  public void getMoneyOrHealth() {
    while (true) {
      try {
        System.out.println("1.현재를 생각한다.  hp최대치50 증가, 이번 모험에서 MP 1증가");
        System.out.println("2.미래를 생각한다.  1000골드 획득");
        int choice = scan.nextInt();
        scan.nextLine();
        if (choice == 1) {
          player.setMaxMp(player.getMaxMp() + 1);
          player.setMaxHp(player.getMaxHp() + 50);
          player.setHp(player.getHp() + 50);
        } else if (choice == 2) {
          player.setMoeny(player.getMoney() + 1000);
        } else {
          System.out.println("다시 골라주세요.");
          continue;
        }
        break;
      } catch (Exception e) {
        scan.nextLine();
        e.printStackTrace();
      }
    }
  }


  public void speedOrDraw() {
    while (true) {
      try {
        System.out.println("1.속도가 중요하다. 속도 5증가");
        System.out.println("2.손재주가 중요하다. 이번 모험에서 드로우 카드 1 증가");
        int choice = scan.nextInt();
        scan.nextLine();
        if (choice == 1) {
          player.setSpeed(player.getSpeed() + 5);
        } else if (choice == 2) {
          player.setDrawCardNumber(player.getDrawCardNumber() + 1);
        } else {
          System.out.println("다시 골라주세요.");
          continue;
        }
        break;
      } catch (Exception e) {
        scan.nextLine();
        e.printStackTrace();
      }
    }
  }


  public void gambleEvent() {
    while (true) {
      try {
        System.out.println("1.도박한다(45%확률로 돈 두배, 55%확률로 돈절반)\n2.그만둔다.");
        int choice = scan.nextInt();
        scan.nextLine();
        if (choice == 1) {
          int percent = random.nextInt(100);
          int result = percent > 44 ? player.getMoney() * 2 : player.getMoney() / 2;
          player.setMoeny(result);
          System.out.println("돈이 " + player.getMoney() + "가 되었다");
          break;
        } else if (choice == 2) {
          System.out.println("도박은 하지않습니다.");
          break;
        }
      } catch (Exception e) {
        scan.nextLine();
        e.printStackTrace();
      }
    }
  }

  public void trapEvent() {
    while (true) {
      try {
        System.out.println("함정에 빠졌습니다.\n1.드로우를 하나 줄인다.\n2.덱에 부상을 두개 집어넣는다.");

        int choice = scan.nextInt();
        if (choice == 1) {
          player.setDrawCardNumber(player.getDrawCardNumber() - 1);
          break;
        } else if (choice == 2) {
          TotalCardBase[] bad = {new TotalCardBase("부상", CardType.Defend, 0, 0, 0)};
          player.setCardDeck(sortCard.sortAddCard(player.getCardDeck(), bad, 1));
          player.setCardDeck(sortCard.sortAddCard(player.getCardDeck(), bad, 1));
          break;
        }


      } catch (Exception e) {
        scan.nextLine();
        e.printStackTrace();
      }
    }
  }


  public void campfire() {
    while (true) {
      try {
        System.out.println("1.카드강화");
        System.out.println("2.카드제거");
        System.out.println("3.휴식한다");
        int choice = scan.nextInt();
        scan.nextLine();
        if (choice == 1) {
          player.DeckOpen();
          System.out.println("몇번째 카드를 강화하나요?");
          int cardChoice = scan.nextInt();
          scan.nextLine();
          if (player.getCardDeck()[cardChoice - 1].getEnforce() == false) {
            System.out.println("어떤 강화를 하나요? 1.파워강화 2.마나소비감소");
            choice = scan.nextInt();
            scan.nextLine();
            if (choice == 1) {
              sortCard.enhanceCardPower(player.getCardDeck(), cardChoice);
              break;
            } else if (choice == 2) {
              sortCard.enhanceCardMana(player.getCardDeck(), cardChoice);
              break;
            } else {
              System.out.println("다시 선택해주세요.");
            }

          } else {
            System.out.println("해당카드는 이미 강화됐습니다.");
          }

        } else if (choice == 2) {
          player.DeckOpen();
          System.out.println("몇번째 카드를 제거하나요?");
          int cardChoice = scan.nextInt();
          scan.nextLine();
          player.setCardDeck(sortCard.sortRemoveCard(player.getCardDeck(), cardChoice));
          break;
        } else if (choice == 3) {
          player.setHp(player.getMaxHp());
          System.out.println("완전히 회복했다.");
          break;
        }
      } catch (Exception e) {
        scan.nextLine();
        e.printStackTrace();
      }
    }
  }

  public void dungeonShop() {
    TotalCardBase[] currentShopCard = new TotalCardBase[6]; // 랜덤으로 6장

    for (int i = 0; i < currentShopCard.length; i++) {
      int temp = random.nextInt(cardShopInDungeon.length);
      currentShopCard[i] = cardShopInDungeon[temp];
    }

    while (true) {
      try {
        System.out.println("구매한 카드는 이번 모험에서만 사용가능하니 주의하라구");
        cardShop.watchCardDataDetail(currentShopCard);
        System.out.println("몇번 카드를 살래? 0.그만둔다.");
        int choice = scan.nextInt();

        if (choice == 0) {
          break;
        } else if (choice > 0 && choice - 1 < currentShopCard.length) {
          int tempResult = player.getMoney() - currentShopCard[choice - 1].getCardPrice();
          if (tempResult >= 0) {
            player.setMoeny(tempResult);
            player.setCardDeck(sortCard.sortAddCard(player.getCardDeck(), currentShopCard, choice));
            System.out.println(currentShopCard[choice - 1].getCardName() + "을 구매했다.");
            currentShopCard = sortCard.sortRemoveCard(currentShopCard, choice);
          } else {
            System.out.println("돈이 부족해");
          }
        }

      } catch (Exception e) {
        scan.nextLine();
        e.printStackTrace();
      }

    }
  }
}
