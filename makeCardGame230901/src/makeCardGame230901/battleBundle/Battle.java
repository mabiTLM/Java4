package makeCardGame230901.battleBundle;

import java.util.Scanner;
import makeCardGame230901.cardBundle.CardType;
import makeCardGame230901.cardBundle.TotalCardBase;
import makeCardGame230901.cardBundle.cardSortBundle.SortCard;
import makeCardGame230901.characterBundle.PlayerCharacter;
import makeCardGame230901.characterBundle.enemyBundle.EnemyCharacter;
import makeCardGame230901.characterBundle.enemyBundle.FirstFloorEnemy;
import makeCardGame230901.characterBundle.enemyBundle.SecondFloorEnemy;
import makeCardGame230901.mapBundle.EventInDungeon;

public class Battle 
{
	private PlayerCharacter player;
	protected TotalCardBase[] tempBattleDeck = new TotalCardBase[0];//플레이어의 덱을 배틀할때만 복사한다.
	private TotalCardBase[] graveCard = new TotalCardBase[0];
	private EnemyCharacter eArray;
	protected EnemyCharacter[] currentEnemy;
	EventInDungeon eventInDungeon;
	SortCard sortCard = new SortCard();
	Scanner scan = new Scanner(System.in);
	private int target;
	private int useCardNumber=0;
	private boolean playerTurn = false;
	MONSTERTYPE monsterType;
		
	public Battle(PlayerCharacter player)
	{
		this.player=player;
		eventInDungeon = new EventInDungeon(player);
	}
	
	public void encounter() //어떤 적을 만날지 정해주자
	{
		tempBattleDeck=sortCard.deepCopyDeck(player.getCardDeck());
		//현재덱을 깊은 복사 싸우는 도중에 덱이 변경되어도 전투가 끝나면 돌아오게하기위한 밑준비
		tempBattleDeck=sortCard.suffleDeck(tempBattleDeck);
		if(player.getNowFloor()==1) 
		{
			eArray = new FirstFloorEnemy();
		}
		else if(player.getNowFloor()==2) 
		{
			eArray = new SecondFloorEnemy();
		}
		encountFloor();
	}
	
	private void encountFloor()
	{
		if(monsterType==MONSTERTYPE.NORMAL)
		{
			int temp =(int)(Math.random()*4+1);//1~4마리
			currentEnemy = new EnemyCharacter[temp];
			System.out.println("적이 " + temp + "마리 출현했다.");
			for(int i = 0; i <currentEnemy.length;i++)
			{
				int enemyNumberTemp = (int)(Math.random()*eArray.stageData().length);
				currentEnemy[i]=eArray.stageData()[enemyNumberTemp];
			}
		}
		else if(monsterType==MONSTERTYPE.ELITE)
		{
			int temp =(int)(Math.random()*2+1);//1~4마리
			currentEnemy = new EnemyCharacter[temp];
			System.out.println("엘리트적이 " + temp + "마리 출현했다.");
			for(int i = 0; i <currentEnemy.length;i++)
			{
				int enemyNumberTemp = (int)(Math.random()*eArray.stageEliteData().length);
				currentEnemy[i]=eArray.stageEliteData()[enemyNumberTemp];
			}
		}
		else if(monsterType==MONSTERTYPE.BOSS)
		{
			currentEnemy = new EnemyCharacter[1];
			int enemyNumberTemp = (int)(Math.random()*eArray.stageBossData().length);
			currentEnemy[0]=eArray.stageBossData()[enemyNumberTemp];
			System.out.println("[보스]"+eArray.stageBossData()[enemyNumberTemp].getName()+"가 출현했다.");
		}
	}

