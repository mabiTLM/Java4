package makeDetective_0830.characterBundle;

public abstract class CharacterBase implements CharacterInterface
{
	private String name;
	private String[] inventory;//가진아이템
	private OwnedSkill[] OwnedSkill;//소지스킬? 단간론파같은건 있긴한데
	private OwnedItem[] OwnedItem;//사용할수 있는아이템
	private int hp=5; //추리가 틀리면 달게
	private int maxHp=5;
	private int money;
	
	CharacterBase()
	{
		
	}
	
	CharacterBase(
			String name,
			String[] inventory,
			OwnedSkill[] OwnedSkill,
			OwnedItem[] OwnedItem,
			int hp,
			int money
			)
	{//플레이어블 캐릭터
		this.name=name;
		this.inventory=inventory;
		this.OwnedSkill=OwnedSkill;
		this.OwnedItem=OwnedItem;
		this.hp=hp;
		this.money=money;
	}
	
	
	
	//set 모음
	public void setOwnedItem(OwnedItem[] OwnedItem)
	{
		this.OwnedItem=OwnedItem;
	}
	
	public void setOwnedItem(OwnedItem[] OwnedItem, int slot)
	{
		this.OwnedItem[slot]=OwnedItem[slot];
	}
	
	
	public void setOwnedSkill(OwnedSkill[] OwnedSkill)
	{
		this.OwnedSkill=OwnedSkill;
	}
	
	
	
	
	public void setMaxHp(int maxHp)
	{
		this.maxHp=maxHp;
	}
	
	public void setHp(int hp)
	{
		if(hp>getMaxHp())
		{
			hp=getMaxHp();
		}
		this.hp=hp;
	}
	
	public void setInventory(String[] inventory)
	{
		this.inventory=inventory;
	}
	public void setInventory(String inventory, int slot)
	{
		this.inventory[slot]=inventory;
	}
	
	public void setMoeny(int money)
	{
		if(money<0)
		{
			money=0;
		}
		this.money=money;
	}
	
	//get 모음
	public String getName() 
	{
		return name;
	}
	
	public OwnedSkill[] getOwnedSkill() 
	{
		return OwnedSkill;
	}
	
	public OwnedItem[] getOwnedItem() 
	{
		return OwnedItem;
	}
	
	public int getHp() 
	{
		return hp;
	}
	
	public int getMaxHp()
	{
		return maxHp;
	}
	
	public String[] getInventory()
	{
		return inventory;
	}
	
	public int getMoney()
	{
		return money;
	}

	@Override
	public void useItem() {
		// TODO Auto-generated method stub
		
	}
}
