package MakeGame_0824;

import java.util.Scanner;

import MakeGame_0824.CharacterBundle.MainPlayerCharacter;

public class Inventory
{
	Scanner scan= new Scanner(System.in);
	MainPlayerCharacter c = new MainPlayerCharacter();
	public void inventoryOpen()
	{
		String[] inven =c.getInventory();
		
		for(int i = 0; i< inven.length; i++)
		{
			System.out.print(inven[i] + "	");
			if((i+1)%6==0)
			{
				System.out.println();
			}
		}
		System.out.println();
		
		while(true)
		{
			System.out.println("1. 아이템 장비하기 2.소모품 사용하기 3.돌아가기");
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
				System.out.println("미구현");
				break;
			case 3:
				break;
			}
			
			break;
		}
	}
}
