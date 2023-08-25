package MakeGame_0824.CharacterBundle;

import MakeGame_0824.OwnedItem;
import MakeGame_0824.OwnedSkill;

public class EnemyCharacter extends CharacterBase 
{
	
	private String name;
	private String[] inventory;//가진아이템
	private OwnedSkill[] OwnedSkill;//소지스킬
	private int hp;
	private int mp;
	private int sp;
	private int atk;
	private int def;

	public EnemyCharacter() {
		super("적", new OwnedSkill[20],new OwnedItem[2], 5, 5, 10, 5, 5);
	}
	
	public EnemyCharacter(String name,OwnedSkill[] OwnedSkill,OwnedItem[] OwnedItem,int hp,int mp,int sp, int atk, int def)
	{
		this.name=name;
		this.OwnedSkill=OwnedSkill;
		this.OwnedItem=OwnedItem;
		this.hp=hp;
		this.mp=mp;
		this.atk=atk;
		this.def=def;
	}
	
	EnemyCharacter[] enemy = {
			new EnemyCharacter("도적", new OwnedSkill[20],new OwnedItem[2], 5, 5, 10, 5, 5),
			new EnemyCharacter("미친 뿔사슴", new OwnedSkill[20],new OwnedItem[2], 50, 50, 100, 50, 50)
			};
	
	public EnemyCharacter[] getEnemyCharacter() {
		return enemy;
	}

}
