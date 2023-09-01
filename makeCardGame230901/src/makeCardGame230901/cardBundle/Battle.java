package makeCardGame230901.cardBundle;

import java.util.Scanner;

import makeCardGame230901.characterBundle.EnemyCharacter;
import makeCardGame230901.characterBundle.PlayerCharacter;

public class Battle 
{
	PlayerCharacter player = new PlayerCharacter();//임시
	TotalCardBase[] tempBattleDeck = player.getCardDeck();//플레이어의 덱을 배틀할때만 복사한다.
	TotalCardBase[] tempGraveCard;
	EnemyCharacter eArray = new EnemyCharacter();
	EnemyCharacter[] currentEnemy;
	Scanner scan = new Scanner(System.in);
	private	int turnDrawCardNumber=5;
	private int target;
	private int deckSize;
	private int topOfCard=0;
	
	public void encounter() //심볼인카운트 쓸거니까 몹종류만 정해주면된다.
	{
		int temp =(int)(Math.random()*4+1);//1~4마리
		
		currentEnemy = new EnemyCharacter[temp];
		System.out.println("적이 " + temp + "마리 출현했다.");
		for(int i = 0; i <currentEnemy.length;i++)
		{
			int enemyNumberTemp = (int)(Math.random()*eArray.firstStageData().length);
			currentEnemy[i]=eArray.firstStageData()[enemyNumberTemp];
			System.out.println(currentEnemy[i].getName());
		}
		
	}

	public void cardShuffle()//셔플과 사용은 배틀에서 하는게 맞는거같다 싸움도중에 임시로 덱이 변동되어도 마을가면 돌아와야하니까
	{
		int temp;
		TotalCardBase tempSuffleDeck;
		for(int i = 0; i < tempBattleDeck.length;i++)
		{
			temp=(int)(Math.random()*tempBattleDeck.length);
			tempSuffleDeck = tempBattleDeck[i];
			tempBattleDeck[i]=tempBattleDeck[temp];
			tempBattleDeck[temp] = tempSuffleDeck;			
		}
		deckSize=tempBattleDeck.length;
	}
	
	// 카드를뽑고 사용한 카드를 묘지로 보낸다. 덱을 전부 소모하면 묘지의 카드를 섞어서 다시 덱을 만든다.
	public void cardDraw() //카드를 뽑고 뽑은 카드를 현재 손패로 가져온다. 드로우매수만큼for문
	{
		for(int i = 0; i <turnDrawCardNumber;i++) {
			if(topOfCard<deckSize)//덱이 남아있을 때
				{
				player.drawToPlayerHand(tempBattleDeck[topOfCard]);
				topOfCard++;
				}
			else if(tempGraveCard!=null)
			{
				tempBattleDeck=tempGraveCard;
				cardShuffle();
				i--;				
			}
			else
			{
				System.out.println("덱을 전부소모했습니다.");
				break;
			}
		}
	}
	
	public void watchPlayerHand()
	{
		for(int i = 0; i < player.getHand().length;i++)
		{
			System.out.print(player.getHand()[i].getCardName());
		}
		System.out.println();
		
	}
	
	public void targetLockOn()
	{
		System.out.println("몇번 적을 타겟합니까?");
		target = scan.nextInt();
	}

	public void useCard()
	{
			System.out.println(currentEnemy[target-1].getName());
	}
}
