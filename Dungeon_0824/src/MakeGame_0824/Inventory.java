package MakeGame_0824;

import java.util.Scanner;

import MakeGame_0824.CharacterBundle.MainPlayerCharacter;
import MakeGame_0824.StoryBundle.StoryText;

public class Inventory
{
	Scanner scan= new Scanner(System.in);
	MainPlayerCharacter mainChar;
	StoryText storyT;
	
	public Inventory(MainPlayerCharacter mainChar)
	{
		this.mainChar=mainChar;
	}	
	OwnedItem o = new OwnedItem();	
	
	
	
	
	public void inventoryOpen(MainPlayerCharacter mainChar)
	{
		String[] inven =mainChar.getInventory();
		
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
				mainChar.equip();
				System.out.println();
				break;
			case 2:
				break;
			}
			
			break;
		}
	}
	
	public void buyItem(MainPlayerCharacter mainChar, StoryText storyT)
	{
		int storyDummy = 7+storyT.getCurrentDay(); //이부분이 갱신이 안된다
		OwnedItem[] own = o.buyItemDatabase();
		if(storyDummy>=own.length)
		{
			storyDummy=own.length-1;
		}
		
		System.out.println("좋은 물건이 아주 많아");
		for(int i = 0; i < storyDummy; i++)
		{
			System.out.println(own[i].getItemDescription());
		}
		System.out.println();
		while(true)
		{
			String tempBuyDbItem = "그런 아이템은 없어";
			int tempBuyDbNumber = -1;
			
			System.out.println("어떤 물건을 구매할까요? 0.뒤로가기");
			String tempBuyChoice=scan.nextLine();
			
			if(tempBuyChoice.equals("0")|tempBuyChoice.equals("뒤로가기"))
			{
				break;
			}
			
			for(int i = 0; i < storyDummy; i++) // 아이템이 목록에 있는지부터 체크
			{
				if(tempBuyChoice.equals(own[i].getItemName()))
				{
					tempBuyDbItem=tempBuyChoice;
					tempBuyDbNumber=i;
					break;
				}
			}
			if(tempBuyDbItem.equals("그런 아이템은 없어"))
			{
				System.out.println(tempBuyDbItem);
				continue;
			}			
			if(mainChar.getMoney()-own[tempBuyDbNumber].getPrice()>=0)
			{
				String[] tempInven = new String[mainChar.getInventory().length+1];	
				for(int i = 0; i<tempInven.length; i++)
				{
					tempInven[i]="";//null오류방지용 초기화
				}
				for(int i = 0; i<mainChar.getInventory().length; i++)
				{
					tempInven[i]=mainChar.getInventory()[i];
				}
				for(int i = 0; i<tempInven.length; i++)
				{
					if(tempInven[i].isEmpty())
					{
						tempInven[i]=tempBuyChoice;
						mainChar.setInventory(tempInven);
						System.out.println(tempBuyChoice+"를 "+ own[tempBuyDbNumber].getPrice()+"골드에 구매했습니다.");
						mainChar.setMoeny(mainChar.getMoney()-own[tempBuyDbNumber].getPrice());
						System.out.println("현재 소지금" + mainChar.getMoney());
						break;
					}
				}
			}
			else
			{
				System.out.println("돈이 없으면 물건은 줄 수 없어.");
			}
		}		
	}
	
	public void sellItem(MainPlayerCharacter mainChar)
	{
		String[] inven =mainChar.getInventory();
		OwnedItem[] own = o.itemDatabase();
		
		System.out.println("판매 가격은 구매가격의 절반이니까 주의하라고");
		
		for(int i = 0; i< inven.length; i++)
		{
			for(int j = 0; j< own.length; j++)
			{
				if(inven[i].equals(own[j].getItemName()))
				{
					System.out.println(own[j].getItemDescription());
					System.out.println(own[j].getPrice()/2+"골드");
					break;
				}
			}			
		}
		System.out.println();
		while(true) 
		{
			String tempSellItemName = "해당 아이템은 소지하고 있지 않아";//더미
			
			System.out.println("어떤 물건을 판매할까요? 0.뒤로가기");
			String temp=scan.nextLine();
			if(temp.equals("뒤로가기")|temp.equals("0"))
			{
				break;
			}
			for(int i = 0; i <inven.length; i++)
			{
				if(temp.equals(inven[i]))
				{
					tempSellItemName=inven[i];
					mainChar.setInventory("",i);//판매한칸 비어주고
					break;
				}
			}
			for(int i = 0; i < own.length; i++)
			{
				if(tempSellItemName.equals(own[i].getItemName()))
				{
					mainChar.setMoeny(mainChar.getMoney()+(own[i].getPrice()/2));
					System.out.println(own[i].getItemName()+"(이)가 "+own[i].getPrice()/2+"골드에 팔렸습니다.");
					System.out.println("현재 소지금" + mainChar.getMoney());
					break;
				}
			}
			
			if(tempSellItemName.equals("해당 아이템은 소지하고 있지 않아"))
			{
				System.out.println(tempSellItemName);
			}
		}
	}
	
	
	
	
}
