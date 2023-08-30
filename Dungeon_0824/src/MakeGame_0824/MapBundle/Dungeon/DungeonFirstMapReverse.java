package MakeGame_0824.MapBundle.Dungeon;

import java.util.Scanner;

import MakeGame_0824.CharacterBundle.MainPlayerCharacter;

public class DungeonFirstMapReverse extends DungeonMap
{
	int[][] firstMap;
	@Override
	public void MapSetting() 
	{
		setFloor(-1);//길0 내위치1 벽2 밑3 위4
		setMap(new int[][]//하나의 던전을 돌려서 사용한다
		{
			{2,2,2,2,2,2,2,2,3,2},
			{2,0,2,2,0,0,0,2,0,2},
			{2,0,2,2,0,2,0,2,0,2},
			{2,0,2,2,0,2,0,2,0,2},
			{2,0,0,0,0,2,0,2,0,2},
			{2,0,2,0,2,2,0,2,0,2},
			{2,0,2,0,2,0,0,2,0,2},
			{2,0,2,0,2,2,0,0,0,2},
			{2,1,2,0,0,2,2,2,0,2},
			{2,4,2,2,2,2,2,2,2,2}
		});
	
	firstMap = getMap();
	
	}	
	
	@Override
	public void dungeonMapMove(MainPlayerCharacter mainChar) 
	{
		int temp=0;
		String move = "";
		System.out.print("전8 후2 좌4 우6 어디로 이동 할까요? 5.인벤토리");
		Scanner scan = new Scanner(System.in);
		while(true) 
		{
			move = scan.nextLine();
			if(move.isEmpty()|move.replaceAll("[0-9]", "").isEmpty()==false)
			{
				System.out.print("숫자만 입력해주세요");
			}
			else
			{
			break;
			}
		}
		//숫자 이외 입력시 예외처리
		temp = Integer.valueOf(move);
		
		switch(temp)
		{
		case 8:
			if(firstMap[nowMyHeight-1][nowMyWidth]==3)
			{
				setFloor(getFloor()+1);
				break;
			}			
			else if(firstMap[nowMyHeight-1][nowMyWidth]==0)
			{
				firstMap[nowMyHeight][nowMyWidth] = 0;
				nowMyHeight = nowMyHeight-1;
				firstMap[nowMyHeight][nowMyWidth] = 1;
			}
			break;
		case 2:
			if(firstMap[nowMyHeight+1][nowMyWidth]==4)
			{
				setFloor(getFloor()-1);
				break;
			}	
			else if(firstMap[nowMyHeight+1][nowMyWidth]==0)
				{
				firstMap[nowMyHeight][nowMyWidth] = 0;
				nowMyHeight = nowMyHeight+1;
				firstMap[nowMyHeight][nowMyWidth] = 1;
				}
			break;
		case 4:
			if(firstMap[nowMyHeight][nowMyWidth-1]==0)
			{
				firstMap[nowMyHeight][nowMyWidth] = 0;
				nowMyWidth = nowMyWidth-1;
				firstMap[nowMyHeight][nowMyWidth] = 1;
			}
			break;
		case 6:
			if(firstMap[nowMyHeight][nowMyWidth+1]==0)
			{
				firstMap[nowMyHeight][nowMyWidth] = 0;
				nowMyWidth = nowMyWidth+1;
				firstMap[nowMyHeight][nowMyWidth] = 1;
			}
			break;
		case 5:
			i.inventoryOpen(mainChar,this);
			break;
		default:
				System.out.println("8,4,6,2만 입력해주세요");
				break;
		}
	}
}
