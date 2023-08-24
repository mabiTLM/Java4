package MakeGame_0824;//

public class OwnedItem //extends ItemBase //상속을 받는게 문제 같기도하다. 총 아이템중 가진 아이템만 장착하려했는데 오류가 자주 발생하는듯
{
	private String itemName;
	private String weaponType;
	private int weaponAtk;
	private int weaponDef;
	private int price;
		
	OwnedItem()
	{
		
	}
	OwnedItem(String itemName,String weaponType,int weaponAtk,int price)//무기
	{
		this.itemName=itemName;
		this.weaponType=weaponType;
		this.weaponAtk=weaponAtk;
		this.price=price;
	}
	
	void setItemName(String itemName)
	{
		this.itemName=itemName;
	}
	
	String getItemName()
	{
		return itemName;
	}
}	

//		setItemName(itemName);
//		setWeaponType(weaponType);
//		setWeaponAtk(weaponAtk);
//		setPrice(price);
	
	

