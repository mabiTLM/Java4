package MakeGame_0824.CharacterBundle;

public class OwnedSkill 
{
	private String name;
	private String type;
	private int atk;
	private int consumeSp;
	private double consumeMp;
	private int hpHeal;
	private int spHeal;	
	private String skillDescription;
	
	public enum skill
	{
		psy,
		magic,
		heal
	}
	
	public OwnedSkill()
	{
		
	}
	
	public OwnedSkill(
			String name,
			String type,
			int atk,
			int consumeSp,
			String skillDescription)//물리
	{
		this.name=name;
		this.type=type;
		this.atk=atk;		
		this.consumeSp=consumeSp;
		this.skillDescription=skillDescription;
	}
	
	public OwnedSkill(
			String name,
			String type,
			int atk,
			double consumeMp,
			String skillDescription)//마법
	{
		this.name=name;
		this.type=type;
		this.atk=atk;
		this.consumeMp=consumeMp;
		this.skillDescription=skillDescription;
	}
	
	public OwnedSkill(
			String name,
			String type,
			int hpHeal,
			int spHeal,
			double consumeMp,
			String skillDescription)//회복
	{
		this.name=name;
		this.type=type;
		this.hpHeal=hpHeal;
		this.spHeal=spHeal;
		this.consumeMp=consumeMp;
		this.skillDescription=skillDescription;
	}
	
	public OwnedSkill[] skill = new OwnedSkill[4];
	
	
	OwnedSkill[] skillList() 
	{
		skill[0] = new OwnedSkill("혼신의 일격","물리",10,5,"혼신의 일격 : 무기 공격력*10의 물리데미지를 줍니다 소비 sp5");
		skill[4] = new OwnedSkill("결사의 일격","물리",30,10,"결사의 일격 : 무기 공격력*30의 물리데미지를 줍니다 소비 sp10");
		skill[1] = new OwnedSkill("힐","회복",100,0,1.0,"힐 : hp를 100회복합니다. 소비mp1");
		skill[2] = new OwnedSkill("매직미사일","마법",20,1.0,"매직미사일 : 20의 마법데미지를 줍니다. 소비mp 1");
		skill[3] = new OwnedSkill("메기도","마법",60,2.0,"메기도 : 60의 마법데미지를 줍니다. 소비mp2");
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
	public int getHpHeal()
	{
		return hpHeal;
	}	
	public String getSkillDescription()
	{
		return skillDescription;
	}
}
