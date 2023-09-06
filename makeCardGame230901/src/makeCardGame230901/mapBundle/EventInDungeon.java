package makeCardGame230901.mapBundle;

import java.util.Random;
import java.util.Scanner;

import makeCardGame230901.cardBundle.TotalCardBase;
import makeCardGame230901.cardBundle.cardSortBundle.SortCard;
import makeCardGame230901.characterBundle.PlayerCharacter;

public class EventInDungeon
{
	private PlayerCharacter player;
	private TotalCardBase eventCard = new TotalCardBase();
	private SortCard sortCard = new SortCard();
	Scanner scan = new Scanner(System.in);
	
	Random random = new Random();
	String[] story = {
			"랜덤카드 파워강화",
			"이벤트 카드를 얻습니다."	,
			"선택 : 현재와 미래",
			"재빠른 선택"
	};
	
	public EventInDungeon(PlayerCharacter player)
	{
		this.player=player;
	}
	
	public void event()
	{
		int temp = random.nextInt(story.length);
		System.out.println(story[temp]);
		switch(temp)
		{
		case 0:
			cardEnhancedEvent();
			break;
		case 1:
			cardAddEvent();
			break;
		case 2:
			getMoneyOrHealth();
			break;
		case 3:
			speedOrDraw();
			break;
		}
	}
	
	
	public void cardEnhancedEvent()
	{
		while(true) {
			int randomCard = random.nextInt(player.getCardDeck().length);
			if(player.getCardDeck()[randomCard].getEnforce()==false)
			{
				int temp = random.nextInt(2);
				if(temp==0)
				{
					sortCard.enhanceCardPower(player.getCardDeck(), randomCard);
				}
				else if(temp==1) {
					sortCard.enhanceCardMana(player.getCardDeck(), randomCard);
				}
				break;
			}
		}
	}


	public void cardAddEvent()
	{
		TotalCardBase[] tempEventCard = new TotalCardBase[3];
		
		for(int i = 0; i <3; i++)
		{
			int tempRandomEventNumber=random.nextInt(eventCard.eventCard().length);
			tempEventCard[i] = eventCard.eventCard()[tempRandomEventNumber];
		}
		while(true)
		{
			sortCard.watchCard(tempEventCard,player);
			System.out.println("몇번째 카드를 가지나요? 0.고르지 않는다.");
			int temp=scan.nextInt();
			scan.nextLine();
			if(temp>0&&temp<4) {
				player.setCardDeck(sortCard.sortAddCard(player.getCardDeck(), tempEventCard, temp));
				break;
			}
			else if(temp==0)
			{
				break;
			}
			else
			{
				System.out.println("다시 골라주세요");
			}
		}
		
	}
	
	
	public void getMoneyOrHealth()
	{
		System.out.println("1.현재를 생각한다.  hp최대치50 증가, 이번 모험에서 MP 1증가");
		System.out.println("2.미래를 생각한다.  1000골드 획득");
		int choice = scan.nextInt();
		scan.nextLine();
		if(choice == 1)
		{
			player.setMaxMp(player.getMaxMp()+1);
			player.setMaxHp(player.getMaxHp()+50);
			player.setHp(player.getHp()+50);
		}
		else if(choice == 2)
		{
			player.setMoeny(player.getMoney()+1000);
		}
		else
		{
			System.out.println("다시 골라주세요.");
		}
		
	}
	
	
	public void speedOrDraw()
	{
		System.out.println("1.속도가 중요하다. 속도 5증가");
		System.out.println("2.손재주가 중요하다. 이번 모험에서 드로우 카드 1 증가");
		int choice = scan.nextInt();
		scan.nextLine();
		if(choice == 1)
		{
			player.setSpeed(player.getSpeed()+5);
		}
		else if(choice == 2)
		{
			player.setDrawCardNumber(player.getDrawCardNumber()+1);
		}
		else
		{
			System.out.println("다시 골라주세요.");
		}
	}
}
