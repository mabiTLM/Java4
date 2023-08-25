package MakeGame_0824;

public class Weapon extends ItemBase //아이템 목록들
{
	ItemBase[] weapon = new ItemBase[2];
	
	public ItemBase[] swordDatabase() 
	{		
		weapon[0] = new ItemBase("낡은 검", "검", 5, 1000);
		weapon[1] = new ItemBase("보통 검", "검", 10, 10000);
		return weapon;
	}
	
	
	public ItemBase[] bowDatabase() 
	{
		weapon[0] = new ItemBase("낡은 활", "활", 5, 1000);
		weapon[1] = new ItemBase("보통 활", "활", 12, 10000);
		return weapon;
	}
	
}


