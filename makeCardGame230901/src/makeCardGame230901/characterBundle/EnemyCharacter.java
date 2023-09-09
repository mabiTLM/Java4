package makeCardGame230901.characterBundle;

public class EnemyCharacter extends CharacterBase 
{

	private boolean enemyTurn = false;
	private int effectValue = 0;
	
	MONSTEREFFECT monstereffect;
	
	EnemyCharacter[] stageEnemy;
	public EnemyCharacter(){
	}
	
	EnemyCharacter(//mp가 없는 적
			String name,
			int maxHp,
			int hp,
			int atk,
			int def,
			int money,
			int speed,
			int aiPattern
			)
	{
		super(name,maxHp,0,hp,0,atk,def,money,speed,aiPattern);
	}
	
	EnemyCharacter(//mp가 있는 적
			String name,
			int maxHp,
			int maxMp,
			int hp,
			int mp,
			int atk,
			int def,
			int money,
			int speed,
			int aiPattern
			)
	{
		super(name,maxHp,maxMp,hp,mp,atk,def,money,speed,aiPattern);
	}
	
	EnemyCharacter(//부가효과가 있는 타입
			String name,
			int maxHp,
			int hp,
			int atk,
			int def,
			int money,
			int speed,
			int aiPattern,
			MONSTEREFFECT monstereffect,
			int effectValue
			)
	{
		super(name,maxHp,0,hp,0,atk,def,money,speed,aiPattern);
		this.effectValue=effectValue;
	}
	
	
	
	public EnemyCharacter[] firstStageData()
	{
		stageEnemy = new EnemyCharacter[3];
		stageEnemy[0] = new EnemyCharacter("슬라임",20,20,5,0,100,5,0);
		stageEnemy[1] = new EnemyCharacter("도적",20,20,5,0,100,11,1,MONSTEREFFECT.ATTACKUP,3);
		stageEnemy[2] = new EnemyCharacter("작은 골렘",50,50,20,20,100,4,2,MONSTEREFFECT.SHIELD,20);
		return stageEnemy;
	}
	
	public EnemyCharacter[] firstStageEliteData()
	{
		stageEnemy = new EnemyCharacter[2];
		stageEnemy[0] = new EnemyCharacter("골렘",100,100,100,50,1000,4,2,MONSTEREFFECT.SHIELD,50);
		stageEnemy[1] = new EnemyCharacter("상급 닌자",50,50,10,0,1000,20,1,MONSTEREFFECT.ATTACKUP,5);
		return stageEnemy;
	}
	public EnemyCharacter[] firstStageBossData()
	{
		stageEnemy = new EnemyCharacter[1];
		stageEnemy[0] = new EnemyCharacter("글라스기브넨",1000,0,1000,0,100,1000,100,10,3);
		return stageEnemy;
	}
	
	
	public void status() {
		System.out.println("체력 : "+getHp()+" 쉴드 : " + getDef() + " 공격력 : " +getAtk() + " 속도 : " + getSpeed());
	}

	public void setEnemyTurn(boolean enemyTurn)
	{
		this.enemyTurn=enemyTurn;
	}
	
	public boolean getEnemyTurn()
	{
		return enemyTurn;
	}
	public int getEffectValue()
	{
		return effectValue;
	}

}
