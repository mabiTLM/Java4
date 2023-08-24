package MakeGame_0824;

import java.util.Scanner;

public class MainPlayerCharacter extends CharacterBase
{	
	Weapon w = new Weapon(); //아이템 정보
	OwnedItem[] OwnedItem = new OwnedItem[2];

	MainPlayerCharacter()
	{
		super("주인공",
				new String[20],
				new String[20],
				new OwnedItem[2], //여기껴야하는데
				10,
				10,
				100,
				new int[]{1,1,1});
	}
	
	void equip() //장착을 어떻게 할까?
	{
		System.out.println("어떤 아이템을 사용 할까요?");
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		
		//인벤토리에 있는지 확인 추가 필요
		
		if(temp.equals("낡은 활")) 
		{
			ItemBase[] bow = w.bowDatabase();
			OwnedItem[0] = new OwnedItem(bow[0].getItemName(),bow[0].getWeaponType(),bow[0].getWeaponAtk(),bow[0].getPrice());
			setOwnedItem(OwnedItem);
			
		}
		else if(temp.equals("낡은 검"))
		{
			ItemBase[] sword = w.swordDatabase();
			OwnedItem[0] = new OwnedItem(sword[0].getItemName(),sword[0].getWeaponType(),sword[0].getWeaponAtk(),sword[0].getPrice());
			setOwnedItem(OwnedItem);
		}

	}	
	//장비장착
}
