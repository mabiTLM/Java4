package makeCardGame230901.battleBundle.enemyActBunble;

import makeCardGame230901.battleBundle.Battle;
import makeCardGame230901.characterBundle.PlayerCharacter;
import makeCardGame230901.characterBundle.enemyBundle.EnemyCharacter;

public class EnemyActAi extends EnemyBattleAct {
  EnemyCharacter actEnemy;

  public EnemyActAi(PlayerCharacter player, Battle battle) {
    super(player, battle);
  }

  /**
   * 0.일반슬라임 1.도적 2.골렘 3.보스 4.강화슬라임
   **/
  public void totalAi(int actMonsterNumber) {
    actEnemy = battle.getCurrentEnemy()[actMonsterNumber];
    actEnemy.setEnemyRepeat(actEnemy.getEnenmyRepeat() + 1);
    int ai = actEnemy.getAiPattern();
    if (actEnemy.getHp() <= 0) {
      battle.monsterDie();
    } else if (ai == 0) {
      slimeAi(actMonsterNumber);
    } else if (ai == 1) {
      theifAi(actMonsterNumber);
    } else if (ai == 2) {
      golemAi(actMonsterNumber);
    } else if (ai == 3) {
      bossAi(actMonsterNumber);
    } else if (ai == 4) {
      divideSlimeAi(actMonsterNumber);
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

  private void bossAi(int actMonsterNumber) {
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

}
