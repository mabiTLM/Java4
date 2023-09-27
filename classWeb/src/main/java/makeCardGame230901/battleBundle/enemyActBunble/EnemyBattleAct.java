package makeCardGame230901.battleBundle.enemyActBunble;

import java.io.Serializable;
import makeCardGame230901.battleBundle.Battle;
import makeCardGame230901.cardBundle.CARDTYPE;
import makeCardGame230901.cardBundle.TotalCardBase;
import makeCardGame230901.cardBundle.cardSortBundle.SortCard;
import makeCardGame230901.characterBundle.PlayerCharacter;
import makeCardGame230901.characterBundle.enemyBundle.EnemyCharacter;

public class EnemyBattleAct implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 469177645896702798L;
  PlayerCharacter player;
  private EnemyCharacter actEnemy;
  protected Battle battle;
  private SortCard sortCard = new SortCard();

  public EnemyBattleAct(PlayerCharacter player, Battle battle) {
    this.player = player;
    this.battle = battle;
  }

  protected void plainAttack(int actMonsterNumber) {
    int tempDamage = 0;
    actEnemy = battle.getCurrentEnemy()[actMonsterNumber];
    player.setDef(player.getDef() - actEnemy.getAtk()); // 공격만큼 실드제거

    if (player.getDef() < 0)// 실드가 음수로가면
    {
      tempDamage = (int) Math.abs(player.getDef());// 음수간만큼 데미지 올리기
      player.setDef(0);// 0으로바꾸기
    }
    player.setHp(player.getHp() - tempDamage);
    System.out.println(actEnemy.getName() + "의 공격 : " + actEnemy.getAtk());
  }

  protected void defUp(int actMonsterNumber) {
    actEnemy = battle.getCurrentEnemy()[actMonsterNumber];
    actEnemy.setDef(actEnemy.getDef() + actEnemy.getEffectValue());
    System.out.println(actEnemy.getName() + "가 실드를 충전했다.");
  }

  protected void speedUp(int actMonsterNumber) {
    actEnemy = battle.getCurrentEnemy()[actMonsterNumber];
  }

  protected void atkUp(int actMonsterNumber) {
    actEnemy = battle.getCurrentEnemy()[actMonsterNumber];
    actEnemy.setAtk(actEnemy.getAtk() + actEnemy.getEffectValue());
    System.out.println(actEnemy.getName() + "의 공격력이 올랐다.");
  }

  protected void healing(int actMonsterNumber) {
    actEnemy = battle.getCurrentEnemy()[actMonsterNumber];
    for (int i = 0; i < battle.getCurrentEnemy().length; i++) {
      battle.getCurrentEnemy()[i]
          .setHp(battle.getCurrentEnemy()[i].getHp() + actEnemy.getEffectValue());
    }
    System.out.println(actEnemy.getName() + "가 힐을 사용했다.");
  }

  protected void badSlimeCardAdd(int actMonsterNumber) {
    actEnemy = battle.getCurrentEnemy()[actMonsterNumber];
    TotalCardBase[] bad = {new TotalCardBase("점액", CARDTYPE.Defend, 0, 0, 0)};
    battle.setTempBattleDeck(sortCard.sortAddCard(battle.getTempBattleDeck(), bad, 1));
    System.out.println(actEnemy.getName() + "가 덱에 불순물을 집어넣었다.");
  }

  protected void fearCardStun(int actMonsterNumber) {
    actEnemy = battle.getCurrentEnemy()[actMonsterNumber];
    TotalCardBase[] bad = {new TotalCardBase("공포", CARDTYPE.Defend, 0, 1, 0, true)};
    battle.setTempBattleDeck(sortCard.sortAddCard(battle.getTempBattleDeck(), bad, 1));
    battle.setTempBattleDeck(sortCard.sortAddCard(battle.getTempBattleDeck(), bad, 1));
    System.out.println(actEnemy.getName() + "의 위협하는 포효");
    player.setStunTurn(player.getStunTurn() + 1);
    player.setDef(0);
  }

  protected void readyReflect(int actMonsterNumber) {
    System.out.println("적이 반격을 준비하고있다.");
    actEnemy.setReflect(actEnemy.getHp());
  }

  protected void reflectAttack(int actMonsterNumber) {
    System.out.println("적의 반격");
    player.setHp(player.getHp() - (actEnemy.getReflect() - actEnemy.getHp()));
  }

  protected void summonMonster(EnemyCharacter summon) {
    EnemyCharacter[] nowEnemy = battle.getCurrentEnemy();
    EnemyCharacter[] tempCurrentEnemy = new EnemyCharacter[nowEnemy.length + 1];

    for (int i = 0; i < nowEnemy.length; i++) {
      tempCurrentEnemy[i] = nowEnemy[i];
    }
    tempCurrentEnemy[nowEnemy.length] = summon;

    battle.setCurrentEnemy(tempCurrentEnemy);
    System.out.println(summon.getName() + "을 소환했다.");
  }

  protected void randomCard() {// 덱을 무작위 카드로 바꿔버린다.
    TotalCardBase tempRandomCard = new TotalCardBase();
    TotalCardBase[] tempRandomDeck = new TotalCardBase[8];
    for (int i = 0; i < 8; i++) {
      int temp = (int) (Math.random() * 9);
      tempRandomDeck[i] = tempRandomCard.totalCard()[temp];
    }

    battle.setTempBattleDeck(tempRandomDeck);
  }
}
