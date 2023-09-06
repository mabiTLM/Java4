package webClass230906;

import java.util.Random;

public class Unit {
	private String name;
	private int health;
	private int attackPower;
	public Unit(String name, int health, int attackPower)
	{
		this.name=name;
		this.health=health;
		this.attackPower=attackPower;
	}
	public String getName() {
		return name;
	}
	public int getHealth() {
		return health;
	}
	public int getAttackPower() {
		return attackPower;
	}
	public boolean isAlive() 
	{
		return health>0;
	}
	public int attack() {
		Random random = new Random();
		int damage=random.nextInt(attackPower)+1;
		return damage;
	}
	public void takeDamage(int damage)
	{
		health-=damage;
	}
}
