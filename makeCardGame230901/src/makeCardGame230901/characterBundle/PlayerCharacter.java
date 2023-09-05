package makeCardGame230901.characterBundle;

import makeCardGame230901.cardBundle.TotalCardBase;
import makeCardGame230901.cardBundle.CardType;


public class PlayerCharacter extends CharacterBase {
	
	static TotalCardBase cardData = new TotalCardBase();
	
	public PlayerCharacter()
	{
		super(
				"주인공",
				new TotalCardBase[] 
						{
								cardData.totalCard()[0],
								cardData.totalCard()[0],
								cardData.totalCard()[0],
								cardData.totalCard()[2],
								cardData.totalCard()[3],
								cardData.totalCard()[1],
								cardData.totalCard()[1],
								cardData.totalCard()[1],
						},
				new TotalCardBase[] //덱
						{
							cardData.totalCard()[2],
							cardData.totalCard()[2],
							cardData.totalCard()[0],
							cardData.totalCard()[0],
							cardData.totalCard()[3],
							cardData.totalCard()[1],
							cardData.totalCard()[1],
							cardData.totalCard()[1],
						},
				new TotalCardBase[] {},//손패
				10000,
				500,
				10000,
				500,
				10,
				0);
	}
	
	public void drawToPlayerHand(TotalCardBase drawCard) {
		TotalCardBase[] tempHand = new TotalCardBase[getHand().length+1];
		for(int i =0; i< getHand().length; i++)
		{
			tempHand[i]= getHand()[i];
		}
		tempHand[getHand().length]=drawCard;
		setHand(tempHand);
	}
	
	public void status() {
		System.out.println("내 체력:"+getHp()+" 쉴드:" + getDef() + " 마나 : " + getMp());
	}
	
	public void DeckOpen()
	{
		System.out.println("현재 내 덱 : ");
		
		cardData.watchCardData(getCardDeck());
		
	}
	
	public void InventoryOpen()
	{
		System.out.println("내 카드 인벤토리 : ");
		cardData.watchCardData(getCardInventory());
	}
	
	public void disCardHand()
	{
		TotalCardBase[] discard = new TotalCardBase[0];
		this.setHand(discard);
	}
	
}
