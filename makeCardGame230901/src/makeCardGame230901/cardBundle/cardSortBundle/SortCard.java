package makeCardGame230901.cardBundle.cardSortBundle;

import makeCardGame230901.cardBundle.TotalCardBase;

public class SortCard {
	
	/**
	 * 1번덱 끝에 2번덱의 slot-1번째 카드를 추가합니다.
	**/	
	public TotalCardBase[] sortAddCard(TotalCardBase[] playerDeck, TotalCardBase[] addCard, int slot)
	{
		TotalCardBase[]	temp = new TotalCardBase[playerDeck.length+1];
		for(int i = 0; i < playerDeck.length;i++)
		{
			temp[i]=playerDeck[i];
		}
		temp[playerDeck.length]=addCard[slot-1];
		return temp;
	}
	
	/**
	 * 넣은 덱의 slot-1번째카드를 제거합니다.
	**/	
	public TotalCardBase[] sortRemoveCard(TotalCardBase[] playerDeck, int slot)
	{
		TotalCardBase[]	temp = new TotalCardBase[playerDeck.length-1];
		for(int i = 0; i<playerDeck.length;i++)
		{
			if(i<slot-1)
			{
				temp[i]=playerDeck[i];
			}
			else if(i>slot-1)
			{
				temp[i-1]=playerDeck[i];
			}
		}
		return temp;
	}
	
	/**
	 * 넣은 덱을 카드로써보여줍니다.
	**/	
	public void watchCard(TotalCardBase[] playerHand)
	{
		for(int i = 0; i < playerHand.length;i++)//마나
		{
			System.out.print("   "+playerHand[i].getCardConsumeMana());
			System.out.print(" 마나========   ");
		}
		System.out.println();
		
		for(int i = 0; i < playerHand.length;i++)
		{
			if(playerHand[i].getCardName().length()==3)//카드이름
			{
				System.out.print("   |   "+playerHand[i].getCardName()+"    |   ");
			}
			else if(playerHand[i].getCardName().length()==4)
			{
				System.out.print("   |   "+playerHand[i].getCardName()+"  |   ");
			}
			else {
			System.out.print("   |    "+playerHand[i].getCardName()+"    |   ");
			}
		}
		System.out.println();
		
		for(int i = 0; i < playerHand.length;i++)
		{
			System.out.print("   |  "+playerHand[i].getCardType()+"   |   ");			
		}
		System.out.println();
		
		
		for(int i = 0; i < playerHand.length;i++)
		{
			if(playerHand[i].getCardValue()<10)
			{
				System.out.print("   =========== ");
			}
			else
			{
				System.out.print("   ========== ");
			}
			System.out.print(playerHand[i].getCardValue()+"   ");
		}
		System.out.println();
		for(int i = 0; i < playerHand.length;i++)
		{
			System.out.print("        "+(i+1)+"          ");
		}
		System.out.println();
		
	}
	
	/**
	 * 넣은 덱을 셔플해서 내보내줍니다.
	**/
	public TotalCardBase[] suffleDeck(TotalCardBase[] wantShuffleDeck)
	{
		int temp;
		TotalCardBase tempSuffleDeck;
		for(int i = 0; i < wantShuffleDeck.length;i++)
		{
			temp=(int)(Math.random()*wantShuffleDeck.length);
			tempSuffleDeck = wantShuffleDeck[i];
			wantShuffleDeck[i]=wantShuffleDeck[temp];
			wantShuffleDeck[temp] = tempSuffleDeck;
		}
		return wantShuffleDeck;
	}
	
	/**
	 *넣은 두덱을 합쳐줍니다
	 **/	
	public TotalCardBase[] DeckPlusDeck(TotalCardBase[] Deck1,TotalCardBase[] Deck2)
	{
		TotalCardBase[] combineResultDeck= new TotalCardBase[Deck1.length+Deck2.length];
		
		for(int i=0; i <Deck1.length; i++)
		{
			combineResultDeck[i]=Deck1[i];
		}
		for(int i=Deck1.length; i < Deck1.length+Deck2.length;i++)
		{
			combineResultDeck[i]=Deck2[i-Deck1.length];
		}
		
		return combineResultDeck;
	}
}
