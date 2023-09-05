package makeCardGame230901.cardBundle;

public class TotalCardBase {
	
	String cardName;
	CardType cardType;//공방 타입
	private int cardValue;//카드의 수치
	private int cardConsumeMana;
	private int cardPrice;
	
	public TotalCardBase()
	{
		
	}
	
	public TotalCardBase(
			String cardName,
			CardType cardType,
			int cardValue,
			int cardConsumeMana,
			int cardPrice
			)
	{
		this.cardName=cardName;
		this.cardType=cardType;
		this.cardValue=cardValue;
		this.cardConsumeMana=cardConsumeMana;
		this.cardPrice=cardPrice;
	}
	
	
	TotalCardBase[] cardData= new TotalCardBase[10];	
	public TotalCardBase[] totalCard()//판매하지않는카드나 임시사용카드등 휘발성카드들을 위해서 따로 만들어둔다.
	{
		cardData[0] = new TotalCardBase("공격",CardType.Attack,7,1,10);
		cardData[1] = new TotalCardBase("방어",CardType.Defend,5,1,10);
		cardData[2] = new TotalCardBase("연속공격",CardType.Attack,15,2,50);
		cardData[3] = new TotalCardBase("굳히기",CardType.Defend,15,2,50);
		cardData[4] = new TotalCardBase("참격",CardType.Attack,10,1,100);
		cardData[5] = new TotalCardBase("굳건",CardType.Defend,10,1,100);
		cardData[6] = new TotalCardBase("속공",CardType.Attack,10,0,50);
		cardData[7] = new TotalCardBase("상처찢기",CardType.Attack,30,3,50);
		cardData[8] = new TotalCardBase("불굴",CardType.Defend,10,0,100);
		cardData[9] = new TotalCardBase("빛의수호",CardType.Defend,50,3,100);
		
		return cardData;
	}
	
	TotalCardBase[] shopData= new TotalCardBase[4];
	public TotalCardBase[] shopSellCard()
	{
		
		shopData[0] = totalCard()[0];
		shopData[1] = totalCard()[1];
		shopData[2] = totalCard()[2];
		shopData[3] = totalCard()[3];
		return shopData;
	}
	
	TotalCardBase[] eventCardData = new TotalCardBase[4];
	public TotalCardBase[] eventCard()
	{
		eventCardData[0] = totalCard()[6];
		eventCardData[1] = totalCard()[7];
		eventCardData[2] = totalCard()[8];
		eventCardData[3] = totalCard()[9];
		return eventCardData;
	}
	public void watchCardData(TotalCardBase[] cardSet)
	{
		for(int i = 0; i <cardSet.length;i++)
		{
			System.out.println((i+1)+"."+cardSet[i].getCardName()+" : "+cardSet[i].getCardType()+"타입 수치 : "+cardSet[i].getCardValue()+" 마나 : "+cardSet[i].getCardConsumeMana());
		}
	}
	
	//get모음
	public CardType getCardType()
	{
		return cardType;		
	}
	
	public String getCardName() {
		return cardName;
	}
	
	public int getCardValue()
	{
		return cardValue;
	}
	public int getCardConsumeMana()
	{
		return cardConsumeMana;
	}
	public int getCardPrice()
	{
		return cardPrice;
	}
	

}
