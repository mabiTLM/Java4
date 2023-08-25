package MakeGame_0824;//

public class OwnedItem //extends ItemBase //상속을 받는게 문제 같기도하다. 총 아이템중 가진 아이템만 장착하려했는데 오류가 자주 발생하는듯
{
	private String itemName;
	private String weaponType;
	private int weaponAtk;
	private int weaponDef;
	private int price;
		
	public OwnedItem()
	{
		
	}
	public OwnedItem(String itemName,String weaponType,int weaponAtk,int price)//무기
	{
		this.itemName=itemName;
		this.weaponType=weaponType;
		this.weaponAtk=weaponAtk;
		this.price=price;
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
		sword[0] = new OwnedItem("낡은 검", "검", 5, 1000);
		sword[1] = new OwnedItem("보통 검", "검", 10, 10000);
		return sword;
	}	
	
	OwnedItem[] bow = new OwnedItem[2];
	
	public OwnedItem[] bowDatabase()
	{		
		sword[0] = new OwnedItem("낡은 활", "검", 5, 1000);
		sword[1] = new OwnedItem("보통 활", "검", 10, 10000);
		return sword;
	}
	
	OwnedItem[] armor = new OwnedItem[2];
	
	public OwnedItem[] armorDatabase()
	{		
		sword[0] = new OwnedItem("천갑옷", 5, 1000);
		sword[1] = new OwnedItem("가죽갑옷", 10, 10000);
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
	
	

