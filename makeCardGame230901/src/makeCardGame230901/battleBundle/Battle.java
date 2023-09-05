package makeCardGame230901.battleBundle;

import java.util.Scanner;
import makeCardGame230901.cardBundle.CardType;
import makeCardGame230901.cardBundle.TotalCardBase;
import makeCardGame230901.cardBundle.cardSortBundle.SortCard;
import makeCardGame230901.characterBundle.EnemyCharacter;
import makeCardGame230901.characterBundle.PlayerCharacter;
import makeCardGame230901.village.MoveInVillage;

public class Battle 
{
	private PlayerCharacter player;
	protected TotalCardBase[] tempBattleDeck = new TotalCardBase[0];//플레이어의 덱을 배틀할때만 복사한다.
	private TotalCardBase[] graveCard = new TotalCardBase[0];
	private EnemyCharacter eArray = new EnemyCharacter();
	protected EnemyCharacter[] currentEnemy;
	SortCard sortCard = new SortCard();
	Scanner scan = new Scanner(System.in);
	private	int turnDrawCardNumber=5;
	private int target;
	private int useCardNumber=0;
	private boolean playerTurn = false;
	MONSTERTYPE monsterType;
	
	public Battle(PlayerCharacter player)
	{
		this.player=player;
	}
	
	
	public void encounter() //어떤 적을 만날지 정해주자
	{
		resetTempBattleDeck(player.getCardDeck());
		//현재덱을 깊은 복사 싸우는 도중에 덱이 변경되어도 전투가 끝나면 돌아오게하기위한 밑준비
		graveCard = new TotalCardBase[0];
		player.disCardHand();
		
		if(monsterType==MONSTERTYPE.NORMAL)
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
		else if(monsterType==MONSTERTYPE.ELITE)
		{
			int temp =(int)(Math.random()*2+1);//1~4마리
			currentEnemy = new EnemyCharacter[temp];
			System.out.println("엘리트적이 " + temp + "마리 출현했다.");
			for(int i = 0; i <currentEnemy.length;i++)
			{
				int enemyNumberTemp = (int)(Math.random()*eArray.firstStageEliteData().length);
				currentEnemy[i]=eArray.firstStageEliteData()[enemyNumberTemp];
			}
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
	}
	
	
	// 카드를뽑고 사용한 카드를 묘지로 보낸다. 덱을 전부 소모하면 묘지의 카드를 섞어서 다시 덱을 만든다.
	public void cardDraw() //카드를 뽑고 뽑은 카드를 현재 손패로 가져온다. 드로우매수만큼for문
	{
		player.setMp(player.getMaxMp());//턴시작시 마나회복
		
		for(int i = 0; i <turnDrawCardNumber;i++) {
			
			if(tempBattleDeck.length>0)//덱이 남아있으면
			{
				player.setHand(sortCard.sortAddCard(player.getHand(), tempBattleDeck, 1));//핸드에 넣고
				tempBattleDeck=sortCard.sortRemoveCard(tempBattleDeck, 1);//덱은 하나 줄이고
			}
			else if(graveCard.length>0)
			{
				tempBattleDeck=graveCard;
				graveCard=new TotalCardBase[0];
				cardShuffle();
				i--;
			}
			else {
				System.out.println("덱을 전부소모했습니다.");
				break;
			}
			
		}		
	}
	
	
	public void watchPlayerHand()
	{
		for(int i = 0; i < player.getHand().length;i++)//마나
		{
			System.out.print("   "+player.getHand()[i].getCardConsumeMana());
			System.out.print(" 마나========   ");
		}
		System.out.println();
		
		for(int i = 0; i < player.getHand().length;i++)
		{
			if(player.getHand()[i].getCardName().length()==3)//카드이름
			{
				System.out.print("   |   "+player.getHand()[i].getCardName()+"    |   ");
			}
			else if(player.getHand()[i].getCardName().length()==4)
			{
				System.out.print("   |   "+player.getHand()[i].getCardName()+"  |   ");
			}
			else {
			System.out.print("   |    "+player.getHand()[i].getCardName()+"    |   ");
			}
		}
		System.out.println();
		
		for(int i = 0; i < player.getHand().length;i++)
		{
			System.out.print("   |  "+player.getHand()[i].getCardType()+"   |   ");			
		}
		System.out.println();
		
		
		for(int i = 0; i < player.getHand().length;i++)
		{
			if(player.getHand()[i].getCardValue()<10)
			{
				System.out.print("   =========== ");
			}
			else
			{
				System.out.print("   ========== ");
			}
			System.out.print(player.getHand()[i].getCardValue()+"   ");
		}
		System.out.println();
		for(int i = 0; i < player.getHand().length;i++)
		{
			System.out.print("        "+(i+1)+"          ");
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
			currentEnemy[i].status();
		}
		
	}
	
	
	public void targetLockOn(BattleCombine battleCombine, MoveInVillage moveInVillage)//전투가 거의다 타겟정하는대서 이뤄진다.
	{
		while(true) {
			watchEnemy();
			watchPlayerHand();
			player.status();
			//모든 몬스터 제거시 실행종료
			if(currentEnemy.length<1)
			{
				System.out.println("전투에서 승리했습니다.");
				setPlayerTurn(false);
				battleFinish();
				break;
			}
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
			player.status();
			System.out.println("몇번 카드를 사용합니까? 0.다른 타겟");
			useCardNumber=scan.nextInt();
			
			if(useCardNumber==0)
			{
				target=0;
				break;
			}
			else if(useCardNumber>player.getHand().length)
			{
				System.out.println("카드를 다시 골라주세요");
			}
			else
			{
				useCard();
				
				//여기서 적 사망 처리해야한다.
				
				if(currentEnemy[target-1].getHp()<=0)
				{
					player.setMoeny(player.getMoney()+currentEnemy[target-1].getMoney());//돈얻고
					System.out.println("적을 처치하여"+currentEnemy[target-1].getMoney()+"골드를 얻었습니다.");
					
					EnemyCharacter[] tempSort = new EnemyCharacter[currentEnemy.length-1];
					int tempSortBlank=0;
					for(int i = 0; i <tempSort.length;i++)
					{
						if(i==target-1)
						{
							tempSortBlank++;
						}						
						tempSort[i]=currentEnemy[i+tempSortBlank];
					}
					currentEnemy=tempSort;
					
					//적이 죽었을때 행동게이지도 수정해야한다.
					tempSortBlank=0;
					int[] tempEnemyTurnGaze = new int[battleCombine.getEnemyTurnGaze().length-1];
					for(int i = 0; i <tempEnemyTurnGaze.length;i++)
					{
						if(i==target-1)
						{
							tempSortBlank++;
						}						
						tempEnemyTurnGaze[i]=battleCombine.getEnemyTurnGaze()[i+tempSortBlank];
					}
					battleCombine.setEnemyTurnGaze(tempEnemyTurnGaze);
					
					target=0;//적 처치시 다시 타겟설정으로
					break;
				}
				
				if(player.getHand().length<1)
				{
					System.out.println("모든 패를 사용하여 턴이 넘어갑니다.");
					playerTurn=false;
					target=0;
					break;
				}
			}
		}
		//타겟하고 카드사용이 안에들어가야한다 타겟을 바꿀수도있으니까
	}
	
	
	public void useCard()
	{
		if(player.getMp()-player.getHand()[useCardNumber-1].getCardConsumeMana()<0)//mp가 있을때만 처리를 한다.
		{
			System.out.println("mp가 부족해서 사용할수없다.");
		}
		else {
			//사용한 카드를 묘지로 보낸다.
			graveCard=sortCard.sortAddCard(graveCard, player.getHand(), useCardNumber);
						
			playerBattleCalculator();//사용한 카드의 전투계산을 한다.
			
			//넣은 카드번호의 카드를 사용 카드를 패에서 제거한후 패를 재정렬한다.			
			player.setHand(sortCard.sortRemoveCard(player.getHand(), useCardNumber));
			
		}
	}
	
	
	public void playerBattleCalculator()
	{
		player.setMp(player.getMp()-player.getHand()[useCardNumber-1].getCardConsumeMana());
		if(player.getHand()[useCardNumber-1].getCardType()==CardType.Defend)
		{
			player.setDef(player.getDef()+player.getHand()[useCardNumber-1].getCardValue());
			player.status();
		}
		else if(player.getHand()[useCardNumber-1].getCardType()==CardType.Attack)
		{
			int tempDamage=0;
			currentEnemy[target-1].setDef(currentEnemy[target-1].getDef()-player.getHand()[useCardNumber-1].getCardValue());
			if(currentEnemy[target-1].getDef()<0)
			{
				tempDamage=Math.abs(currentEnemy[target-1].getDef());
				currentEnemy[target-1].setDef(0);
			}
			currentEnemy[target-1].setHp(currentEnemy[target-1].getHp()-tempDamage);//목표로한적에게 데미지를 준다.
			
		}
		
	}
	
	public void battleFinish()
	{
		System.out.println("전투 승리 보상을 획득합니다.");
	}
	
	public void resetTempBattleDeck(TotalCardBase[] battleDeck)
	{
		TotalCardBase[] temp = new TotalCardBase[battleDeck.length];
		
		for(int i = 0; i <battleDeck.length;i++)
		{
			temp[i]=battleDeck[i];
		}
		
		this.tempBattleDeck=temp;
	}
	
	
	//set 모음
	
	
	
	public void setUseCardNumber(int useCardNumber) 
	{
		this.useCardNumber=useCardNumber;
	}
	public void setPlayerTurn(boolean playerTurn)
	{
		this.playerTurn=playerTurn;
	}
	
	public void setMonsterType(MONSTERTYPE monsterType)
	{
		this.monsterType=monsterType;
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
	
	public TotalCardBase[] getTempBattleDeck()
	{
		return tempBattleDeck;
	}
}
