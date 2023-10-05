package servletTest;

public class CardVO {
  // db에서 enum타입이나 boolean이이 변환되므로 새로만들어주자

  private int id;
  private String cardName;
  private String cardType;
  private int cardValue;
  private int cardConsumeMana;
  private int cardPrice;
  private String effect;
  private int effectValue;
  private String enforce;
  private String volatility;


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
}