	/**
	 *카드를뽑는다. 덱을 전부 소모하면 묘지의 카드를 섞어서 다시 덱을 만든다.
	 **/
	public void cardDraw(int drawNumber)
	{
		for(int i = 0; i <drawNumber;i++) {
			
			if(tempBattleDeck.length>0)//덱이 남아있으면
			{
				player.setHand(sortCard.sortAddCard(player.getHand(), tempBattleDeck, 1));//핸드에 넣고
				tempBattleDeck=sortCard.sortRemoveCard(tempBattleDeck, 1);//덱은 하나 줄이고
			}
			else if(graveCard.length>0)
			{
				tempBattleDeck=graveCard;
				graveCard=new TotalCardBase[0];
				tempBattleDeck=sortCard.suffleDeck(tempBattleDeck);
				i--;
			}
			else {
				System.out.println("덱을 전부소모했습니다.");
				break;
			}
			
		}		
	}
	
	public void watchEnemy()
	{
		for(int i = 0; i <currentEnemy.length;i++)
		{
			if(i==target-1)
			{
				System.out.print("["+(i+1)+currentEnemy[i].getName()+"]    ");
			}
			else {
				System.out.print((i+1)+currentEnemy[i].getName()+"    ");
			}
			currentEnemy[i].status();
		}
		
	}
	
	
	public void targetLockOn(BattleCombine battleCombine)//전투가 거의다 타겟정하는대서 이뤄진다.
	{
		while(true) 
		{
			try {
				if(playerWin())
				{
					System.out.println("전투에서 승리했습니다.");
					battleFinish();
					break;
				}
				watchEnemy();
				sortCard.watchCard(player.getHand(),player);
				player.status();
				//모든 몬스터 제거시 실행종료				
				System.out.println("몇번 적을 타겟합니까? 0.턴 넘기기");
				target = scan.nextInt();
				scan.nextLine();
				if(target>currentEnemy.length||target<0)
				{
					System.out.println("다시 타겟해주세요");
				}
				else if(target==0)
				{
					playerTurnOff();
					break;
				}
				else
				{
					break;
				}
				}
			catch(Exception e)
			{
				scan.nextLine();
			}
		}
		
		while(playerTurn) 
		{
			try {
			watchEnemy();
			sortCard.watchCard(player.getHand(),player);
			player.status();
			System.out.println("몇번 카드를 사용합니까? 0.다른 타겟");
			useCardNumber=scan.nextInt();
			scan.nextLine();
			if(useCardNumber==0)
			{
				target=0;
				break;
			}
			else if(useCardNumber>player.getHand().length||useCardNumber<0)
			{
				System.out.println("카드를 다시 골라주세요");
			}
			else
			{
				useCard();				
				if(currentEnemy[target-1].getHp()<=0)//적의 체력이 0이하면 적을 죽인다
				{
					monsterDie();
					break;
				}
				
				if(player.getHand().length<1)//손을 전부소모하면 패를 넘긴다
				{
					playerTurnOff();
					break;
				}
			}
			}
			catch(Exception e)
			{
				scan.nextLine();
			}
		}
		//타겟하고 카드사용이 안에들어가야한다 타겟을 바꿀수도있으니까
	}
	
	/**
	 *카드를 사용했을 때 처리해야하는 일들
	 **/
	public void useCard()
	{
		if(player.getMp()-player.getHand()[useCardNumber-1].getCardConsumeMana()<0)//mp가 있을때만 처리를 한다.
		{
			System.out.println("mp가 부족해서 사용할수없다.");
		}
		else {
			//사용한 카드를 묘지로 보낸다.
			if(!player.getHand()[useCardNumber-1].getEffect().equals("휘발성"))
			{
				graveCard=sortCard.sortAddCard(graveCard, player.getHand(), useCardNumber);
			}
			playerBattleCalculator();//사용한 카드의 전투계산을 한다.
			
			//넣은 카드번호의 카드를 사용 카드를 패에서 제거한후 패를 재정렬한다.			
			player.setHand(sortCard.sortRemoveCard(player.getHand(), useCardNumber));			
		}
	}
	
