package makeCardGame230901.battleBundle.enemyActBunble;

import makeCardGame230901.battleBundle.Battle;
import makeCardGame230901.cardBundle.cardSortBundle.SortCard;
import makeCardGame230901.characterBundle.EnemyCharacter;
import makeCardGame230901.characterBundle.PlayerCharacter;

public class EnemyBattleAct
{
	PlayerCharacter player;
	private EnemyCharacter actEnemy;
	protected Battle battle;
	private SortCard sortCard = new SortCard();
	public EnemyBattleAct(PlayerCharacter player,Battle battle) {
		this.player=player;
		this.battle=battle;
	}
	
	protected void plainAttack(int actMonsterNumber)
	{
		int tempDamage = 0;
		actEnemy = battle.getCurrentEnemy()[actMonsterNumber];
		player.setDef(player.getDef()-actEnemy.getAtk()); //공격만큼 실드제거
		
		if(player.getDef()-actEnemy.getAtk()<0)//실드가 음수로가면
		{
			tempDamage = (int)Math.abs(player.getDef());//음수간만큼 데미지 올리기
			player.setDef(0);//0으로바꾸기
		}
		
		player.setHp(player.getHp()-tempDamage);
		System.out.println(actEnemy.getName()+"의 공격 : " + actEnemy.getAtk());
	}
	
	protected void defUp(int actMonsterNumber)
	{
		actEnemy = battle.getCurrentEnemy()[actMonsterNumber];
		actEnemy.setDef(actEnemy.getDef()+actEnemy.getEffectValue());
		System.out.println(actEnemy.getName()+"가 실드를 충전했다.");
	}
	
	protected void speedUp(int actMonsterNumber)
	{
		actEnemy = battle.getCurrentEnemy()[actMonsterNumber];
	}
	
	protected void atkUp(int actMonsterNumber)
	{
		actEnemy = battle.getCurrentEnemy()[actMonsterNumber];
		actEnemy.setAtk(actEnemy.getAtk()+actEnemy.getEffectValue());
		System.out.println(actEnemy.getName()+"의 공격력이 올랐다.");
	}
	
	protected void healing(int actMonsterNumber)
	{
		actEnemy = battle.getCurrentEnemy()[actMonsterNumber];
		for(int i = 0; i <battle.getCurrentEnemy().length;i++)
		{
			battle.getCurrentEnemy()[i].setHp(battle.getCurrentEnemy()[i].getHp()+actEnemy.getEffectValue());
		}
		System.out.println(actEnemy.getName()+"가 힐을 사용했다.");
	}
}
