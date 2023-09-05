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

}
