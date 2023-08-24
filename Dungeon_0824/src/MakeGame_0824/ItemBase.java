package MakeGame_0824;

public class ItemBase
{
	private String itemName;
	private String weaponType;
	private int weaponAtk;
	private int weaponDef;
	private int hpHeal;
	private int mpHeal;
	private int spHeal;
	private int price;
	
	ItemBase()
	{
		
	}
	
	ItemBase(String itemName,String weaponType,int weaponAtk,int price)//무기
	{
		this.itemName=itemName;
		this.weaponType=weaponType;
		this.weaponAtk=weaponAtk;
		this.price=price;
		
	}
	
	ItemBase(String itemName,int weaponDef,int price)//방어구
	{
		this.itemName=itemName;
		this.weaponDef=weaponDef;
		this.price=price;
	}
	
	ItemBase(String itemName,int hpHeal,int mpHeal,int spHeal,int price)//소모품
	{
		this.itemName=itemName;
		this.hpHeal=hpHeal;
		this.mpHeal=mpHeal;
		this.spHeal=spHeal;
		this.price=price;
		
	}
	
	ItemBase(String itemName,int price)//판매전용
	{
		this.itemName=itemName;
		this.price=price;
	}
	
	
	//get 모음
	int getWeaponAtk() {
		return weaponAtk;
	}
	
	String getItemName()
	{
		return itemName;
	}
	
	
	
	
	
	//참조 숙련도
}
