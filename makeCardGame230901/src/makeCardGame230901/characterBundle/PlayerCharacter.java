package makeCardGame230901.characterBundle;

import makeCardGame230901.cardBundle.CardType;
import makeCardGame230901.cardBundle.TotalCardBase;


public class PlayerCharacter extends CharacterBase {
	private	int drawCardNumber=5;
	private boolean bossWin = false;
	TotalCardBase cardData= new TotalCardBase();
	
	
	public PlayerCharacter()
	{
		
		super(
				"주인공",
				new TotalCardBase[] //인벤
						{
							new TotalCardBase("공격",CardType.Attack,7,1,10),
							new TotalCardBase("공격",CardType.Attack,7,1,10),
							new TotalCardBase("공격",CardType.Attack,7,1,10),
							new TotalCardBase("연속공격",CardType.Attack,15,2,50),
							new TotalCardBase("굳히기",CardType.Defend,20,2,50),
							new TotalCardBase("방어",CardType.Defend,10,1,10),
							new TotalCardBase("방어",CardType.Defend,10,1,10),
							new TotalCardBase("방어",CardType.Defend,10,1,10),
						},
				new TotalCardBase[] //덱
						{
							new TotalCardBase("연속공격",CardType.Attack,15,2,50),
							new TotalCardBase("연속공격",CardType.Attack,15,2,50),
							new TotalCardBase("공격",CardType.Attack,7,1,10),
							new TotalCardBase("공격",CardType.Attack,7,1,10),
							new TotalCardBase("굳히기",CardType.Defend,20,2,50),
							new TotalCardBase("방어",CardType.Defend,10,1,10),
							new TotalCardBase("방어",CardType.Defend,10,1,10),
							new TotalCardBase("방어",CardType.Defend,10,1,10),
						},
				new TotalCardBase[] {},//손패
				150,
				5,
				150,
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
	public void setBossWin(boolean bossWin)
	{
		this.bossWin=bossWin;
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
	public boolean getBossWin()
	{
		return bossWin;
	}
}
