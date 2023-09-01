package makeCardGame230901.cardBundle;

public class TotalCard {
	
	String cardName;
	CardType cardtype;//공방
	int cardValue;
	
	TotalCard(
			String cardName,
			CardType cardtype,
			int cardValue
			)
	{
		this.cardName=cardName;
		this.cardtype=cardtype;
		this.cardValue=cardValue;
	}
}
