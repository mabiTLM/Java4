package makeDetective_0830.characterBundle;

public class OwnedSkill //스킬이 있는 추리게임도 있으니까 일단 불러온다
{
	private String name;
	private String type;
	private String skillDescription;
	
	public OwnedSkill()
	{
		
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
	public String getSkillDescription()
	{
		return skillDescription;
	}
}
