package makeCardGame230901.village;

import java.util.Scanner;

import makeCardGame230901.cardBundle.TotalCardBase;
import makeCardGame230901.cardBundle.cardSortBundle.SortCard;
import makeCardGame230901.characterBundle.PlayerCharacter;

public class CardShop 
{	
	TotalCardBase totalCardBase = new TotalCardBase();
	SortCard sortCard= new SortCard();
	Scanner scan = new Scanner(System.in);
	
	public void watchCardData(TotalCardBase[] cardSet)
	{
		for(int i = 0; i <cardSet.length;i++)
		{
			System.out.println((i+1)+"."+cardSet[i].getCardName()+" : "+cardSet[i].getCardType()+"타입카드 수치 : "+cardSet[i].getCardValue()+" 마나 : "+cardSet[i].getCardConsumeMana()+" 가격 : " + cardSet[i].getCardPrice());
		}
	}
	
	void buyItem(PlayerCharacter player)
	{
		while(true) 
		{
			//상점 카드목록을 보여준다
			watchCardData(totalCardBase.shopSellCard());			
			
			System.out.println("어느 카드를 살래? 0.돌아가기 ,00.덱과 인벤확인");
			String choice = scan.nextLine();
			if(choice.equals("0"))
			{
				break;
			}
			else if(choice.equals("00"))
			{
				player.DeckOpen();
				player.InventoryOpen();
				System.out.println();
				System.out.println();
				System.out.println();
			}
			else if(Integer.valueOf(choice)>0)
			{
				player.setCardInventory(sortCard.sortAddCard(player.getCardInventory(), totalCardBase.shopSellCard(), Integer.valueOf(choice)));
			}
		}
	}
}