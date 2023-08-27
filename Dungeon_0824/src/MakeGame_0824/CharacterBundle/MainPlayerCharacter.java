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
								"낡은 지팡이"
						},
				new OwnedSkill[] 
						{
								new OwnedSkill("혼신의 일격","물리",10,1,"혼신의 일격 : 무기 공격력*10의 물리데미지를 줍니다"),
								new OwnedSkill("힐","회복",100,1,"힐 : hp를 100회복합니다"),
								new OwnedSkill("매직미사일","마법",20,1.0,"매직미사일 : 20의 마법데미지를 줍니다")
						},
				new OwnedItem[]
						{
								new OwnedItem("낡은 검","무기","검", 5, 1000,"낡은 검 : 무기, 검, 공격력 5, 가격 1000"),
								new OwnedItem("천 갑옷","갑옷", 3, 1000,"천 갑옷 : 방어력3 가격1000")
						}, //장착
				200,
				10,
				100,
				new double[]{1,2,1},//0.검,1.지팡이 2는 아직 더미
				1000
				); 
	}
		
	public void equip()//장비장착
	{
		System.out.println("어떤 아이템을 사용 할까요?");
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		int tempItemSlot=0;
		
		for(int i = 0; i<getInventory().length; i++)//인벤토리에서
		{
			if(getInventory()[i].equals(temp))//있으면 넘기고
			{
				setInventory("",i); //사용한 아이템은 장비창에서 제거한다
				tempItemSlot=i; //바뀐 슬롯 저장해두고
				break;
			}
			else if(i==getInventory().length-1) //없으면 더미로 바꾼다
			{
				temp = "그런 아이템은 없다.";
			}
		}//인벤토리에 있는지 확인
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
					setInventory(getOwnedItem()[0].getItemName(),tempItemSlot);//장착하고있던건 다시 인벤으로
					setOwnedItem(OwnedItem,0);
					break;
				}
				else if((totalItem[i].getItemType()).equals("갑옷"))
				{
					OwnedItem[] OwnedItem = new OwnedItem[2];
					OwnedItem[1] = totalItem[i];
					setInventory(getOwnedItem()[0].getItemName(),tempItemSlot);
					setOwnedItem(OwnedItem,1);
					break;
				}
				else if((totalItem[i].getItemType()).equals("회복"))
				{
					setHp(getHp()+totalItem[i].getHpHeal());
					setMp(getMp()+totalItem[i].getMpHeal());
					setSp(getSp()+totalItem[i].getSpHeal());
					System.out.println(totalItem[i].getItemName()+"을 사용했다.");
					break;
				}
				else
				{
					System.out.println("사용 할 수 있는 종류의 아이템이 아니야");
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
