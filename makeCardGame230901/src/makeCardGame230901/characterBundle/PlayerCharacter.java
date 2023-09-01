package makeCardGame230901.characterBundle;

import makeCardGame230901.cardBundle.TotalCardBase;
import makeCardGame230901.cardBundle.TotalItem;
import makeCardGame230901.cardBundle.CardType;


public class PlayerCharacter extends CharacterBase {
	public PlayerCharacter()
	{
		super(
				"주인공",
				new TotalItem[] {},
				new TotalCardBase[] {
						new TotalCardBase("공격",CardType.Attack,10,1),
						new TotalCardBase("방어",CardType.Defend,5,1)},
				100,
				5,
				100,
				5,
				0);
	}
}
