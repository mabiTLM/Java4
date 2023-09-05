package webClass230905;

public class Item {
	private String name;
	private boolean equipped;
	
	private int defense;
	private int attack;
	
	public Item(String name, int defense, int attack) {
		
		this.name=name;
		this.equipped=false;
		this.defense=defense;
		this.attack=attack;
	}
	
	public String getName() {
		return name;
	}
	public boolean isEquip() {
		return equipped;
	}
	
	public void equip() {
		equipped=true;
		System.out.println(name + "을 장착함");
	}
	public void unEquip() {
		equipped=false;
		System.out.println(name + "을 탈착함");
	}
	
	public int getDefense() {
		return defense;
	}
	public int getAttack() {
		return attack;
	}
}
