package MakeGame_0824;

public class OwnedSkill 
{
	private String name;
	private String type;
	private int atk;
	private int consumeSp;
	private double consumeMp;
	private double heal;
	
	public OwnedSkill()
	{
		
	}
	
	public OwnedSkill(String name,String type,int atk,int consumeSp)//물리
	{
		this.name=name;
		this.type=type;
		this.atk=atk;		
		this.consumeSp=consumeSp;
	}
	
	public OwnedSkill(String name,String type,int atk,double consumeMp)//마법
	{
		this.name=name;
		this.type=type;
		this.atk=atk;
		this.consumeMp=consumeMp;
	}
	
	public OwnedSkill(String name,String type,double heal, double consumeMp)//회복
	{
		this.name=name;
		this.type=type;
		this.heal=heal;
		this.consumeMp=consumeMp;
	}
	
	public OwnedSkill[] skill = new OwnedSkill[2];
	
	
	OwnedSkill[] skillList() 
	{
		skill[0] = new OwnedSkill("혼신의 일격","물리",100,1);
		return skill;
	}
	
	public OwnedSkill[] getOwnedSkill()
	{
		return skill;
	}
	
	
	//set모음	
	public void setName(String name) 
	{
		this.name=name;
	}
	
	
	
	//get모음
	
	
	public String getName()
	{
		return name;
	}
	
	public String getType()
	{
		return type;
	}

	public int getAtk()
	{
		return atk;
	}
	public int getConsumeSp()
	{
		return consumeSp;
	}
	public double getConsumeMp()
	{
		return consumeMp;
	}
	public double getHeal()
	{
		return heal;
	}
}
