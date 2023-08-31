package makeDetective_0830.characterBundle;

public class OwnedItem
{
	private String itemName;
	private String itemType;
	private String itemDescription;
	
	public OwnedItem()
	{
		
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
	
	public String getItemType()
	{
		return itemType;
	}
	
	public String getItemDescription()
	{
		return itemDescription;
	}
}

