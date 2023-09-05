package makeCardGame230901.village;

import java.util.Scanner;

import makeCardGame230901.cardBundle.TotalCardBase;
import makeCardGame230901.cardBundle.cardSortBundle.SortCard;
import makeCardGame230901.characterBundle.PlayerCharacter;

public class EditDeck //덱 수정하기 추가할때 제거할때
{
	private int choice = 0;
	Scanner scan = new Scanner(System.in);
	SortCard sortCard = new SortCard();
	void edit(PlayerCharacter player)
	{
		while(true) {
		player.DeckOpen();
		System.out.println("1.카드추가");
		System.out.println("2.카드제거");
		System.out.println("3.돌아가기");
		choice=scan.nextInt();
		if(choice==1)
		{
			addCard(player);
		}
		else if(choice==2)
		{
			reduceCard(player);
		}
		else if(choice==3)
		{
			break;
		}
		}
	}
	
	void addCard(PlayerCharacter player)//덱목록과 소지카드목록을 보여주고 넣는다.
	{
		while(true) {
			player.DeckOpen();
			System.out.println();
			player.InventoryOpen();
			System.out.println("몇번 카드를 넣나요? 0.돌아가기");
			//인벤비었을때 잘라줘야하는곳
			choice=scan.nextInt();//카드고르고
			if(choice==0)
			{
				System.out.println("돌아갑니다.");
				break;				
			}
			else if(choice>player.getCardInventory().length)
			{
				System.out.println("인벤토리보다 큽니다.");
				
			}
			else {
				player.setCardDeck(sortCard.sortAddCard(player.getCardDeck(), player.getCardInventory(), choice));//카드를 넣는다.
				//넣었으니 이제 인벤토리에서 카드를 줄이자.				
				player.setCardInventory(sortCard.sortRemoveCard(player.getCardInventory(),choice));			
			}
			
		}
		
	}
	
	void reduceCard(PlayerCharacter player)
	{
		while(true) {
			player.DeckOpen();
			System.out.println("몇번 카드를 빼나요? 0.돌아가기");
			choice=scan.nextInt();//카드고르고
			System.out.println();
			if(choice==0)
			{
				System.out.println("돌아갑니다.");
				break;				
			}
			else if(choice>player.getCardDeck().length)
			{
				System.out.println("덱보다 큽니다.");
				
			}
			else {
				player.setCardInventory(sortCard.sortAddCard(player.getCardInventory(), player.getCardDeck(), choice));
				//카드를 넣는다.
				//넣었으니 이제 덱에서 카드를 줄이자.
				player.setCardDeck(sortCard.sortRemoveCard(player.getCardDeck(), choice));				
			}
			
		}
		
	}
}
