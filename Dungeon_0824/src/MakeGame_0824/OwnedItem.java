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
	private double medicine;
	
	public OwnedItem()
	{
		
	}
	public OwnedItem(
			String itemName,
			String itemType,
			String weaponType,
			int weaponAtk,
			int price,
			String itemDescription)
	{//무기
		this.itemName=itemName;
		this.weaponType=weaponType;
		this.itemType=itemType;
		this.weaponAtk=weaponAtk;
		this.price=price;
		this.itemDescription=itemDescription;
	}
	
	public OwnedItem(
			String itemName,
			String itemType,
			int weaponDef,
			int price,
			String itemDescription)
	{//방어구
		this.itemName=itemName;
		this.itemType=itemType;
		this.weaponDef=weaponDef;
		this.price=price;
		this.itemDescription=itemDescription;
	}
	
	public OwnedItem(
			String itemName,
			String itemType,
			int hpHeal,
			int mpHeal,
			int spHeal,
			int price,
			String itemDescription)
	{//회복 아이템
		this.itemName=itemName;
		this.itemType=itemType;
		this.hpHeal=hpHeal;
		this.mpHeal=mpHeal;
		this.spHeal=spHeal;
		this.price=price;
		this.itemDescription=itemDescription;
	}
	
	public OwnedItem(
			String itemName,
			String itemType,
			int price,
			String itemDescription)
	{//판매전용 사용불가 아이템
		this.itemName=itemName;
		this.itemType=itemType;
		this.price=price;
		this.itemDescription=itemDescription;
	}
	
	public OwnedItem(
			String itemName,
			String itemType,
			double medicine,
			int price,
			String itemDescription)
	{//이벤트 아이템
		this.itemName=itemName;
		this.itemType=itemType;
		this.medicine=medicine;
		this.price=price;
		this.itemDescription=itemDescription;
	}
	
	OwnedItem[] totalItem = new OwnedItem[30];
	
	public OwnedItem[] itemDatabase()//모든 아이템목록
	{
		for(int i = 0; i <totalItem.length;i++)
		{
			totalItem[i] = new OwnedItem();//null오류 방지는 가능하지만 그만큼 실행이 많이됩니다.
		}
		
		totalItem[0] = new OwnedItem("완치약","이벤트",36500.0,1000000,"완치약 : 이 약만 있으면...");
		totalItem[1] = new OwnedItem("연명약","이벤트",30.0,10000,"연명약 : 기간을 늘려준다");
		
		totalItem[2] = new OwnedItem("작은 hp포션","회복",50,0,0,100,"작은 hp포션 : 생명력을 50회복한다");
		totalItem[3] = new OwnedItem("작은 mp포션","회복",0,1,0,100,"작은 mp포션 : 마나를 1회복한다");
		totalItem[4] = new OwnedItem("작은 sp포션","회복",0,0,5,100,"작은 sp포션 : 스태미나를 5회복한다");				
				
		totalItem[5] = new OwnedItem("낡은 검","무기","검", 5, 1000,"낡은 검 : 무기, 검, 공격력 5, 가격 1000");
		totalItem[6] = new OwnedItem("낡은 지팡이","무기","지팡이", 2, 1000,"낡은 지팡이 : 무기, 지팡이, 공격력 2, 가격 1000");
		totalItem[7]= new OwnedItem("천 갑옷","갑옷", 3, 1000,"천 갑옷 : 방어구, 방어력3, 가격1000");
		
		totalItem[8] = new OwnedItem("평범한 검","무기","검", 10, 5000,"평범한 검 : 무기, 검, 공격력10 가격 5000");
		totalItem[9] = new OwnedItem("평범한 지팡이","무기","지팡이", 3, 5000,"평범한 지팡이 : 공격력3 가격 5000");
		totalItem[10] = new OwnedItem("가죽 갑옷","갑옷",5, 5000,"가죽 갑옷 : 방어구, 방어력5 가격5000");
		
		totalItem[11] = new OwnedItem("강철 검","무기","검", 50, 10000,"강철 검 : 무기, 검, 공격력 50, 가격 10000");
		totalItem[12] = new OwnedItem("마력의 지팡이","무기","지팡이", 5, 10000,"마력의 지팡이 : 무기, 지팡이, 공격력 5, 가격 10000");
		totalItem[13] = new OwnedItem("철 갑옷","갑옷",10, 10000,"철 갑옷 : 방어구, 방어력10 가격 10000");
		
		totalItem[14] = new OwnedItem("슬라임 점액","판매전용",100, "슬라임 점액 : 판매전용 가격 100");
		totalItem[15] = new OwnedItem("황금 슬라임 점액","판매전용",1000, "황금 슬라임 점액 : 판매전용 가격 1000");
		totalItem[15] = new OwnedItem("녹용","판매전용",50000, "녹용 : 판매전용 가격 50000");

		return totalItem;
	}
	OwnedItem[] buyItem = new OwnedItem[14];
	
	public OwnedItem[] buyItemDatabase()//상점 아이템목록
	{	
		buyItem[0] = new OwnedItem("완치약","이벤트",36500.0,1000000,"완치약 : 이 약만 있으면... 가격 1000000");
		buyItem[1] = new OwnedItem("연명약","이벤트",30.0,10000,"연명약 : 기간을 늘려준다 가격 10000");
		
		buyItem[2] = new OwnedItem("작은 hp포션","회복",50,0,0,100,"작은 hp포션 : 생명력을 50회복한다 가격 100");
		buyItem[3] = new OwnedItem("작은 mp포션","회복",0,1,0,100,"작은 mp포션 : 마나를 1회복한다 가격 100");
		buyItem[4] = new OwnedItem("작은 sp포션","회복",0,0,5,100,"작은 sp포션 : 스태미나를 5회복한다 가격 100");				
				
		buyItem[5] = new OwnedItem("낡은 검","무기","검", 5, 1000,"낡은 검 : 무기, 검, 공격력 5, 가격 1000");
		buyItem[6] = new OwnedItem("낡은 지팡이","무기","지팡이", 2, 1000,"낡은 지팡이 : 무기, 지팡이, 공격력 2, 가격 1000");
		buyItem[7]= new OwnedItem("천 갑옷","갑옷", 3, 1000,"천 갑옷 : 방어구, 방어력3, 가격1000");
		
		buyItem[8] = new OwnedItem("평범한 검","무기","검", 10, 5000,"평범한 검 : 무기, 검, 공격력10 가격 5000");
		buyItem[9] = new OwnedItem("평범한 지팡이","무기","지팡이", 3, 5000,"평범한 지팡이 : 공격력3 가격 5000");
		buyItem[10] = new OwnedItem("가죽 갑옷","갑옷",5, 5000,"가죽 갑옷 : 방어구, 방어력5 가격5000");
		
		buyItem[11] = new OwnedItem("강철 검","무기","검", 50, 10000,"강철 검 : 무기, 검, 공격력 50, 가격10000");
		buyItem[12] = new OwnedItem("마력의 지팡이","무기","지팡이", 5, 10000,"마력의 지팡이 : 무기, 지팡이, 공격력 5, 가격10000");
		buyItem[13] = new OwnedItem("철 갑옷","갑옷",10, 10000,"철 갑옷 : 방어구, 방어력10 가격10000");

		return buyItem;
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
	
	public int getHpHeal()
	{
		return hpHeal;
	}
	public int getMpHeal()
	{
		return mpHeal;
	}
	public int getSpHeal()
	{
		return spHeal;
	}
	
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
	public double getMedicine()
	{
		return medicine;
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
	
	

