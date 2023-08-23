package Maple;

public class Characters 
{
	public String gender;
	public String kind;
	public String[][] voice;
	public String [] job;
	public String[] waepon;
	public String[] subWaepon;
	public String mainStatus;
	public String[] subStatus;
	public String[] jobList;
	public String[][] globalWriting;
	public double waeponRate;
	public int attackSpeed;
	public double workmanwhip;
	public String property;
	public double subAttack;
	public int defense;
	public int tolerance;
	public double allTolerance;
	public int evasion;
	public int stance;
	public boolean isStance;
	public boolean isMagicGuard;
	public int damageReduction;
	public int damageAbsorption;
	public double damageRateReduction;
	public boolean isGuard;
	public int criticalRate;
	public double movingSpeed;
	public double maxMovingSpeed;
	public double jumpingPower;
	
	public Characters(String gender,String kind,String[][] voice, String [] job, String[] waepon, String[] subWaepon, String mainStatus, String[] subStatus,String[] jobList,String[][] globalWriting,double waeponRate,int attackSpeed,double workmanwhip,String property,double subAttack,int defense,int tolerance,double allTolerance,int evasion,int stance,boolean isStance,boolean isMagicGuard,int damageReduction,int damageAbsorption,double damageRateReduction,boolean isGuard,int criticalRate,double movingSpeed,double maxMovingSpeed,double jumpingPower)
	{
		this.gender=gender;
		this.kind=kind;
		this.voice=voice;
		this.job=job;
		this.waepon=waepon;
		this.subWaepon=subWaepon;
		this.mainStatus=mainStatus;
		this.subStatus=subStatus;
		this.jobList=jobList;
		this.globalWriting=globalWriting;
		this.waeponRate=waeponRate;
		this.attackSpeed=attackSpeed;
		this.workmanwhip=workmanwhip;
		this.property=property;
		this.subAttack=subAttack;
		this.defense=defense;
		this.tolerance=tolerance;
		this.allTolerance=allTolerance;
		this.evasion=evasion;
		this.stance=stance;
		this.isStance=isStance;
		this.isMagicGuard=isMagicGuard;
		this.damageReduction=damageReduction;
		this.damageAbsorption=damageAbsorption;
		this.damageRateReduction=damageRateReduction;
		this.isGuard=isGuard;
		this.criticalRate=criticalRate;
		this.movingSpeed=movingSpeed;
		this.maxMovingSpeed=maxMovingSpeed;
		this.jumpingPower=jumpingPower;
	}
}
