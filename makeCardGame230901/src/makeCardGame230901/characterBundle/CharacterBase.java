package makeCardGame230901.characterBundle;

import makeCardGame230901.cardBundle.TotalCardBase;

public abstract class CharacterBase 
{
	private String name;
	private TotalItem[] inventory;//가진아이템
	private TotalCardBase[] cardDeck;//덱, 무기위치
	private TotalCardBase[] hand;
	private int hp;
	private int mp;
	private int maxHp=9999999;
	private int maxMp;
	private int atk;
	private int def;
	private int money;
	private int speed;//속도
	private int avoidanceRate;//회피율 일단 보류
	private int accuracy;//명중률
	
	CharacterBase(){}
	
	
	CharacterBase(
			String name,
			TotalItem[] inventory,
			TotalCardBase[] cardDeck,
			TotalCardBase[] hand,
			int maxHp,
			int maxMp,
			int hp,
			int mp,
			int money
			)
	{//플레이어블 캐릭터
		this.name=name;
		this.inventory=inventory;
		this.cardDeck=cardDeck;
		this.hand=hand;
		this.maxHp=maxHp;
		this.maxMp=maxMp;
		this.hp=hp;
		this.mp=mp;
		this.money=money;
	}
	
	CharacterBase(
			String name,
			int maxHp,
			int maxMp,
			int hp,
			int mp,
			int atk,
			int def,
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
		this.speed=speed;
	}
	

	
	
	//set 모음
	
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
	public void setHand(TotalCardBase[] hand)
	{
		this.hand=hand;
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
		return cardDeck;		
	}
	
	public int getSpeed()
	{
		return speed;
	}
	public TotalCardBase[] getHand()
	{
		return hand;
	}
}
