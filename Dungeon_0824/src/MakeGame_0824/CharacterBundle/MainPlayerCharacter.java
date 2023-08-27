package MakeGame_0824.CharacterBundle;

import java.util.Scanner;
import MakeGame_0824.OwnedItem;
import MakeGame_0824.OwnedSkill;


public class MainPlayerCharacter extends CharacterBase
{
	//아이템 정보  임시 변수명 템들 정리할때 같이 수정할것

	public MainPlayerCharacter()
	{
		super("주인공",
				new String[] 
						{
								"낡은 지팡이",
								"강력한 검"
						},
				new OwnedSkill[] 
						{
								new OwnedSkill("혼신의 일격","물리",4,1,"혼신의 일격 : 무기 공격력*4의 데미지를 줍니다"),
								new OwnedSkill("힐","회복",100,1,"힐 : hp를 100회복합니다"),
								new OwnedSkill("파이어","마법",40,1.0,"파이어 : 40의 데미지를 줍니다")
						},
				new OwnedItem[]
						{
								new OwnedItem("낡은 검","무기","검", 5, 1000,"낡은 검 : 무기, 검, 공격력 5, 가격 1000"),
								new OwnedItem("천 갑옷","갑옷", 5, 1000,"천 갑옷 : 방어력5 가격1000")
						}, //장착
				300,
				10,
				10,
				new double[]{1,2,1}); //0.검,1.지팡이
	}
		
	public void equip()//장비장착
	{
		System.out.println("어떤 아이템을 사용 할까요?");
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		
		//인벤토리에 있는지 확인 추가 필요
		OwnedItem w = new OwnedItem();
		OwnedItem[] totalItem = w.itemDatabase();	
		
		for(int i = 0; i<totalItem.length; i++)
		{
			if(temp.equals(totalItem[i].getItemName()))
			{
				if((totalItem[i].getItemType()).equals("무기"))
				{
					OwnedItem[] OwnedItem = new OwnedItem[2];
					OwnedItem[0] = totalItem[i];
					setOwnedItem(OwnedItem);
					break;
				}
				if((totalItem[i].getItemType()).equals("갑옷"))
				{
					OwnedItem[] OwnedItem = new OwnedItem[2];
					OwnedItem[1] = totalItem[i];
					setOwnedItem(OwnedItem);
					break;
				}
				
			}
			else if(i==totalItem.length-1)
			{
				System.out.println("그런 아이템은 없다.");
			}
		}
	}
}
