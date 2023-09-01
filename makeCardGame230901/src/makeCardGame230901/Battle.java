package makeCardGame230901;

import makeCardGame230901.cardBundle.TotalCardBase;
import makeCardGame230901.characterBundle.PlayerCharacter;

public class Battle 
{
	PlayerCharacter player = new PlayerCharacter();//임시
	TotalCardBase[] tempBattleDeck = player.getCardDeck();//플레이어의 덱을 배틀할때만 복사한다.
	

	void cardShuffle()//셔플과 사용은 배틀에서 하는게 맞는거같다 싸움도중에 임시로 덱이 변동되어도 마을가면 돌아와야하니까
	{
		
	}
	
	void cardDraw()
	{
		
	}
	
	
	
	public void useCard()
	{
		System.out.println(player.getCardDeck()[0].getCardType());
	}
}
