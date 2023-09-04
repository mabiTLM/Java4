package makeCardGame230901.cardBundle;

public class TotalCardBase {
	
	String cardName;
	CardType cardType;//공방 타입
	private int cardValue;//카드의 수치
	private int cardConsumeMana;
	
	TotalCardBase()
	{
		
	}
	
	public TotalCardBase(
			String cardName,
			CardType cardType,
			int cardValue,
			int cardConsumeMana
			)
	{
		this.cardName=cardName;
		this.cardType=cardType;
		this.cardValue=cardValue;
		this.cardConsumeMana=cardConsumeMana;
	}
	
	
	TotalCardBase[] cardData= new TotalCardBase[2];
	
	TotalCardBase[] totalCard()
	{
		for(int i = 0; i <cardData.length;i++)
		{
			cardData[i] = new TotalCardBase();//null오류 방지는 가능하지만 그만큼 실행이 많이됩니다.
		}

		cardData[0] = new TotalCardBase("공격",CardType.Attack,10,1);
		cardData[1] = new TotalCardBase("방어",CardType.Defend,5,1);
		return cardData;
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
	

}
