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
			"최대체력+50 최대마나+1",
			"이벤트 카드를 얻습니다."			
	};
	
	EventInDungeon(PlayerCharacter player)
	{
		this.player=player;
	}
	
	public void event()
	{
		int temp = random.nextInt(story.length);
		System.out.println(story[temp]);
		switch(temp)
		{
		case 0://스탯증가 이벤트
			player.setMaxMp(player.getMaxMp()+1);
			player.setMaxHp(player.getMaxHp()+50);
			break;
		case 1:
			TotalCardBase[] tempEventCard = new TotalCardBase[3];
			
			for(int i = 0; i <3; i++)
			{
				int tempRandomEventNumber=random.nextInt(eventCard.eventCard().length);
				tempEventCard[i] = eventCard.eventCard()[tempRandomEventNumber];				
			}
			sortCard.watchCard(tempEventCard);
			System.out.println("몇번째 카드를 가지나요?");
			temp=scan.nextInt();
			player.setCardDeck(sortCard.sortAddCard(player.getCardDeck(), tempEventCard, temp));
			
			break;
		
		}
	}
}
