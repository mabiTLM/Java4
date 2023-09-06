package webClass230906;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

enum STATE{
	ATTACK,
	USE_ITEM,
	RUN
}

public class Player extends Unit {
	
	public Player(String name, int health, int attackPower) {
		super(name, health, attackPower);
		
		randomItems();
	}
	
	private LinkedList<Item> inventory= new LinkedList<>();
	private int attackPowerModifier = 0;
	private String[] itemNames = {
			"검","방패","물약","고대 마법서","절대반지"
	};
	private Scanner scan = new Scanner(System.in);
	
	//아이템 랜덤생성
	private void randomItems()
	{
		Random random=new Random();
		//1~3
		int numItem=random.nextInt(3)+1;
		
		//랜덤한 아이템 이름이랑 공격력
		for(int i =0; i<numItem; i++)
		{
			//미리 정의한 아이템 이름중에 하나
			String itemName=itemNames[random.nextInt(itemNames.length)];
			int itemPower=random.nextInt(10)+1;//랜덤한 공격력
			Item item = new Item(itemName, itemPower);
			inventory.add(item);
		}
	}
	public STATE selectAction() {
		System.out.println("1.공격");
		System.out.println("2.아이템 사용");
		System.out.println("3.도망");
		System.out.println("선택해라 : ");
		
		int select = scan.nextInt();
		
		switch(select)
		{
		case 1:
			return STATE.ATTACK;
		case 2:
			return STATE.USE_ITEM;
		case 3:
			return STATE.RUN;
		default:
			return null;
		}
	}
	
	public void addItem(Item item)
	{
		inventory.add(item);
		
		System.out.println(getName()+"가 "+item.getName()+"을 획득함");
	}
	public void useItem()
	{
		System.out.println("사용할 아이템을 선택해라!");
		int index=1;
		for(Item item:inventory)
		{
			System.out.println(index+". "+item.getName());
			index++;
		}
		int choice=scan.nextInt();
		if(choice>=1 && choice<=inventory.size())
		{
			Item selected=inventory.get(choice-1);
			
			System.out.println(getName()+"가"+selected.getName()+"을 사용했다. 공격력이 "+selected.getPower()+"증가");
			increaseAttackPower(selected.getPower());
			inventory.remove(selected);
		}
		else
		{
			System.out.println("잘못된 선택");
		}
	}
	
	public void increaseAttackPower(int power)
	{
		attackPowerModifier+=power;
	}
	
	@Override
	public int attack()
	{
		return super.attack()+attackPowerModifier;
	}

}
