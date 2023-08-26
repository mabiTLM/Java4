package MakeGame_0824.CharacterBundle;

import java.util.Scanner;
import MakeGame_0824.OwnedItem;
import MakeGame_0824.OwnedSkill;


public class MainPlayerCharacter extends CharacterBase
{
	OwnedItem w = new OwnedItem(); //아이템 정보  임시 변수명 템들 정리할때 같이 수정할것
	OwnedItem[] OwnedItem = new OwnedItem[2];	

	public MainPlayerCharacter()
	{
		super("주인공",
				new String[] 
						{
								"낡은 검",
								"강력한 검"
						},
				new OwnedSkill[] 
						{
								new OwnedSkill("혼신의 일격","물리",100,1),
								new OwnedSkill("힐","회복",100.0,1.0)
						},
				new OwnedItem[]
						{
								new OwnedItem("맨손","근거리",2,0,"맨손 : 공격력 2"),
								new OwnedItem("옷",2,0)
								}, //장착
				300,
				10,
				10,
				new int[]{1,1,1});
	}
	
	public void PickUpDropItemp(String dropitem) //장비줍기
	{
		String[] inven = new String[getInventory().length+1];
		for(int i = 0; i<inven.length ;i++)
		{
			if(inven[i].isEmpty())
			{
				inven[i]=dropitem;
			}
		}
		setInventory(inven);
	}
		
	public void equip()//장비장착
	{
		System.out.println("어떤 아이템을 사용 할까요?");
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		
		//인벤토리에 있는지 확인 추가 필요
		
		if(temp.equals("낡은 활")) 
		{
			int weaponNumber = 0;
			OwnedItem[] bow = w.bowDatabase();
			OwnedItem[0] = bow[weaponNumber];
			setOwnedItem(OwnedItem);
		}
		
		else if(temp.equals("낡은 검"))
		{
			int weaponNumber = 0;
			OwnedItem[] sword = w.swordDatabase();
			OwnedItem[0] = sword[weaponNumber];
			setOwnedItem(OwnedItem);
		}
		
		else if(temp.equals("강력한 검"))
		{
			int weaponNumber = 1;
			OwnedItem[] sword = w.swordDatabase();
			OwnedItem[0] = sword[weaponNumber];
			setOwnedItem(OwnedItem);
		}
		
		else if(temp.equals("천 옷"))
		{
			int weaponNumber = 0;
			OwnedItem[] armor = w.armorDatabase();
			OwnedItem[1] = armor[weaponNumber];
			setOwnedItem(OwnedItem);
		}
	}
	
	
}
