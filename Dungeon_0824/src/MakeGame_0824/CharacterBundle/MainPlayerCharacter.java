package MakeGame_0824.CharacterBundle;

import java.util.Scanner;
import MakeGame_0824.ItemBase;
import MakeGame_0824.OwnedItem;
import MakeGame_0824.OwnedSkill;
import MakeGame_0824.Weapon;

public class MainPlayerCharacter extends CharacterBase
{	
	Weapon w = new Weapon(); //아이템 정보  임시 변수명 템들 정리할때 같이 수정할것
	OwnedItem[] OwnedItem = new OwnedItem[2];

	public MainPlayerCharacter()
	{
		super("주인공",
				new String[20],
				new OwnedSkill[20],
				new OwnedItem[2], //여기껴야하는데
				10,
				10,
				100,
				new int[]{1,1,1});
	}
	
	public void equip() //장착을 어떻게 할까?
	{
		System.out.println("어떤 아이템을 사용 할까요?");
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		
		//인벤토리에 있는지 확인 추가 필요
		
		if(temp.equals("낡은 활")) 
		{
			int weaponNumber = 0;
			ItemBase[] bow = w.bowDatabase();
			OwnedItem[0] = new OwnedItem(bow[weaponNumber].getItemName(),bow[weaponNumber].getWeaponType(),bow[weaponNumber].getWeaponAtk(),bow[weaponNumber].getPrice());
			setOwnedItem(OwnedItem);
			
		}
		else if(temp.equals("낡은 검"))
		{
			int weaponNumber = 0;
			ItemBase[] sword = w.swordDatabase();
			OwnedItem[0] = new OwnedItem(sword[weaponNumber].getItemName(),sword[weaponNumber].getWeaponType(),sword[weaponNumber].getWeaponAtk(),sword[weaponNumber].getPrice());
			setOwnedItem(OwnedItem);
		}

	}	
	//장비장착
}
