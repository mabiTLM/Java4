package MakeGame_0824.CharacterBundle;

import MakeGame_0824.OwnedItem;
import MakeGame_0824.OwnedSkill;

public abstract class CharacterBase 
{
	private String name;
	private String[] inventory;//가진아이템
	private OwnedSkill[] OwnedSkill;//소지스킬
	private OwnedItem[] OwnedItem;//장비아이템
	private int hp;
	private int mp;
	private int sp;
	private int maxHp;
	private int maxMp;
	private int maxSp;
	private double[] proficiency;//숙련도
	private int atk;
	private int def;
	private int money;
	
	//String standingmotion;//일단 보류
	
	
	CharacterBase()
	{
		
	}
	
	CharacterBase(
			String name,
			String[] inventory,
			OwnedSkill[] OwnedSkill,
			OwnedItem[] OwnedItem,
			int hp,
			int mp,
			int sp,
			double[] proficiency,
			int money
			)
	{//플레이어블 캐릭터
		this.name=name;
		this.inventory=inventory;
		this.OwnedSkill=OwnedSkill;
		this.OwnedItem=OwnedItem;
		this.hp=hp;
		this.mp=mp;
		this.sp=sp;
		this.proficiency=proficiency;
		this.money=money;
	}
	
	CharacterBase(String name,OwnedSkill[] OwnedSkill,OwnedItem[] OwnedItem,int hp,int mp,int sp, int atk, int def)
	{//적 캐릭터
		this.name=name;
		this.OwnedSkill=OwnedSkill;
		this.OwnedItem=OwnedItem;
		this.hp=hp;
		this.mp=mp;
		this.sp=sp;
		this.atk=atk;
		this.def=def;
	}
	
	
	
	public void Status() 
	{
		//System.out.println("이름 :" + getName());
		System.out.println("============================");
		System.out.println("스테이터스");
		
		System.out.println("생명력 : "+getHp());
		System.out.println("마나 : "+getMp());
		System.out.println("스태미나 : "+getSp());
		
		System.out.println("소지 스킬 : "); //너무 지저분해 보여서 일단 제거
		for(int i = 0; i < getOwnedSkill().length;i++)
		{
			System.out.println(getOwnedSkill()[i].getSkillDescription());
		}
		System.out.println("장비아이템 : ");
		for(int i = 0; i < getOwnedItem().length;i++)
		{
			System.out.println(getOwnedItem()[i].getItemDescription());
		}

		System.out.println("============================");
	}
	
	
	//set 모음
	public void setOwnedItem(OwnedItem[] OwnedItem)
	{
		this.OwnedItem=OwnedItem;
	}
	
	public void setOwnedItem(OwnedItem[] OwnedItem, int slot)
	{
		this.OwnedItem[slot]=OwnedItem[slot];
	}
	
	
	public void setMaxHp(int maxHp)
	{
		this.maxHp=maxHp;
	}
	
	public void setMaxMp(int maxMp)
	{
		this.maxMp=maxMp;
	}
	
	public void setMaxSp(int maxSp)
	{
		this.maxSp=maxSp;
	}
	
	
	public void setHp(int hp)
	{
		this.hp=hp;
	}
	
	public void setMp(int mp)
	{
		this.mp=mp;
	}
	
	public void setSp(int sp)
	{
		this.sp=sp;
	}
	
	public void setInventory(String[] inventory)
	{
		this.inventory=inventory;
	}
	public void setInventory(String inventory, int slot)
	{
		this.inventory[slot]=inventory;
	}
	
	public void setProficiency(double[] proficiency)
	{
		this.proficiency=proficiency;
	}
	public void setProficiency(double proficiency, int number)
	{
		this.proficiency[number]=proficiency;
	}
	
	public void setMoeny(int money)
	{
		this.money=money;
	}
	
	//get 모음
	public String getName() 
	{
		return name;
	}
	
	public OwnedSkill[] getOwnedSkill() 
	{
		return OwnedSkill;
	}
	
	public OwnedItem[] getOwnedItem() 
	{
		return OwnedItem;
	}
	
	public int getHp() 
	{
		return hp;
	}
	
	public int getMp() 
	{
		return mp;
	}
	
	public int getSp() 
	{
		return sp;
	}
	
	public int getMaxHp()
	{
		return maxHp;
	}
	
	public int getMaxMp()
	{
		return maxMp;
	}
	
	public int getMaxSp()
	{
		return maxSp;
	}
	
	
	public int getAtk()
	{
		return atk;
	}
	public int getDef()
	{
		return atk;
	}
	
	public double[] getProficiency()
	{
		return proficiency;
	}
	
	public String[] getInventory()
	{
		return inventory;
	}
	
	public int getMoney()
	{
		return money;
	}
}
