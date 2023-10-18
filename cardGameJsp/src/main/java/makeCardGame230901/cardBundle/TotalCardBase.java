package makeCardGame230901.cardBundle;

import java.io.Serializable;

public class TotalCardBase implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 762256255537946830L;
  String cardName;
  CARDTYPE cardType;// 공방 타입
  private int cardValue;// 카드의 수치
  private int cardConsumeMana;
  private int cardPrice;
  private String effect = "통상";
  private int effectValue = 0;
  private boolean enforce = false;
  private boolean volatility = false;

  public TotalCardBase() {

  }

  /**
   * 가장 기본적인 카드
   **/
  public TotalCardBase(String cardName, CARDTYPE cardType, int cardValue, int cardConsumeMana,
      int cardPrice) {
    this.cardName = cardName;
    this.cardType = cardType;
    this.cardValue = cardValue;
    this.cardConsumeMana = cardConsumeMana;
    this.cardPrice = cardPrice;
  }

  /**
   * 휘발성 카드
   **/
  public TotalCardBase(String cardName, CARDTYPE cardType, int cardValue, int cardConsumeMana,
      int cardPrice, boolean volatility) {
    this.cardName = cardName;
    this.cardType = cardType;
    this.cardValue = cardValue;
    this.cardConsumeMana = cardConsumeMana;
    this.cardPrice = cardPrice;
    this.volatility = volatility;
  }

  /**
   * 고정 효과 카드
   **/
  public TotalCardBase(String cardName, CARDTYPE cardType, int cardValue, int cardConsumeMana,
      int cardPrice, String effect) {
    this.cardName = cardName;
    this.cardType = cardType;
    this.cardValue = cardValue;
    this.cardConsumeMana = cardConsumeMana;
    this.cardPrice = cardPrice;
    this.effect = effect;
  }

  /**
   * 유동 효과 카드
   **/
  public TotalCardBase(String cardName, CARDTYPE cardType, int cardValue, int cardConsumeMana,
      int cardPrice, String effect, int effectValue) {
    this.cardName = cardName;
    this.cardType = cardType;
    this.cardValue = cardValue;
    this.cardConsumeMana = cardConsumeMana;
    this.cardPrice = cardPrice;
    this.effect = effect;
    this.effectValue = effectValue;
  }

  /**
   * 유동 효과 휘발성 카드
   **/
  public TotalCardBase(String cardName, CARDTYPE cardType, int cardValue, int cardConsumeMana,
      int cardPrice, String effect, int effectValue, boolean volatility) {
    this.cardName = cardName;
    this.cardType = cardType;
    this.cardValue = cardValue;
    this.cardConsumeMana = cardConsumeMana;
    this.cardPrice = cardPrice;
    this.effect = effect;
    this.effectValue = effectValue;
    this.volatility = volatility;
  }


  TotalCardBase[] cardData = new TotalCardBase[22];

  public TotalCardBase[] totalCard()// 판매하지않는카드나 임시사용카드등 휘발성카드들을 위해서 따로 만들어둔다.
  {
    cardData[0] = new TotalCardBase("공격", CARDTYPE.Attack, 7, 1, 10);
    cardData[1] = new TotalCardBase("방어", CARDTYPE.Defend, 10, 1, 10);
    cardData[2] = new TotalCardBase("2연참", CARDTYPE.Attack, 14, 2, 50);
    cardData[3] = new TotalCardBase("굳히기", CARDTYPE.Defend, 20, 2, 50);
    cardData[4] = new TotalCardBase("참격", CARDTYPE.Attack, 12, 1, 100);
    cardData[5] = new TotalCardBase("굳건", CARDTYPE.Defend, 15, 1, 100);
    cardData[6] = new TotalCardBase("속공", CARDTYPE.Attack, 10, 1, 10000, "드로우", 1);
    cardData[7] = new TotalCardBase("상처찢기", CARDTYPE.Attack, 40, 2, 5000, "마무리", 1);
    cardData[8] = new TotalCardBase("불굴", CARDTYPE.Defend, 15, 0, 5000);
    cardData[9] = new TotalCardBase("빛의수호", CARDTYPE.Defend, 80, 3, 10000);
    cardData[10] = new TotalCardBase("실드차지", CARDTYPE.Attack, 0, 1, 20000, "실드차지", 0);
    cardData[11] = new TotalCardBase("힐링", CARDTYPE._HEAL_, 10, 1, 10);
    cardData[12] = new TotalCardBase("신속", CARDTYPE.Attack, 20, 2, 10000, "드로우", 3);
    cardData[13] = new TotalCardBase("스매시", CARDTYPE.Attack, 20, 2, 20000, "방패깨기");
    cardData[14] = new TotalCardBase("재정비", CARDTYPE.Defend, 10, 1, 20000, "드로우", 1);
    cardData[15] = new TotalCardBase("환영베기", CARDTYPE.Attack, 25, 0, 10000, "드로우", 1, true);
    cardData[16] = new TotalCardBase("형상변화", CARDTYPE.Attack, 50, 5, 20000, "형상변화", 0, true);
    cardData[17] = new TotalCardBase("형상변화", CARDTYPE.Defend, 100, 3, 20000, "형상변화", 0, true);
    cardData[18] = new TotalCardBase("백화요란", CARDTYPE._HEAL_, 15, 3, 10000, "꽃잎", 5);
    cardData[19] = new TotalCardBase("꽃봉오리", CARDTYPE._HEAL_, 10, 2, 10000, "꽃잎", 2);
    cardData[20] = new TotalCardBase("씨앗", CARDTYPE._HEAL_, 5, 1, 10000, "꽃잎", 1);
    cardData[21] = new TotalCardBase("만개", CARDTYPE.Attack, 0, 0, 20000, "만개");
    return cardData;
  }

  TotalCardBase[] shopData = new TotalCardBase[20];

  public TotalCardBase[] shopSellCard() {
    shopData[0] = totalCard()[0];
    shopData[1] = totalCard()[1];
    shopData[2] = totalCard()[2];
    shopData[3] = totalCard()[3];
    shopData[4] = totalCard()[4];
    shopData[5] = totalCard()[5];
    shopData[6] = totalCard()[6];
    shopData[7] = totalCard()[7];
    shopData[8] = totalCard()[8];
    shopData[9] = totalCard()[9];
    shopData[10] = totalCard()[10];
    shopData[11] = totalCard()[11];
    shopData[12] = totalCard()[12];
    shopData[13] = totalCard()[13];
    shopData[14] = totalCard()[14];
    shopData[15] = totalCard()[15];
    shopData[16] = totalCard()[18];
    shopData[17] = totalCard()[19];
    shopData[18] = totalCard()[20];
    shopData[19] = totalCard()[21];
    return shopData;
  }

  TotalCardBase[] winMosterCardData = new TotalCardBase[13];

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
    winMosterCardData[9] = totalCard()[18];
    winMosterCardData[10] = totalCard()[19];
    winMosterCardData[11] = totalCard()[20];
    winMosterCardData[12] = totalCard()[21];
    return winMosterCardData;
  }

  TotalCardBase[] winFirstBossData = new TotalCardBase[2];

  public TotalCardBase[] winFirstBossCard() // 첫번째보스처치 전용카드
  {
    winFirstBossData[0] = totalCard()[16];
    winFirstBossData[1] = totalCard()[17];

    return winFirstBossData;
  }

  TotalCardBase[] dungeonShopCardData = new TotalCardBase[9];

  public TotalCardBase[] dungeonShopCard()// 특수효과 카드들
  {
    dungeonShopCardData[0] = totalCard()[12];
    dungeonShopCardData[1] = totalCard()[13];
    dungeonShopCardData[2] = totalCard()[14];
    dungeonShopCardData[3] = totalCard()[10];
    dungeonShopCardData[4] = totalCard()[15];
    dungeonShopCardData[5] = totalCard()[19];
    dungeonShopCardData[6] = totalCard()[20];
    dungeonShopCardData[7] = totalCard()[21];
    dungeonShopCardData[8] = totalCard()[18];

    for (int i = 0; i < dungeonShopCardData.length; i++) {
      dungeonShopCardData[i].setCardPrice(dungeonShopCardData[i].getCardPrice() / 10);
    }
    return dungeonShopCardData;
  }

  // /**
  // * 가격을 표시하지 않는 카드 상세 서버표기용 리턴준거
  // **/
  // public String watchCardData(TotalCardBase[] cardSet) {
  // String result = "";
  // for (int i = 0; i < cardSet.length; i++) {

  // result += (i + 1) + ". " + cardSet[i].getCardName() + " : " + cardSet[i].getCardValue();

  // if (cardSet[i].getCardType() == CARDTYPE.Attack) {
  // result += "공격력";
  // }

  // else if (cardSet[i].getCardType() == CARDTYPE.Defend) {
  // result += "방어도";
  // }

  // else if (cardSet[i].getCardType() == CARDTYPE._HEAL_) {
  // result += "회복";
  // }


  // result += " /소비마나 : " + cardSet[i].getCardConsumeMana();

  // if (!cardSet[i].getEffect().equals("통상")) {

  // if (cardSet[i].getEffectValue() == 0) {
  // result += " /효과 : " + cardSet[i].getEffect();
  // } else {
  // result += " /효과 : " + cardSet[i].getEffectValue() + cardSet[i].getEffect();
  // }
  // }
  // if (cardSet[i].getVolatility()) {
  // result += " 휘발성";
  // }
  // result += " /강화 : " + cardSet[i].isEnforce() + "\n";
  // }
  // return result;

  // }

  /**
   * 가격을 표시하지 않는 카드 상세
   **/
  public void watchCardData(TotalCardBase[] cardSet) {
    for (int i = 0; i < cardSet.length; i++) {

      System.out
          .print((i + 1) + ". " + cardSet[i].getCardName() + " : " + cardSet[i].getCardValue());

      if (cardSet[i].getCardType() == CARDTYPE.Attack) {
        System.out.print("공격력");
      }

      else if (cardSet[i].getCardType() == CARDTYPE.Defend) {
        System.out.print("방어도");
      }

      else if (cardSet[i].getCardType() == CARDTYPE._HEAL_) {
        System.out.print("회복");
      }


      System.out.print(" /소비마나 : " + cardSet[i].getCardConsumeMana());

      if (!cardSet[i].getEffect().equals("통상")) {

        if (cardSet[i].getEffectValue() == 0) {
          System.out.print(" /효과 : " + cardSet[i].getEffect());
        } else {
          System.out.print(" /효과 : " + cardSet[i].getEffectValue() + cardSet[i].getEffect());
        }
      }
      if (cardSet[i].getVolatility()) {
        System.out.print(" 휘발성");
      }
      System.out.print(" /강화 : " + cardSet[i].isEnforce() + "\n");
    }

  }



  private String isEnforce() {
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

  public void setCardType(CARDTYPE cardType) {
    this.cardType = cardType;
  }

  private void setCardPrice(int cardPrice) {
    this.cardPrice = cardPrice;
  }

  // get모음
  public CARDTYPE getCardType() {
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

  public boolean getVolatility() {
    return volatility;
  }


}
