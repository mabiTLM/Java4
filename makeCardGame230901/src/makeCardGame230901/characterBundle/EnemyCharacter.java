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
		stageEnemy[0] = new EnemyCharacter("슬라임",30,0,30,0,5,0,100,5);
		stageEnemy[1] = new EnemyCharacter("돌멩이",30,0,30,0,5,0,100,5);
		stageEnemy[2] = new EnemyCharacter("골렘",30,0,30,0,5,0,100,5);
		return stageEnemy;
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
	
	
	//get 모음
	public String getName() 
	{
		return name;
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
