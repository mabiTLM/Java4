package makeCardGame230901.battleBundle.enemyActBunble;

import java.io.Serializable;
import makeCardGame230901.battleBundle.Battle;
import makeCardGame230901.characterBundle.PlayerCharacter;
import makeCardGame230901.characterBundle.enemyBundle.EnemyCharacter;

public class EnemyActAi extends EnemyBattleAct implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 2409473060879313486L;
  EnemyCharacter actEnemy;

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
      secondBossFirstForm(actMonsterNumber);
    } else if (ai == 7) {
      secondBossSecondForm(actMonsterNumber);
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

  private void secondBossFirstForm(int actMonsterNumber) {
    actEnemy = battle.getCurrentEnemy()[actMonsterNumber];

    if (actEnemy.getHp() == actEnemy.getMinHp()) {
      player.setDrawCardNumber(temp);
      EnemyCharacter[] nextForm =
          {new EnemyCharacter("모르데카이 2형태", 100, 0, 100, 0, 20, 100, 0, 10, 7, 90, 0)};
      battle.setCurrentEnemy(nextForm);
    }

    if (actEnemy.getEnenmyRepeat() == 1) {
      System.out.println("정정당당한 1:1승부를");
      temp = player.getDrawCardNumber();
      player.setDrawCardNumber(1);
    } else {
      plainAttack(actMonsterNumber);
    }
  }

  private void secondBossSecondForm(int actMonsterNumber) {
    if (actEnemy.getEnenmyRepeat() == 1) {
      System.out.println("쉽게 얻는 힘은 쉽게 잃는법");

    }
  }

}
