package makeCardGame230901.characterBundle;

import makeCardGame230901.cardBundle.TotalCardBase;
import makeCardGame230901.cardBundle.CardType;


public class PlayerCharacter extends CharacterBase {
	public PlayerCharacter()
	{
		super(
				"주인공",
				new TotalItem[] {},
				new TotalCardBase[] //덱
						{
						new TotalCardBase("공격",CardType.Attack,10,1),
						new TotalCardBase("공격",CardType.Attack,10,1),
						new TotalCardBase("공격",CardType.Attack,10,1),
						new TotalCardBase("공격",CardType.Attack,10,1),
						new TotalCardBase("공격",CardType.Attack,10,1),
						new TotalCardBase("방어",CardType.Defend,5,1),
						new TotalCardBase("방어",CardType.Defend,5,1),
						new TotalCardBase("방어",CardType.Defend,5,1),
						new TotalCardBase("방어",CardType.Defend,5,1),
						new TotalCardBase("방어",CardType.Defend,5,1)
						},
				new TotalCardBase[] {},//손패
				100,
				5,
				100,
				5,
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
}
