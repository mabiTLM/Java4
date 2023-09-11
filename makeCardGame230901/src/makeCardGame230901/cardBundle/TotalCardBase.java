package makeCardGame230901.cardBundle;

import java.io.Serializable;

public class TotalCardBase implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 762256255537946830L;
  String cardName;
  CardType cardType;// 공방 타입
  private int cardValue;// 카드의 수치
  private int cardConsumeMana;
  private int cardPrice;
  private String effect = "통상";
  private int effectValue = 0;
  private boolean enforce = false;

  public TotalCardBase() {

  }

  public TotalCardBase(String cardName, CardType cardType, int cardValue, int cardConsumeMana,
      int cardPrice) {
    this.cardName = cardName;
    this.cardType = cardType;
    this.cardValue = cardValue;
    this.cardConsumeMana = cardConsumeMana;
    this.cardPrice = cardPrice;
  }

  public TotalCardBase(String cardName, CardType cardType, int cardValue, int cardConsumeMana,
      int cardPrice, String effect, int effectValue) {
    this.cardName = cardName;
    this.cardType = cardType;
    this.cardValue = cardValue;
    this.cardConsumeMana = cardConsumeMana;
    this.cardPrice = cardPrice;
    this.effect = effect;
    this.effectValue = effectValue;
  }


  TotalCardBase[] cardData = new TotalCardBase[16];

  public TotalCardBase[] totalCard()// 판매하지않는카드나 임시사용카드등 휘발성카드들을 위해서 따로 만들어둔다.
  {
    cardData[0] = new TotalCardBase("공격", CardType.Attack, 7, 1, 10);
    cardData[1] = new TotalCardBase("방어", CardType.Defend, 10, 1, 10);
    cardData[2] = new TotalCardBase("2연참", CardType.Attack, 14, 2, 50);
    cardData[3] = new TotalCardBase("굳히기", CardType.Defend, 20, 2, 50);
    cardData[4] = new TotalCardBase("참격", CardType.Attack, 10, 1, 100);
    cardData[5] = new TotalCardBase("굳건", CardType.Defend, 15, 1, 100);
    cardData[6] = new TotalCardBase("속공", CardType.Attack, 10, 0, 100);
    cardData[7] = new TotalCardBase("상처찢기", CardType.Attack, 30, 2, 100);
    cardData[8] = new TotalCardBase("불굴", CardType.Defend, 15, 0, 100);
    cardData[9] = new TotalCardBase("빛의수호", CardType.Defend, 80, 3, 100);
    cardData[10] = new TotalCardBase("실드차지", CardType.Attack, 0, 1, 200, "실드차지", 1);
    cardData[11] = new TotalCardBase("힐링", CardType._HEAL_, 10, 1, 10);
    cardData[12] = new TotalCardBase("신속", CardType.Attack, 10, 1, 200, "드로우", 1);
    cardData[13] = new TotalCardBase("스매시", CardType.Attack, 20, 2, 200, "방패깨기", 0);
    cardData[14] = new TotalCardBase("재정비", CardType.Defend, 10, 0, 200, "드로우", 1);
    cardData[15] = new TotalCardBase("환영베기", CardType.Attack, 25, 0, 200, "휘발성", 0);
    return cardData;
  }

  TotalCardBase[] shopData = new TotalCardBase[7];

  public TotalCardBase[] shopSellCard() {
    shopData[0] = totalCard()[0];
    shopData[1] = totalCard()[1];
    shopData[2] = totalCard()[2];
    shopData[3] = totalCard()[3];
    shopData[4] = totalCard()[4];
    shopData[5] = totalCard()[5];
    shopData[6] = totalCard()[11];
    return shopData;
  }

  TotalCardBase[] winMosterCardData = new TotalCardBase[9];

  public TotalCardBase[] winMosterCard() // 고배율 카드들 넣자
  {
    winMosterCardData[0] = totalCard()[6];
    winMosterCardData[1] = totalCard()[7];
    winMosterCardData[2] = totalCard()[8];
    winMosterCardData[3] = totalCard()[9];
    winMosterCardData[4] = totalCard()[10];
    winMosterCardData[5] = totalCard()[12];
    winMosterCardData[6] = totalCard()[13];
    winMosterCardData[7] = totalCard()[14];
    winMosterCardData[8] = totalCard()[15];
    return winMosterCardData;
  }

  TotalCardBase[] dungeonShopCardData = new TotalCardBase[5];

  public TotalCardBase[] dungeonShopCard()// 특수효과 카드들
  {
    dungeonShopCardData[0] = totalCard()[12];
    dungeonShopCardData[1] = totalCard()[13];
    dungeonShopCardData[2] = totalCard()[14];
    dungeonShopCardData[3] = totalCard()[10];
    dungeonShopCardData[4] = totalCard()[15];
    return dungeonShopCardData;
  }


  public void watchCardData(TotalCardBase[] cardSet) {
    for (int i = 0; i < cardSet.length; i++) {
      System.out.println(
          (i + 1) + "." + cardSet[i].getCardName() + " : " + cardSet[i].getCardType() + "타입"
              + " /수치 : " + cardSet[i].getCardValue() + " /마나 : " + cardSet[i].getCardConsumeMana()
              + " /종류 : " + cardSet[i].getEffect() + " /강화 : " + cardSet[i].isEnforce());
    }
  }

  public String isEnforce() {
    if (enforce) {
      return "강화됨";
    } else {
      return "강화가능";
    }
  }


  public void setEnforce(boolean enforce) {
    this.enforce = enforce;
  }

  public void setCardValue(int cardValue) {
    this.cardValue = cardValue;
  }

  public void setCardConsumeMana(int cardConsumeMana) {
    this.cardConsumeMana = cardConsumeMana;
  }

  // get모음
  public CardType getCardType() {
    return cardType;
  }

  public String getCardName() {
    return cardName;
  }

  public int getCardValue() {
    return cardValue;
  }

  public int getCardConsumeMana() {
    return cardConsumeMana;
  }

  public int getCardPrice() {
    return cardPrice;
  }

  public String getEffect() {
    return effect;
  }

  public boolean getEnforce() {
    return enforce;
  }

  public int getEffectValue() {
    return effectValue;
  }


}
