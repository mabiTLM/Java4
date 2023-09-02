package makeCardGame230901.cardBundle;

import java.util.Scanner;

import makeCardGame230901.characterBundle.EnemyCharacter;
import makeCardGame230901.characterBundle.PlayerCharacter;

public class Battle 
{
	PlayerCharacter player = new PlayerCharacter();
	TotalCardBase[] tempBattleDeck = player.getCardDeck();//플레이어의 덱을 배틀할때만 복사한다.
	TotalCardBase[] graveCard = new TotalCardBase[0];
	EnemyCharacter eArray = new EnemyCharacter();
	EnemyCharacter[] currentEnemy;
	Scanner scan = new Scanner(System.in);
	private	int turnDrawCardNumber=5;
	private int target;
	private int deckSize;
	private int topOfCard=0;
	private int useCardNumber=0;
	private boolean playerTurn = false;
	
	public Battle(PlayerCharacter player)
	{
		this.player=player;
	}
	
	public void encounter() //심볼인카운트 쓸거니까 몹종류만 정해주면된다.
	{
		int temp =(int)(Math.random()*4+1);//1~4마리
		
		currentEnemy = new EnemyCharacter[temp];
		System.out.println("적이 " + temp + "마리 출현했다.");
		for(int i = 0; i <currentEnemy.length;i++)
		{
			int enemyNumberTemp = (int)(Math.random()*eArray.firstStageData().length);
			currentEnemy[i]=eArray.firstStageData()[enemyNumberTemp];
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
		playerTurn=true;//드로우 할때 턴을 on
		for(int i = 0; i <turnDrawCardNumber;i++) {
			if(topOfCard<deckSize)//덱이 남아있을 때
				{
				player.drawToPlayerHand(tempBattleDeck[topOfCard]);
				topOfCard++;
				}
			else if(graveCard.length>0)//덱을 다쓰면 묘지를 덱으로 넣고 다시 섞는다.
			{
				tempBattleDeck=graveCard;
				graveCard=new TotalCardBase[0];//묘지를 비운다.
				topOfCard=0;//뽑는곳을 맨위로 올린다
				cardShuffle();				
				i--;
			}
			
		}
		if(topOfCard==deckSize)
		{
			System.out.println("덱을 전부소모했습니다.");
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
	
	public void watchEnemy()
	{
		for(int i = 0; i <currentEnemy.length;i++)
		{
			if(i==target-1)
			{
				System.out.print("["+(i+1)+currentEnemy[i].getName()+"]	");
			}
			else {
				System.out.print((i+1)+currentEnemy[i].getName()+"	");
			}
		}
		
	}
	
	public void targetLockOn()
	{
		while(true) {
			watchEnemy();
			watchPlayerHand();
			System.out.println("몇번 적을 타겟합니까? 0.턴 넘기기");
			target = scan.nextInt();
			if(target>currentEnemy.length)
			{
				System.out.println("다시 타겟해주세요");
			}
			else if(target==0)
			{
				playerTurn=false;
				break;
			}
			else
			{
				break;
				
			}		
			
		}
		
		while(playerTurn) {
			watchEnemy();
			watchPlayerHand();
			System.out.println("몇번 카드를 사용합니까? 0.다른 타겟");
			useCardNumber=scan.nextInt();
			if(useCardNumber==0)
			{
				target=0;
				break;				
			}
			else
			{
				useCard();
				if(player.getHand().length<1)
				{
					System.out.println("모든 패를 사용하여 턴이 넘어갑니다.");
					playerTurn=false;
					break;
				}
			}
		}
		//타겟하고 카드사용이 안에들어가야한다 타겟을 바꿀수도있으니까
	}
	public void useCard()
	{
		//사용한 카드를 묘지로 보낸다.
		TotalCardBase[] tempGraveCard = new TotalCardBase[graveCard.length+1];
		for(int i = 0; i<graveCard.length;i++)
		{			
			tempGraveCard[i]=graveCard[i];
		}
		tempGraveCard[graveCard.length]=player.getHand()[useCardNumber-1];
		graveCard=tempGraveCard;
		
		//넣은 카드번호의 카드를 사용 카드를 패에서 제거한후 패를 재정렬한다.
		TotalCardBase[] tempHandCard = new TotalCardBase[player.getHand().length-1];
		for(int i = 0; i<player.getHand().length;i++)
		{			
			if(i<useCardNumber-1)
			{
				tempHandCard[i]=player.getHand()[i];
			}
			else if(i>useCardNumber-1)
			{
				tempHandCard[i-1]=player.getHand()[i];
			}
		}
		player.setHand(tempHandCard);
	}
	
	//set 모음
	public void setUseCardNumber(int useCardNumber) 
	{
		this.useCardNumber=useCardNumber;
	}
	public void setDeckSize(int deckSize)
	{
		this.deckSize=deckSize;
	}
	public void setPlayerTurn(boolean playerTurn)
	{
		this.playerTurn=playerTurn;
	}
	
	
	//get모음
	public int getTarget()
	{
		return target;
	}
	
	public boolean getPlayerTurn()
	{
		return playerTurn;
	}
	
}
