package MakeGame_0824;

public class OwnedItem
{
	private String itemName;
	private String itemType;
	private String weaponType;	
	private int weaponAtk;
	private int weaponDef;
	private int hpHeal;
	private int mpHeal;
	private int spHeal;
	private int price;
	private String itemDescription;
	
	public OwnedItem()
	{
		
	}
	public OwnedItem(
			String itemName,
			String itemType,
			String weaponType,
			int weaponAtk,
			int price,
			String itemDescription)//무기
	{
		this.itemName=itemName;
		this.weaponType=weaponType;
		this.itemType=itemType;
		this.weaponAtk=weaponAtk;
		this.price=price;
		this.itemDescription=itemDescription;
	}
	
	public OwnedItem(String itemName,String itemType, int weaponDef, int price)//방어구
	{
		this.itemName=itemName;
		this.itemType=itemType;
		this.weaponDef=weaponDef;
		this.price=price;
	}
	
	
	OwnedItem[] totalItem = new OwnedItem[6];
	
	public OwnedItem[] itemDatabase()
	{		
		totalItem[0] = new OwnedItem("낡은 검","무기","검", 5, 1000,"낡은 검 : 무기, 검, 공격력 5, 가격 1000");
		totalItem[1] = new OwnedItem("강력한 검","무기","검", 100, 10000,"강력한 검 : 무기, 검, 공격력 100, 가격1000");		
		totalItem[2] = new OwnedItem("낡은 지팡이","무기","지팡이", 3, 1000,"낡은 지팡이 : 공격력 3 가격 1000");
		totalItem[3] = new OwnedItem("보통 지팡이","무기","지팡이", 10, 10000,"");		
		totalItem[4] = new OwnedItem("천갑옷","갑옷", 5, 1000);
		totalItem[5] = new OwnedItem("가죽갑옷","갑옷",10, 10000);
		return totalItem;
	}	
		
	//set 모음
	public void setItemName(String itemName)
	{
		this.itemName=itemName;
	}	
	public void setWeaponType(String weaponType)
	{
		this.weaponType=weaponType;
	}
	public void setWeaponAtk(int weaponAtk)
	{
		this.weaponAtk=weaponAtk;
	}
	
	public void setPrice(int price)
	{
		this.price=price;
	}


	//get 모음
	
	public String getItemName()
	{
		return itemName;
	}
	
	public String getItemType()
	{
		return itemType;
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
	
	public OwnedItem[] getOwnedItem()
	{
		return totalItem;
	}
}	

//		setItemName(itemName);
//		setWeaponType(weaponType);
//		setWeaponAtk(weaponAtk);
//		setPrice(price);
	
	

