package makeCardGame230901.village;

import java.util.Scanner;

import makeCardGame230901.characterBundle.PlayerCharacter;

public class MoveInVillage 
{
	private boolean locationVillage = true;
	int choice = 0;
	EditDeck editDeck = new EditDeck();
	Scanner scan = new Scanner(System.in);
	public void MoveVillage(PlayerCharacter player)
	{
		System.out.println("1.덱수정");
		System.out.println("2.상점");
		System.out.println("3.모험으로");
		choice=scan.nextInt();
		if(choice==1)
		{
			editDeck.edit(player);
		}
		else if(choice==2)
		{
			System.out.println("미구현");
		}
		else if(choice==3)
		{
			locationVillage=false;
		}
		
	}
	
	public boolean getLocationVillage()
	{
		return locationVillage;
	}
}
