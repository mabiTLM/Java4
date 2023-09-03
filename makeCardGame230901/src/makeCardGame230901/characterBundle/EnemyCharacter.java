package makeCardGame230901.characterBundle;

import makeCardGame230901.cardBundle.TotalCardBase;

public class EnemyCharacter extends CharacterBase 
{
	private String name;
	private TotalItem[] inventory;//가진아이템
	private TotalCardBase[] dropCard;//굳이 몹한테 넣어야될까?
	private int hp;
	private int mp;
	private int maxHp=9999999;
	private int maxMp;
	private int atk;
	private int def;
	private int money;
	private int speed;
	private boolean enemyTurn = false;
	
	public EnemyCharacter(){}
	
	EnemyCharacter(
			String name,
			int maxHp,
			int maxMp,
			int hp,
			int mp,
			int atk,
			int def,
			int money,
			int speed
			)
	{//적 캐릭터
		this.name=name;
		this.maxHp=maxHp;
		this.maxMp=maxMp;
		this.hp=hp;
		this.mp=mp;
		this.atk=atk;
		this.def=def;
		this.money=money;
		this.speed=speed;
	}
	
	EnemyCharacter[] stageEnemy = new EnemyCharacter[3];
	
	public EnemyCharacter[] firstStageData()
	{
		stageEnemy[0] = new EnemyCharacter("슬라임",20,0,20,0,5,0,100,10);
		stageEnemy[1] = new EnemyCharacter("도적",20,0,20,0,5,0,100,30);
		stageEnemy[2] = new EnemyCharacter("골렘",50,0,100,0,50,50,100,4);
		return stageEnemy;
	}
	
	
	public void status() {
		System.out.println("체력 : "+getHp()+" 쉴드 : " + getDef() + " 공격력 : " +getAtk() + " 속도 : " + getSpeed());
	}
	
	
	public void setMaxHp(int maxHp)
	{
		this.maxHp=maxHp;
	}
	
	public void setMaxMp(int maxMp)
	{
		this.maxMp=maxMp;
	}
	
	public void setHp(int hp)
	{
		if(hp>getMaxHp())
		{
			hp=getMaxHp();
		}
		this.hp=hp;
	}
	
	public void setMp(int mp)
	{
		if(mp>getMaxMp())
		{
			mp=getMaxMp();
		}
		this.mp=mp;
	}
	
	public void setInventory(TotalItem[] inventory)
	{
		this.inventory=inventory;
	}
	public void setInventory(TotalItem inventory, int slot)
	{
		this.inventory[slot]=inventory;
	}
	
	public void setMoeny(int money)
	{
		if(money<0)
		{
			money=0;
		}
		this.money=money;
	}
	
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}
	
	public void setEnemyTurn(boolean enemyTurn)
	{
		this.enemyTurn=enemyTurn;
	}
	public void setDef(int def)
	{
		this.def=def;
	}
	
	
	//get 모음
	public String getName() 
	{
		return name;
	}
	
	public boolean getEnemyTurn()
	{
		return enemyTurn;
	}
	
	public int getHp() 
	{
		return hp;
	}
	
	public int getMp() 
	{
		return mp;
	}	
	public int getMaxHp()
	{
		return maxHp;
	}
	
	public int getMaxMp()
	{
		return maxMp;
	}

	public int getAtk()
	{
		return atk;
	}
	public int getDef()
	{
		return def;
	}
	
	public TotalItem[] getInventory()
	{
		return inventory;
	}
	
	public int getMoney()
	{
		return money;
	}
	
	public TotalCardBase[] getCardDeck()
	{
		return dropCard;		
	}
	
	public int getSpeed()
	{
		return speed;
	}
}
