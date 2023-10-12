package makeCardGame230901.characterBundle.enemyBundle;

import makeCardGame230901.characterBundle.CharacterBase;
import makeCardGame230901.characterBundle.MONSTEREFFECT;

public class EnemyCharacter extends CharacterBase {
  private static final long serialVersionUID = -7446461043874643802L;
  private boolean enemyTurn = false;
  private int effectValue = 0;

  MONSTEREFFECT monstereffect;

  EnemyCharacter[] stageEnemy;

  public EnemyCharacter() {}

  public EnemyCharacter(// mp가 없는 적
      String name, int maxHp, int hp, int atk, int def, int money, int speed, int aiPattern) {
    super(name, maxHp, 0, hp, 0, atk, def, money, speed, aiPattern);
  }

  EnemyCharacter(// mp가 없고 초기 턴게이지가 높은적
      String name, int maxHp, int hp, int atk, int def, int money, int speed, int aiPattern,
      int turnGaze) {
    super(name, maxHp, 0, hp, 0, atk, def, money, speed, aiPattern);
    this.setTurnGaze(turnGaze);
  }

  public EnemyCharacter(// mp가 있고 초기게이지가 높고 minHp가있는적
      String name, int maxHp, int maxMp, int hp, int mp, int atk, int def, int money, int speed,
      int aiPattern, int turnGaze, int minHp) {
    super(name, maxHp, maxMp, hp, mp, atk, def, money, speed, aiPattern);
    setTurnGaze(turnGaze);
    setMinHp(minHp);
  }


  EnemyCharacter(// mp가 있는 적
      String name, int maxHp, int maxMp, int hp, int mp, int atk, int def, int money, int speed,
      int aiPattern) {
    super(name, maxHp, maxMp, hp, mp, atk, def, money, speed, aiPattern);
  }

  EnemyCharacter(// 부가효과가 있는 타입
      String name, int maxHp, int hp, int atk, int def, int money, int speed, int aiPattern,
      MONSTEREFFECT monstereffect, int effectValue) {
    super(name, maxHp, 0, hp, 0, atk, def, money, speed, aiPattern);
    this.effectValue = effectValue;
  }

  public EnemyCharacter[] stageData() {
    return stageEnemy;
  }

  public EnemyCharacter[] stageEliteData() {
    return stageEnemy;
  }

  public EnemyCharacter[] stageBossData() {
    return stageEnemy;
  }


  public void status() {
    System.out.println(
        "체력 : " + getHp() + " 쉴드 : " + getDef() + " 공격력 : " + getAtk() + " 속도 : " + getSpeed());
  }

  public void setEnemyTurn(boolean enemyTurn) {
    this.enemyTurn = enemyTurn;
  }

  public boolean getEnemyTurn() {
    return enemyTurn;
  }

  public int getEffectValue() {
    return effectValue;
  }
}
