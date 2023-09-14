package makeCardGame230901.characterBundle;

import java.io.Serializable;
import makeCardGame230901.cardBundle.TotalCardBase;

public abstract class CharacterBase implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 307361853506761620L;
  private String name;
  private TotalCardBase[] cardInventory;// 카드인벤토리
  private TotalCardBase[] cardDeck;// 덱, 무기위치
  private TotalCardBase[] hand;
  private int hp;
  private int mp;
  private int maxHp = 9999999;
  private int maxMp;
  private int atk;
  private int def;
  private int money;
  private int speed;// 속도
  private int aiPattern;
  private int enemyRepeat = 0;
  private int turnGaze = 0;
  private int stunTurn = 0;
  private int divineForce = 0;
  private int reflect = 0;
  private int minHp = 0;

  protected CharacterBase() {}


  CharacterBase(String name, TotalCardBase[] cardInventory, TotalCardBase[] cardDeck,
      TotalCardBase[] hand, int maxHp, int maxMp, int hp, int mp, int speed, int money) {// 플레이어블
                                                                                         // 캐릭터
    this.name = name;
    this.cardInventory = cardInventory;
    this.cardDeck = cardDeck;
    this.hand = hand;
    this.maxHp = maxHp;
    this.maxMp = maxMp;
    this.hp = hp;
    this.mp = mp;
    this.speed = speed;
    this.money = money;
  }

  protected CharacterBase(String name, int maxHp, int maxMp, int hp, int mp, int atk, int def,
      int money, int speed, int aiPattern) {// 적 캐릭터
    this.name = name;
    this.maxHp = maxHp;
    this.maxMp = maxMp;
    this.hp = hp;
    this.mp = mp;
    this.atk = atk;
    this.def = def;
    this.money = money;
    this.speed = speed;
    this.aiPattern = aiPattern;
  }



  // set 모음

  public void setMaxHp(int maxHp) {
    this.maxHp = maxHp;
  }

  public void setMaxMp(int maxMp) {
    this.maxMp = maxMp;
  }

  public void setHp(int hp) {
    if (hp > getMaxHp()) {
      hp = getMaxHp();
    }
    if (hp < minHp) {
      hp = minHp;
    }
    if (divineForce == 0) {
      this.hp = hp;
    } else {
      System.out.println("무적상태라 데미지가 들어가지 않는다.");
    }
  }

  public void setMp(int mp) {
    this.mp = mp;
  }

  public void setHand(TotalCardBase[] hand) {
    this.hand = hand;
  }

  public void setCardInventory(TotalCardBase[] cardInventory) {
    this.cardInventory = cardInventory;
  }

  public void setCardInventory(TotalCardBase cardInventory, int slot) {
    this.cardInventory[slot] = cardInventory;
  }

  public void setCardDeck(TotalCardBase[] cardDeck) {
    this.cardDeck = cardDeck;
  }

  public void setMoeny(int money) {
    if (money < 0) {
      money = 0;
    }
    this.money = money;
  }

  public void setDef(int def) {
    this.def = def;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public void setAtk(int atk) {
    this.atk = atk;
  }

  public void setEnemyRepeat(int enemyRepeat) {
    this.enemyRepeat = enemyRepeat;
  }

  public void setTurnGaze(int turnGaze) {
    this.turnGaze = turnGaze;
  }

  public void setStunTurn(int stunTurn) {
    if (stunTurn < 0) {
      stunTurn = 0;
    }
    this.stunTurn = stunTurn;
  }

  public void setDivineForce(int divineForce) {
    if (divineForce < 0) {
      divineForce = 0;
    }
    this.divineForce = divineForce;
  }

  public void setReflect(int reflect) {
    this.reflect = reflect;
  }

  public void setMinHp(int minHp) {
    this.minHp = minHp;
  }


  // get 모음
  public String getName() {
    return name;
  }

  public int getHp() {
    return hp;
  }

  public int getMp() {
    return mp;
  }

  public int getMaxHp() {
    return maxHp;
  }

  public int getMaxMp() {
    return maxMp;
  }

  public int getAtk() {
    return atk;
  }

  public int getDef() {
    return def;
  }

  public int getMinHp() {
    return minHp;
  }

  public TotalCardBase[] getCardInventory() {
    return cardInventory;
  }

  public int getMoney() {
    return money;
  }

  public TotalCardBase[] getCardDeck() {
    return cardDeck;
  }

  public int getSpeed() {
    return speed;
  }

  public TotalCardBase[] getHand() {
    return hand;
  }

  public int getAiPattern() {
    return aiPattern;
  }

  public int getEnenmyRepeat() {
    return enemyRepeat;
  }

  public int getTurnGaze() {
    return turnGaze;
  }

  public int getStunTurn() {
    return stunTurn;
  }

  public int getDivineForce() {
    return divineForce;
  }

  public int getReflect() {
    return reflect;
  }
}
