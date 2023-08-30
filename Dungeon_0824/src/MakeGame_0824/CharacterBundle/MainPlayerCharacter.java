package MakeGame_0824.CharacterBundle;

import java.util.Scanner;

import MakeGame_0824.MapBundle.Dungeon.DungeonMap;


public class MainPlayerCharacter extends CharacterBase
{
	//아이템 정보  임시 변수명 템들 정리할때 같이 수정할것

	DungeonMap dungeonMap;
	
	public MainPlayerCharacter()
	{
		super("주인공",
				new String[] 
						{"던전탈출로프","도시락"
						},
				new OwnedSkill[] 
						{
								new OwnedSkill("힐","회복",100,0,1.0,"힐 : hp를 100회복합니다. 소비mp1")
						},
				new OwnedItem[]
						{
								new OwnedItem("맨손","무기","주먹", 1, 0,"맨손 : 공격력 1"),
								new OwnedItem("거적대기","갑옷", 1, 0,"거적대기 : 방어구, 방어력1, 가격0")
						}, //장착
				200,
				10,
				100,
				new double[]{1.0,1.0,1.0},//0.검,1.지팡이 2는 아직 더미
				1000
				); 
	}
		
	public void equip(DungeonMap dungeonMap)//아이템사용
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
				else if((totalItem[i].getItemType()).equals("이동"))
				{
					dungeonMap.setFloor(0);
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