	/**
	 *사용한 카드에 맞는 계산식을 넣어주자
	 **/	
	public void playerBattleCalculator()
	{
		TotalCardBase currentUseCard = player.getHand()[useCardNumber-1];
		
		cardEffectCalculator(currentUseCard);		
		player.setMp(player.getMp()-currentUseCard.getCardConsumeMana());
		if(currentUseCard.getCardType()==CardType.Defend)
		{
			player.setDef(player.getDef()+currentUseCard.getCardValue());
			player.status();
		}
		else if(currentUseCard.getCardType()==CardType.Attack)
		{
			int tempDamage=0;
			currentEnemy[target-1].setDef(currentEnemy[target-1].getDef()-currentUseCard.getCardValue());
			if(currentEnemy[target-1].getDef()<0)
			{
				tempDamage=Math.abs(currentEnemy[target-1].getDef());
				currentEnemy[target-1].setDef(0);
			}
			currentEnemy[target-1].setHp(currentEnemy[target-1].getHp()-tempDamage);//목표로한적에게 데미지를 준다.
		}
		else if(currentUseCard.getCardType()==CardType._HEAL_)
		{
			player.setHp(player.getHp()+currentUseCard.getCardValue());
			player.status();
		}
		
	}
	
	private void cardEffectCalculator(TotalCardBase currentCard)
	{
		String name = currentCard.getEffect();
		int value = currentCard.getEffectValue();
		
		if(name.equals("드로우"))
		{
			this.cardDraw(value);
		}
		else if(name.equals("방패깨기"))
		{
			currentEnemy[target-1].setDef(0);
		}
		
	}
	
	
	
	/**
	 *전투가 끝났을 때 손패를 버리고 묘지를 비워준다. 처음에 얻는 카드를 고정시킬수있게 시작단이 아닌 끝나는 곳에 넣는다. 
	 **/
	public void battleFinish()
	{
		playerTurnOff();
		player.setDef(0);
		if(monsterType==MONSTERTYPE.NORMAL) {
			System.out.println("전투 승리 보상을 획득합니다.");
			eventInDungeon.cardAddEvent();
		}
		else if(monsterType==MONSTERTYPE.ELITE) {
			System.out.println("엘리트 승리 보상을 획득합니다.");
			eventInDungeon.cardAddEvent();
			eventInDungeon.cardAddEvent();
			eventInDungeon.cardAddEvent();
		}
		else if(monsterType==MONSTERTYPE.BOSS)
		{
			System.out.println("보스한테 승리했습니다.");
			System.out.println("다음 층으로 넘어갑니다.");
			player.setNowFloor(player.getNowFloor()+1);
		}
	}
	
	/**
	 *플레이어 턴 시작할때 처리해야되는 것들을 처리한다. 버프나 지속치유등
	 **/
	public void playerTurnStart()
	{
		if(player.getStunTurn()>0)
		{
			System.out.println("기절 상태라 움직일 수 없다.");
			playerTurnOff();
			player.setStunTurn(player.getStunTurn()-1);
		}
		else
		{
			player.setDivineForce(player.getDivineForce()-1);
			cardDraw(player.getDrawCardNumber());
			player.setMp(player.getMaxMp());//턴시작시 마나회복
		}
	}
	
	
	/**
	 *턴이 끝났을 때 행동처리, 출혈등이나 스턴등의 효과를 구현할때도 다시 사용해야한다.
	 **/
	public void playerTurnOff()
	{
		playerTurn=false;//턴끄고
		graveCard = sortCard.deckPlusDeck(graveCard, player.getHand());//손을 묘지로 보내고
		player.disCardHand();		
		target=0;
	}
	
	/**
	 *몬스터가 죽는 경우에 넣어주자
	 **/
	public void monsterDie()
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
		target=0;
	}
	
	public boolean playerWin()
	{
		return currentEnemy.length<1;
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
	public void setTempBattleDeck(TotalCardBase[] tempBattleDeck)
	{
		this.tempBattleDeck=tempBattleDeck;
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
	public EnemyCharacter[] getCurrentEnemy()
	{
		return currentEnemy;
	}
}
