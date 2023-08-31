package MakeGame_0824.CharacterBundle;

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
	private int enemyActType;

	public EnemyCharacter() {
		super();
	}
	
	public EnemyCharacter(
			String name,
			OwnedSkill[] OwnedSkill, //아직 스킬은 없지만 일단 넣어두자 혹시 사용한다면 적행동클래스를 따로만들어서 행동을 지정할것 
			String[] dropItem, //드랍 아이템
			int hp,
			int mp,//얘도 현재는 더미
			int sp,//얘도 현재는 더미
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
		this.sp=sp;
		this.atk=atk;
		this.def=def;
		this.dropMoney=dropMoney;
		this.dropPercent=dropPercent;
	}
	
	public EnemyCharacter[] enemyFirstFloor = new EnemyCharacter[7];
	
	public EnemyCharacter[] firstEnemyDatabase() //층마다 다를수 있으니까 나눠두자
	{
		enemyFirstFloor[0] = new EnemyCharacter(
				"슬라임",
				new OwnedSkill[0],
				new String[]{"슬라임 점액"},
				5,
				0,
				0,
				4,
				10,
				100,
				30);		
		enemyFirstFloor[1] = new EnemyCharacter(
				"슬라임",
				new OwnedSkill[0],
				new String[]{"슬라임 점액"},
				5,
				0,
				0,
				4,
				10,
				100,
				30);
		enemyFirstFloor[2] = new EnemyCharacter(
				"혼 래빗",
				new OwnedSkill[0],
				new String[]{"토끼 발"},
				15,
				0,
				0,
				4,
				0,
				100,
				30);
		enemyFirstFloor[3] = new EnemyCharacter(
				"혼 래빗",
				new OwnedSkill[0],
				new String[]{"토끼 발"},
				15,
				0,
				0,
				4,
				0,
				100,
				30);
		enemyFirstFloor[4] = new EnemyCharacter(
				"황금 슬라임",
				new OwnedSkill[0],
				new String[]{"황금 슬라임 점액"},
				20,
				0,
				0,
				10,
				100,
				1000,
				10);
		
		enemyFirstFloor[5] = new EnemyCharacter(
				"무장한 고블린",
				new OwnedSkill[0],
				new String[]{"평범한 검","가죽 갑옷"},
				50,
				0,
				0,
				20,
				20,
				1000,
				30);		
		enemyFirstFloor[6] = new EnemyCharacter(
				"미친 뿔사슴",
				new OwnedSkill[0],
				new String[]{"녹용"},
				500,
				0,
				0,
				50,
				50,
				10000,
				50);
		return enemyFirstFloor;
	}
	
	public EnemyCharacter[] enemySecondFloor = new EnemyCharacter[5];
	
	public EnemyCharacter[] secondEnemyDatabase() //층마다 다를수 있으니까 나눠두자
	{
		enemySecondFloor[0] = new EnemyCharacter(
				"미친 뿔사슴",
				new OwnedSkill[0],
				new String[]{"녹용"},
				1000,
				0,
				0,
				50,
				50,
				10000,
				50);
		enemySecondFloor[1] = new EnemyCharacter(
				"미친 뿔사슴",
				new OwnedSkill[0],
				new String[]{"녹용"},
				1000,
				0,
				0,
				50,
				50,
				10000,
				50);
		enemySecondFloor[2] = new EnemyCharacter(
				"무장한 고블린",
				new OwnedSkill[0],
				new String[]{"강철 검","철 갑옷"},
				200,
				0,
				0,
				50,
				50,
				5000,
				30);
		enemySecondFloor[3] = new EnemyCharacter(
				"무장한 고블린",
				new OwnedSkill[0],
				new String[]{"강철 검","철 갑옷"},
				200,
				0,
				0,
				50,
				50,
				5000,
				30);
		enemySecondFloor[4] = new EnemyCharacter(
				"황금 슬라임",
				new OwnedSkill[0],
				new String[]{"황금 슬라임 점액"},
				30,
				0,
				0,
				30,
				3000,
				20000,
				10);
//		enemySecondFloor[2] = new EnemyCharacter(
//				"고블린 주술사",
//				new OwnedSkill[0],
//				new String[]{""},
//				1000,
//				3,
//				0,
//				50,
//				50,
//				10000,
//				50);
		return enemySecondFloor;
	}
	
//	public EnemyCharacter[] secondEnemyDatabase() 복사용도
//	{
//		enemySecondFloor[0] = new EnemyCharacter(
//				"미친 뿔사슴",
//				new OwnedSkill[0],
//				new String[]{"녹용"},
//				1000,
//				0,
//				0,
//				50,
//				50,
//				10000,
//				50);
//		enemySecondFloor[1] = new EnemyCharacter(
//				"미친 뿔사슴",
//				new OwnedSkill[0],
//				new String[]{"녹용"},
//				1000,
//				0,
//				0,
//				50,
//				50,
//				10000,
//				50);
//		enemySecondFloor[2] = new EnemyCharacter(
//				"보팔 래빗",
//				new OwnedSkill[0],
//				new String[]{"행운의 토끼발"},
//				2000,
//				0,
//				0,
//				500,
//				500,
//				100000,
//				50);
//		return enemySecondFloor;
//	}
	
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
		return def;
	}
	
	public int getDropMoney()
	{
		return dropMoney;
	}
	
	public EnemyCharacter[] getEnemyFirstFloor() {
		return firstEnemyDatabase();
	}
	
	public double getDropPercent()
	{
		return dropPercent;
	}

}
