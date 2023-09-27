package makeCardGame230901.characterBundle.enemyBundle;

import makeCardGame230901.characterBundle.MONSTEREFFECT;

public class SecondFloorEnemy extends EnemyCharacter {
  /**
   * 
   */
  private static final long serialVersionUID = 7523908207150910853L;

  @Override
  public EnemyCharacter[] stageData() {
    stageEnemy = new EnemyCharacter[3];
    stageEnemy[0] = new EnemyCharacter("알송달송", 30, 30, 10, 0, 100, 10, 5, 100);
    stageEnemy[1] = new EnemyCharacter("도적", 30, 30, 10, 0, 100, 20, 1, MONSTEREFFECT.ATTACKUP, 3);
    stageEnemy[2] =
        new EnemyCharacter("작은 골렘", 50, 50, 50, 50, 100, 5, 2, MONSTEREFFECT.SHIELD, 50);
    return stageEnemy;
  }

  @Override
  public EnemyCharacter[] stageEliteData() {
    stageEnemy = new EnemyCharacter[3];
    stageEnemy[0] =
        new EnemyCharacter("골렘", 100, 100, 100, 50, 1000, 8, 2, MONSTEREFFECT.SHIELD, 100);
    stageEnemy[1] =
        new EnemyCharacter("상급 닌자", 50, 50, 10, 0, 1000, 30, 1, MONSTEREFFECT.ATTACKUP, 5);
    stageEnemy[2] =
        new EnemyCharacter("킹 슬라임", 50, 50, 10, 20, 1000, 10, 4, MONSTEREFFECT.USESKILL, 0);
    return stageEnemy;
  }

  @Override
  public EnemyCharacter[] stageBossData() {
    stageEnemy = new EnemyCharacter[1];
    stageEnemy[0] = new EnemyCharacter("모르데카이 1형태", 100, 0, 50, 0, 20, 100, 0, 10, 6, 90, 1);
    return stageEnemy;
  }
}
