package MakeGame_0824;

public abstract class CharacterBase 
{
	private String name;
	private OwnedSkill[] OwnedSkill;
	private OwnedItem[] OwnedItem;
	private int hp;
	private int mp;
	private int sp;
	private int[] proficiency;//숙련도
	private int atk;
	private int def;
	
	//String standingmotion;//일단 보류 
	
	CharacterBase(String name,OwnedSkill[] OwnedSkill,OwnedItem[] OwnedItem,int hp,int mp,int sp, int[] proficiency)
	{//플레이어블 캐릭터
		this.name=name;
		this.OwnedSkill=OwnedSkill;
		this.OwnedItem=OwnedItem;
		this.hp=hp;
		this.mp=mp;
		this.sp=sp;
		this.proficiency=proficiency;
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
	
	
	
	void Status() 
	{
		System.out.println("이름 :" + getName());
		OwnedSkill[] ownedSkill = getOwnedSkill();
		System.out.print("소지 스킬 : ");
		for(int i = 0; i < ownedSkill.length;i++)
		{
			System.out.print(ownedSkill[i]);
		}
		System.out.println();
		System.out.println("생명력 : "+getHp());
		System.out.println("마나 : "+getMp());
		System.out.println("스태미나 : "+getSp());
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
	public int[] getProficiency()
	{
		return proficiency;
	}
}
