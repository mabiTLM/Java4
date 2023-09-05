package makeCardGame230901.cardBundle.cardSortBundle;

import makeCardGame230901.cardBundle.TotalCardBase;

public class SortCard {
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

}
