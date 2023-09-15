package makeCardGame230901.battleBundle.enemyActBunble;

import java.io.Serializable;
import java.util.Scanner;
import makeCardGame230901.battleBundle.Battle;
import makeCardGame230901.cardBundle.cardSortBundle.SortCard;
import makeCardGame230901.characterBundle.PlayerCharacter;
import makeCardGame230901.characterBundle.enemyBundle.EnemyCharacter;

public class EnemyActAi extends EnemyBattleAct implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 2409473060879313486L;
  EnemyCharacter actEnemy;
  SortCard sortCard = new SortCard();
  int temp;

  public EnemyActAi(PlayerCharacter player, Battle battle) {
    super(player, battle);
  }

  /**
   * 0.일반슬라임 1.도적 2.골렘 3.글라스기브넨 4.강화슬라임
   **/
  public void totalAi(int actMonsterNumber) {
    actEnemy = battle.getCurrentEnemy()[actMonsterNumber];
    actEnemy.setEnemyRepeat(actEnemy.getEnenmyRepeat() + 1);
    int ai = actEnemy.getAiPattern();
    if (ai == 0) {
      slimeAi(actMonsterNumber);
    } else if (ai == 1) {
      theifAi(actMonsterNumber);
    } else if (ai == 2) {
      golemAi(actMonsterNumber);
    } else if (ai == 3) {
      gurasugibunenAi(actMonsterNumber);
    } else if (ai == 4) {
      divideSlimeAi(actMonsterNumber);
    } else if (ai == 5) {
      quizAi(actMonsterNumber);
    } else if (ai == 6) {
      mordecaiFirstForm(actMonsterNumber);
    } else if (ai == 7) {
      mordecaiSecondForm(actMonsterNumber);
    } else if (ai == 8) {
      mordecaiThirdForm(actMonsterNumber);
    }
  }


  private void slimeAi(int actMonsterNumber) {
    if (actEnemy.getEnenmyRepeat() % 2 == 1) {
      badSlimeCardAdd(actMonsterNumber);
    } else {
      plainAttack(actMonsterNumber);
    }
  }

  private void divideSlimeAi(int actMonsterNumber) {
    if (actEnemy.getEnenmyRepeat() % 2 == 1) {
      summonMonster(new EnemyCharacter("분열된 슬라임", actEnemy.getHp(), actEnemy.getHp(),
          actEnemy.getAtk(), actEnemy.getDef(), 0, actEnemy.getSpeed(), 4));
      badSlimeCardAdd(actMonsterNumber);
    } else {
      plainAttack(actMonsterNumber);
    }
  }

  private void golemAi(int actMonsterNumber) {
    actEnemy = battle.getCurrentEnemy()[actMonsterNumber];
    if (actEnemy.getEnenmyRepeat() % 2 == 1) {
      defUp(actMonsterNumber);
    } else {
      plainAttack(actMonsterNumber);
    }
  }

  private void theifAi(int actMonsterNumber) {
    actEnemy = battle.getCurrentEnemy()[actMonsterNumber];
    if (actEnemy.getEnenmyRepeat() % 3 == 0) {
      plainAttack(actMonsterNumber);
    } else {
      atkUp(actMonsterNumber);
    }
  }

  private void gurasugibunenAi(int actMonsterNumber) {
    actEnemy = battle.getCurrentEnemy()[actMonsterNumber];
    if (actEnemy.getEnenmyRepeat() % 4 == 1) {
      fearCardStun(actMonsterNumber);
    } else if (actEnemy.getEnenmyRepeat() % 4 == 2) {
      plainAttack(actMonsterNumber);
    } else if (actEnemy.getEnenmyRepeat() % 4 == 3) {
      readyReflect(actMonsterNumber);
    } else if (actEnemy.getEnenmyRepeat() % 4 == 0) {
      reflectAttack(actMonsterNumber);
    }
  }

  private void quizAi(int actMonsterNumber) {
    actEnemy = battle.getCurrentEnemy()[actMonsterNumber];
    if (actEnemy.getEnenmyRepeat() % 2 == 1) {
      System.out.println(actEnemy.getName() + "가 덱을 뒤흔들었다.");
      randomCard();
    } else {
      plainAttack(actMonsterNumber);
    }
  }

  private void mordecaiFirstForm(int actMonsterNumber) {
    Scanner scan = new Scanner(System.in);
    actEnemy = battle.getCurrentEnemy()[actMonsterNumber];

    if (actEnemy.getHp() == actEnemy.getMinHp()) {
      player.setDrawCardNumber(temp);
      temp = player.getMaxMp();
      EnemyCharacter[] nextForm =
          {new EnemyCharacter("모르데카이 2형태", 250, 0, 150, 0, 50, 100, 0, 10, 7, 90, 1)};
      battle.setCurrentEnemy(nextForm);
    }

    else if (actEnemy.getEnenmyRepeat() == 1) {
      System.out.println("정정당당한 1:1승부를");
      scan.nextLine();
      temp = player.getDrawCardNumber();
      player.setDrawCardNumber(1);
    } else {
      plainAttack(actMonsterNumber);
    }
  }

  private void mordecaiSecondForm(int actMonsterNumber) {
    Scanner scan = new Scanner(System.in);
    if (actEnemy.getHp() == actEnemy.getMinHp()) {
      battle.setTempBattleDeck(
          sortCard.deckPlusDeck(battle.getTempBattleDeck(), battle.getGraveCard()));
      for (int i = 0; i < battle.getTempBattleDeck().length; i++) {
        battle.getTempBattleDeck()[i]
            .setCardConsumeMana(battle.getTempBattleDeck()[i].getCardConsumeMana() - 2);
      }
      EnemyCharacter[] nextForm =
          {new EnemyCharacter("모르데카이 3형태", 550, 0, 300, 0, 80, 200, 0, 10, 7, 90, 0)};
      battle.setCurrentEnemy(nextForm);
    }

    else if (actEnemy.getEnenmyRepeat() == 1) {
      System.out.println("마력의 흐름이 불안정해졌다.");
      scan.nextLine();
      battle.setTempBattleDeck(
          sortCard.deckPlusDeck(battle.getTempBattleDeck(), battle.getGraveCard()));
      for (int i = 0; i < battle.getTempBattleDeck().length; i++) {
        battle.getTempBattleDeck()[i]
            .setCardConsumeMana(battle.getTempBattleDeck()[i].getCardConsumeMana() + 2);
      }
    } else {
      plainAttack(actMonsterNumber);
    }
  }


  public void mordecaiThirdForm(int actMonsterNumber) {
    Scanner scan = new Scanner(System.in);
    if (actEnemy.getEnenmyRepeat() == 1) {
      System.out.println("덱이 잠식당하고있다.");
      scan.nextLine();
    }

    battle.setTempBattleDeck(
        sortCard.deckPlusDeck(battle.getTempBattleDeck(), battle.getGraveCard()));

    if (battle.getTempBattleDeck().length <= 0) {
      this.plainAttack(actMonsterNumber);
    } else {
      battle.setTempBattleDeck(sortCard.sortRemoveCard(battle.getTempBattleDeck(), 1));
      this.plainAttack(actMonsterNumber);
    }

  }

}
