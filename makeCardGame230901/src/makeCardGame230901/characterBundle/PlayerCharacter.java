package makeCardGame230901.characterBundle;

import makeCardGame230901.cardBundle.TotalCardBase;


public class PlayerCharacter extends CharacterBase {
	private	int drawCardNumber=5;
	private int nowFloor = 1;
	static TotalCardBase cardData= new TotalCardBase();
	
	
	public PlayerCharacter()
	{
		
		super(
				"주인공",
				new TotalCardBase[] //인벤
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
				100,
				5,
				100,
				5,
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
		System.out.println("내 체력:"+getHp()+" 쉴드:" + getDef() + " 마나 : " + getMp() + " 속도 : " + getSpeed());
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
	
	//set모음
	public void setNowFloor(int nowFloor)
	{
		this.nowFloor=nowFloor;
	}
	
	public void setDrawCardNumber(int drawCardNumber)
	{
		this.drawCardNumber=drawCardNumber;
	}
	
	//get 모음
	public int getDrawCardNumber()
	{
		return drawCardNumber;
	}
	public int getNowFloor()
	{
		return nowFloor;
	}
}