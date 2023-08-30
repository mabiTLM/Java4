package MakeGame_0824.MapBundle.Dungeon;

import java.util.Scanner;

import MakeGame_0824.CharacterBundle.MainPlayerCharacter;
import MakeGame_0824.MapBundle.Inventory;

public class DungeonMap {
	
	MainPlayerCharacter mainChar;
	Inventory i = new Inventory(mainChar, this);
	
	private int floor=1;
	
	int nowMyWidth;
	int nowMyHeight;	
	private int[][] map;
	
//	public DungeonMap(){
//		
//	}
	

	
	public void MapSetting() 
	{
		
	}
	
	public void whereAmI()
	{
		for(int i = 0; i < map[0].length; i++)
		{
			for(int j = 0; j < map.length; j++) 
			{
				if(map[i][j]==1) //길0 내위치1 벽2 밑3 위4
				{
					setNowMyHeight(i);
					setNowMyWidth(j);
				}
			}
		}
	}
	
	
	public void minimap() 
	{
		whereAmI();//내위치를 잡고
		//주변을 출력
		
		int sight = 2;//시야에 변동을 줄 수 있게
		
		for(int i = -sight+1; i<sight;i++)
		{
			String temp="";
			for(int j = -sight+1; j<sight;j++)//길0 내위치1 벽2 밑3 위4
				{
				
				if(nowMyHeight+i>map.length-1|nowMyHeight+i<0)
				{
					break;
				}
				else if(nowMyWidth+j>map.length-1|nowMyWidth+j<0)
				{
					continue;
				}
				
				if(map[nowMyHeight+i][nowMyWidth+j]==0)
				{
					temp = " ";
				}
				if(map[nowMyHeight+i][nowMyWidth+j]==1)
				{
					temp = "나";
				}
				if(map[nowMyHeight+i][nowMyWidth+j]==2)
				{
					temp = "벽";
				}
				if(map[nowMyHeight+i][nowMyWidth+j]==3)
				{
					temp = "밑";
				}
				if(map[nowMyHeight+i][nowMyWidth+j]==4)
				{
					temp = "위";
				}

				System.out.print(temp+"	");//
				}
			System.out.println();
		}
	}
	
	
	
	public void dungeonMapMove(MainPlayerCharacter mainChar) //맵이 층마다 다르고 입구출구위치역시 다르기에 층마다 오버라이드 하는게 나은거같습니다.
	{
		int temp=0;
		String move = "";
		System.out.print("전8 후2 좌4 우6 어디로 이동 할까요?"); //5. 인벤토리 미구현
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
		//나중에 숫자 이외 입력시 예외처리 넣을곳
		temp = Integer.valueOf(move);
		
		
		
		switch(temp)
		{
		case 8:			
			if(map[nowMyHeight-1][nowMyWidth]==3) //길0 내위치1 벽2 밑3 위4
			{
				
				setFloor(getFloor()+1);
				break;
			}			
			else if(map[nowMyHeight-1][nowMyWidth]==0)
			{
				map[nowMyHeight][nowMyWidth] = 0;
				nowMyHeight = nowMyHeight-1;
				map[nowMyHeight][nowMyWidth] = 1;
				}
			break;
		case 2:
			if(map[nowMyHeight+1][nowMyWidth]==4)
			{
				setFloor(getFloor()-1);
				break;
			}	
			else if(map[nowMyHeight+1][nowMyWidth]==0)
				{
				map[nowMyHeight][nowMyWidth] = 0;
			nowMyHeight = nowMyHeight+1;
			map[nowMyHeight][nowMyWidth] = 1;
			}
			break;
		case 4:
			if(map[nowMyHeight][nowMyWidth-1]==0)
			{
				map[nowMyHeight][nowMyWidth] = 0;
			nowMyWidth = nowMyWidth-1;
			map[nowMyHeight][nowMyWidth] = 1;
			}
			break;
		case 6:
			if(map[nowMyHeight][nowMyWidth+1]==0)
			{
				map[nowMyHeight][nowMyWidth] = 0;
			nowMyWidth = nowMyWidth+1;
			map[nowMyHeight][nowMyWidth] = 1;
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
	
	
	//set모음	
	public void setFloor(int floor)
	{
		this.floor=floor;
	}
	
	public void setNowMyHeight(int nowMyHeight)
	{
		this.nowMyHeight=nowMyHeight;
	}
	public void setNowMyWidth(int nowMyWidth)
	{
		this.nowMyWidth=nowMyWidth;
	}
	
	public void setMap(int[][] map)
	{
		this.map=map;
	}
	
	//get모음
	
	public int getFloor()
	{
		return floor;
	}
	
	public int[][] getMap()
	{
		return map;
	}	
	
}
