package MakeGame_0824.CharacterBundle;

import MakeGame_0824.OwnedItem;
import MakeGame_0824.OwnedSkill;

public class EnemyCharacter extends CharacterBase 
{
	
	private String name;
	private String[] inventory;//가진아이템
	private OwnedSkill[] OwnedSkill;//소지스킬
	private int hp;
	private int mp;
	private int sp;
	private int atk;
	private int def;

	public EnemyCharacter() {
		super("적", new OwnedSkill[20],new OwnedItem[2], 5, 5, 10, 5, 5);
	}
	
	public EnemyCharacter(String name,OwnedSkill[] OwnedSkill,OwnedItem[] OwnedItem,int hp,int mp,int sp, int atk, int def)
	{
		this.name=name;
		this.OwnedSkill=OwnedSkill;
		this.OwnedItem=OwnedItem;
		this.hp=hp;
		this.mp=mp;
		this.atk=atk;
		this.def=def;
	}
	
	public EnemyCharacter[] enemy = new EnemyCharacter[2];
	
	public EnemyCharacter[] firstEnemyDatabase() //층마다 다를수 있으니까 나눠두자
	{
		enemy[0] = new EnemyCharacter("도적", new OwnedSkill[20],new OwnedItem[2], 5, 5, 10, 5, 5);
		enemy[1] = new EnemyCharacter("미친 뿔사슴", new OwnedSkill[20],new OwnedItem[2], 50, 50, 100, 50, 50);
		return enemy;
	}
	
	//set모음
	public void setName(String name) 
	{
		this.name = name;
	}
	public void setInventory(String[] inventory)
	{
		this.inventory=inventory;
	}
	public void setOwnedSkill(OwnedSkill[] OwnedSkill)
	{
		this.OwnedSkill=OwnedSkill;
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
		
	//get 모음
	
	public String getName() 
	{
		return name;
	}
	public String[] getInventory() 
	{
		return inventory;
	}
	public OwnedSkill[] getOwnedSkill() 
	{
		return OwnedSkill;
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
	
	public EnemyCharacter[] getEnemyCharacter() {
		return enemy;
	}
	

}
