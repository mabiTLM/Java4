package MakeGame_0824;

public class OwnedItem
{
	private String itemName;
	private String weaponType;
	private int weaponAtk;
	private int weaponDef;
	private int price;
	private String itemDescription;
	
	public OwnedItem()
	{
		
	}
	public OwnedItem(String itemName,String weaponType,int weaponAtk,int price, String itemDescription)//무기
	{
		this.itemName=itemName;
		this.weaponType=weaponType;
		this.weaponAtk=weaponAtk;
		this.price=price;
		this.itemDescription=itemDescription;
	}
	
	public OwnedItem(String itemName,int weaponDef, int price)//방어구
	{
		this.itemName=itemName;
		this.weaponDef=weaponDef;
		this.price=price;
	}
	
	OwnedItem[] sword = new OwnedItem[2];
	
	public OwnedItem[] swordDatabase()
	{		
		sword[0] = new OwnedItem("낡은 검", "검", 5, 1000,"낡은 검 : 공격력 5 가격 1000");
		sword[1] = new OwnedItem("강력한 검", "검", 100, 10000,"");
		return sword;
	}	
	
	OwnedItem[] bow = new OwnedItem[2];
	
	public OwnedItem[] bowDatabase()
	{		
		bow[0] = new OwnedItem("낡은 활", "검", 5, 1000,"낡은 활 : 공격력 5 가격 1000");
		bow[1] = new OwnedItem("보통 활", "검", 10, 10000,"");
		return bow;
	}
	
	OwnedItem[] armor = new OwnedItem[2];
	
	public OwnedItem[] armorDatabase()
	{		
		armor[0] = new OwnedItem("천갑옷", 5, 1000);
		armor[1] = new OwnedItem("가죽갑옷", 10, 10000);
		return armor;
	}
	
	
	//set 모음
	public void setItemName(String itemName)
	{
		this.itemName=itemName;
	}


	//get 모음
	
	public String getItemName()
	{
		return itemName;
	}
	
	public String getItemDescription()
	{
		return itemDescription;
	}
	
	public String getWeaponType()
	{
		return weaponType;
	}
	public int getWeaponAtk()
	{
		return weaponAtk;
	}
	public int getWeaponDef()
	{
		return weaponDef;
	}
	public int getPrice()
	{
		return price;
	}
}	

//		setItemName(itemName);
//		setWeaponType(weaponType);
//		setWeaponAtk(weaponAtk);
//		setPrice(price);
	
	

