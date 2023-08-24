package MakeGame_0824;

public abstract class CharacterBase 
{
	private String name;
	private String[] ownedSkill;
	private String[] ownedItem;
	private int hp;
	private int mp;
	private int sp;
	
	
	//String standingmotion;//일단 보류 
	
	CharacterBase(String name,String[] ownedSkill,String[] ownedItem,int hp,int mp,int sp)
	{
		this.name=name;
		this.ownedSkill=ownedSkill;
		this.ownedItem=ownedItem;
		this.hp=hp;
		this.mp=mp;
		this.sp=sp;
	}
	
	void Status() 
	{
		System.out.println("이름 :" + getName());
		System.out.println("소지 스킬 :" + getOwnedSkill());
		System.out.println("생명력 : "+getHp());
		System.out.println("마나 : "+getMp());
		System.out.println("스태미나 : "+getSp());
	}
	
	//get 모음
	public String getName() 
	{
		return name;
	}
	
	public String[] getOwnedSkill() 
	{
		return ownedSkill;
	}
	
	public String[] getOwnedItem() 
	{
		return ownedItem;
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
}
