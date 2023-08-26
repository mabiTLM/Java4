package MakeGame_0824.CharacterBundle;

import MakeGame_0824.OwnedItem;
import MakeGame_0824.OwnedSkill;

public class EnemyCharacter extends CharacterBase 
{
	
	private String name;
	private String[] dropItem;//가진아이템
	private OwnedSkill[] OwnedSkill;//소지스킬
	private int hp;
	private int mp;
	private int sp;
	private int atk;
	private int def;
	private int dropMoney;
	private double dropPercent;

	public EnemyCharacter() {
		super("적", new OwnedSkill[20],new OwnedItem[2], 5, 5, 10, 5, 5);
	}
	
	public EnemyCharacter(
			String name,
			OwnedSkill[] OwnedSkill, //아직 스킬은 없지만 일단 넣어두자 혹시 사용한다면 적행동클래스를 따로만들어서 행동을 지정할것 
			String[] dropItem, //드랍 아이템
			int hp,
			int mp,
			int sp,
			int atk,
			int def,
			int dropMoney,
			double dropPercent
			)
	{
		this.name=name;
		this.OwnedSkill=OwnedSkill;
		this.dropItem=dropItem;
		this.hp=hp;
		this.mp=mp;
		this.atk=atk;
		this.def=def;
		this.dropMoney=dropMoney;
		this.dropPercent=dropPercent;
	}
	
	public EnemyCharacter[] enemy = new EnemyCharacter[2];
	
	public EnemyCharacter[] firstEnemyDatabase() //층마다 다를수 있으니까 나눠두자
	{
		enemy[0] = new EnemyCharacter(
				"도적",
				new OwnedSkill[0],
				new String[]{"낡은 지팡이"},
				5,
				5,
				10,
				5,
				5,
				1000,
				100);
		enemy[1] = new EnemyCharacter(
				"미친 뿔사슴",
				new OwnedSkill[0],
				new String[]{"낡은 지팡이"},
				50,
				50,
				100,
				50,
				50,
				10000,
				100);
		return enemy;
	}
	
	//set모음
	public void setName(String name) 
	{
		this.name = name;
	}
	public void setOwnedSkill(OwnedSkill[] OwnedSkill)
	{
		this.OwnedSkill=OwnedSkill;
	}	
	public void setAtk(int atk)
	{
		this.atk=atk;
	}
	public void setDef(int def)
	{
		this.def=def;
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
	public String[] getDropItem() 
	{
		return dropItem;
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
	public int getAtk()
	{
		return atk;
	}
	public int getDef()
	{
		return atk;
	}
	
	public int getDropMoney()
	{
		return dropMoney;
	}
	
	public EnemyCharacter[] getEnemyCharacter() {
		return enemy;
	}
	
	public double getDropPercent()
	{
		return dropPercent;
	}

}
