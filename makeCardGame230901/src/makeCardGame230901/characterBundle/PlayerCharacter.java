package makeCardGame230901.characterBundle;

import makeCardGame230901.cardBundle.TotalCardBase;
import makeCardGame230901.cardBundle.CardType;


public class PlayerCharacter extends CharacterBase {
	
	public PlayerCharacter()
	{
		super(
				"주인공",
				new TotalCardBase[] 
						{
								new TotalCardBase("공격",CardType.Attack,10,1),
								new TotalCardBase("공격",CardType.Attack,5,1),
								new TotalCardBase("공격",CardType.Attack,5,1),
								new TotalCardBase("연속공격",CardType.Attack,13,2),
								new TotalCardBase("굳히기",CardType.Defend,15,2),
								new TotalCardBase("방어",CardType.Defend,5,1),
								new TotalCardBase("방어",CardType.Defend,5,1),
								new TotalCardBase("방어",CardType.Defend,5,1),
						},
				new TotalCardBase[] //덱
						{
						new TotalCardBase("연속공격",CardType.Attack,13,2),
						new TotalCardBase("연속공격",CardType.Attack,13,2),
						new TotalCardBase("공격",CardType.Attack,5,1),
						new TotalCardBase("공격",CardType.Attack,5,1),
						new TotalCardBase("굳히기",CardType.Defend,15,2),
						new TotalCardBase("방어",CardType.Defend,5,1),
						new TotalCardBase("방어",CardType.Defend,5,1),
						new TotalCardBase("방어",CardType.Defend,5,1),
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
		System.out.println("내 체력:"+getHp()+" 쉴드:" + getDef() + " 마나 : " + getMp());
	}
	
	public void DeckOpen()
	{
		System.out.print("현재 내 덱 : ");
		for(int i = 0; i <getCardDeck().length;i++)
		{
			System.out.print((i+1)+getCardDeck()[i].getCardName()+"  ");
		}
		System.out.println();
	}
	
}
