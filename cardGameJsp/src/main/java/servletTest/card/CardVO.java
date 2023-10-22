package servletTest.card;

public class CardVO {
  // db에서 enum타입이나 boolean이이 변환되므로 새로만들어주자

  private int id = 0;
  private String cardName;
  private String cardType;
  private int cardValue;
  private int cardConsumeMana;
  private int cardPrice;
  private String effect;
  private int effectValue;
  private String enforce;
  private String volatility;
  private String isInDeck;


  public CardVO(int id, String cardName, String cardType, int cardValue, int cardConsumeMana,
      int cardPrice, String effect, int effectValue, String enforce, String volatility) {
    this.id = id;
    this.cardName = cardName;
    this.cardType = cardType;// 공방 타입
    this.cardValue = cardValue;// 카드의 수치
    this.cardConsumeMana = cardConsumeMana;
    this.cardPrice = cardPrice;
    this.effect = effect;
    this.effectValue = effectValue;
    this.enforce = enforce;
    this.volatility = volatility;
  }

  public CardVO(int id, String cardName, String cardType, int cardValue, int cardConsumeMana,
      int cardPrice, String effect, int effectValue, String enforce, String volatility,
      String isInDeck) {
    this.id = id;
    this.cardName = cardName;
    this.cardType = cardType;// 공방 타입
    this.cardValue = cardValue;// 카드의 수치
    this.cardConsumeMana = cardConsumeMana;
    this.cardPrice = cardPrice;
    this.effect = effect;
    this.effectValue = effectValue;
    this.enforce = enforce;
    this.volatility = volatility;
    this.isInDeck = isInDeck;
  }


  public CardVO(String cardName, String cardType, int cardValue, int cardConsumeMana, int cardPrice,
      String effect, int effectValue, String enforce, String volatility) {
    this.cardName = cardName;
    this.cardType = cardType;// 공방 타입
    this.cardValue = cardValue;// 카드의 수치
    this.cardConsumeMana = cardConsumeMana;
    this.cardPrice = cardPrice;
    this.effect = effect;
    this.effectValue = effectValue;
    this.enforce = enforce;
    this.volatility = volatility;
  }

  public int getId() {
    return id;
  }

  public String getCardName() {
    return cardName;
  }

  public String getCardType() {
    return cardType;
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

  public int getEffectValue() {
    return effectValue;
  }

  public String getEnforce() {
    return enforce;
  }

  public String getVolatility() {
    return volatility;
  }


  public String getIsInDeck() {
    return isInDeck;
  }



  public String cardExplain() {
    String temp = "";
    temp += getCardValue();
    if (getCardType().equals("Attack")) {
      temp += "공격력";
    }

    else if (getCardType().equals("Defend")) {
      temp += "방어도";
    }

    else if (getCardType().equals("_Heal_")) {
      temp += "회복";
    }


    if (!getEffect().equals("통상")) {

      if (getEffectValue() == 0) {
        temp += " /효과 : " + getEffect();
      } else {
        temp += " /효과 : " + getEffectValue() + getEffect();
      }
    }
    if (getVolatility().equals("true")) {
      temp += " 휘발성";
    }

    return temp;

  }
}
