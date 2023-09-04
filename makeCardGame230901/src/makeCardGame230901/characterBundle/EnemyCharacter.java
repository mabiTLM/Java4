package makeCardGame230901.characterBundle;

public class EnemyCharacter extends CharacterBase 
{

	private boolean enemyTurn = false;
	
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
			int speed
			)
	{
		super(name,maxHp,maxMp,hp,mp,atk,def,money,speed);
	}
	
	EnemyCharacter[] stageEnemy = new EnemyCharacter[3];
	
	public EnemyCharacter[] firstStageData()
	{
		stageEnemy[0] = new EnemyCharacter("슬라임",20,0,20,0,5,0,100,10);
		stageEnemy[1] = new EnemyCharacter("도적",20,0,20,0,5,0,100,30);
		stageEnemy[2] = new EnemyCharacter("골렘",50,0,100,0,50,50,100,4);
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
