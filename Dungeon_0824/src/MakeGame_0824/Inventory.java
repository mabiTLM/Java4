package MakeGame_0824;

import java.util.Scanner;

import MakeGame_0824.CharacterBundle.MainPlayerCharacter;

public class Inventory
{
	Scanner scan= new Scanner(System.in);
	MainPlayerCharacter c;
	OwnedItem o = new OwnedItem();
	public void inventoryOpen(MainPlayerCharacter c)
	{
		String[] inven =c.getInventory();
		
		OwnedItem[] own = o.itemDatabase();
		
		for(int i = 0; i< inven.length; i++)
		{
			for(int j = 0; j< own.length; j++)
			{
				if(inven[i].equals(own[j].getItemName()))
				{
					System.out.println(own[j].getItemDescription());
					break;
				}
			}			
		}
		System.out.println();
		
		while(true)
		{
			System.out.println("1. 아이템 사용하기 2.돌아가기");
			String choice = scan.nextLine();
			
			while(true) 
			{
				if(choice.isEmpty()==false&choice.replaceAll("[0-9]","").isEmpty()) 
				{
					break;
				}
				else
				{
					System.out.println("숫자만 입력해주세요");
					choice = scan.nextLine();
				}
			}
			
			int temp = Integer.valueOf(choice);
			
			switch(temp)
			{
			case 1:
				c.equip();
				System.out.println();
				break;
			case 2:
				break;
			}
			
			break;
		}
	}
}
