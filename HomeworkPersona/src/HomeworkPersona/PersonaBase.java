package HomeworkPersona;

public class PersonaBase 
{
	public PersonaSkillInfo PersonaSkillInfo = new PersonaSkillInfo();
	public String name;
	public String personaBookInfo;
	public int level;
	public int str;
	public int magic;
	public int def;
	public int speed;
	public int luck;
	public int exp;
	public int[] upstatus;

	public void levelup()//레벨당 자료가 없어서 임의 수치
	{
		level = level+1;
		str = str+upstatus[0];
		magic = magic +upstatus[1];
		def = def+upstatus[2];
		speed = speed +upstatus[3];
		luck = luck+upstatus[4];
	}
	
	public void getStatus() 
	{
		System.out.println("레벨" + level);
		System.out.println("힘"+str);
		System.out.println("마"+magic);
		System.out.println("방"+def);
		System.out.println("속"+speed);
		System.out.println("운"+luck);
	}
	
	public String arcana;
	public String[] weak;
	public String[] resist;
	public String[] changeItem;
	public String summonSpeech;
	public String[] specificity;
	public String[] nowSkill;
	public String[] canLearnSkillname;
	public String[] learnSkillInfo;
	public int[] canLearnSkillLevel;
	
	public PersonaBase(
			String name,
			String personaBookInfo,
			int level,
			int str,
			int magic,
			int def,
			int speed,
			int luck,
			int exp,
			int[] upstatus,
			String arcana,
			String[] weak,
			String[] resist,
			String[] changeItem,
			String summonSpeech,
			String[] specificity,
			String[] nowSkill,
			String[] canLearnSkillname,
			String[] learnSkillInfo,
			int[] canLearnSkillLevel
			)
	{
		this.name=name;                
		this.personaBookInfo=personaBookInfo;    
		this.level=level;                  
		this.str=str;                    
		this.magic=magic;                  
		this.def=def;                    
		this.speed=speed;                  
		this.luck=luck;                   
		this.exp=exp;                    
		this.upstatus=upstatus;             
		this.arcana=arcana;              
		this.weak=weak;              
		this.resist=resist;            
		this.changeItem=changeItem;        
		this.summonSpeech=summonSpeech;        
		this.specificity=specificity;       
		this.nowSkill=nowSkill;          
		this.canLearnSkillname=canLearnSkillname; 
		this.learnSkillInfo=learnSkillInfo;    
		this.canLearnSkillLevel=canLearnSkillLevel;
	}
}
			
			
			
			
			
			


