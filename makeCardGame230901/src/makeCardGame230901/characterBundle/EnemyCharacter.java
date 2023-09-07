package makeCardGame230901.characterBundle;

public class EnemyCharacter extends CharacterBase 
{

	private boolean enemyTurn = false;
	EnemyCharacter[] stageEnemy;
	public EnemyCharacter(){
	}
	
	EnemyCharacter(
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
	
	
	
	public EnemyCharacter[] firstStageData()
	{
		stageEnemy = new EnemyCharacter[3];
		stageEnemy[0] = new EnemyCharacter("슬라임",20,0,20,0,5,0,100,5,0);
		stageEnemy[1] = new EnemyCharacter("도적",20,0,20,0,5,0,100,11,1);
		stageEnemy[2] = new EnemyCharacter("작은 골렘",50,0,50,0,20,20,100,4,2);
		return stageEnemy;
	}
	
	public EnemyCharacter[] firstStageEliteData()
	{
		stageEnemy = new EnemyCharacter[2];
		stageEnemy[0] = new EnemyCharacter("골렘",100,0,100,0,100,100,1000,4,2);
		stageEnemy[1] = new EnemyCharacter("상급 닌자",50,0,50,0,10,0,1000,20,1);
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

}
