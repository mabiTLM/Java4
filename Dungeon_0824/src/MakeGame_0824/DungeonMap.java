package MakeGame_0824;

import java.util.Scanner;

public class DungeonMap {
	
	private int floor=1;
	
	int nowMyWidth;
	int nowMyHeight;	
	private String[][] map;
	
	public void MapSetting() 
	{
		
	}
	
	public void whereAmI()
	{
		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map.length; j++) 
			{
				if(map[i][j].equals("나")) 
				{
					setNowMyHeight(i);
					setNowMyWidth(j);
				}
			}
		}
	}
	
	
	void minimap() 
	{
		whereAmI();//내위치를 잡고
		//주변을 출력
		for(int i = -1; i<2;i++)
		{
			for(int j = -1; j<2;j++)
				{
				System.out.print(map[nowMyHeight+i][nowMyWidth+j]);
				}
			System.out.println();
		}
	}
	
	
	
	public void dungeonMapMove() //맵이 층마다 다르고 입구출구위치역시 다르기에 층마다 오버라이드 하는게 나은거같습니다.
	{
		int temp=0;
		String move = "";
		System.out.print("전8 후2 좌4 우6 어디로 이동 할까요?");
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
			if(map[nowMyHeight-1][nowMyWidth].equals("밑"))
			{
				
				setFloor(getFloor()+1);
				break;
			}			
			else if(map[nowMyHeight-1][nowMyWidth].equals(" "))
			{
				map[nowMyHeight][nowMyWidth] = " ";
				nowMyHeight = nowMyHeight-1;
				map[nowMyHeight][nowMyWidth] = "나";
				}
			break;
		case 2:
			if(map[nowMyHeight+1][nowMyWidth].equals("위"))
			{
				setFloor(getFloor()-1);
				break;
			}	
			else if(map[nowMyHeight+1][nowMyWidth].equals(" "))
				{
				map[nowMyHeight][nowMyWidth] = " ";
			nowMyHeight = nowMyHeight+1;
			map[nowMyHeight][nowMyWidth] = "나";
			}
			break;
		case 4:
			if(map[nowMyHeight][nowMyWidth-1].equals(" "))
			{
				map[nowMyHeight][nowMyWidth] = " ";
			nowMyWidth = nowMyWidth-1;
			map[nowMyHeight][nowMyWidth] = "나";
			}
			break;
		case 6:
			if(map[nowMyHeight][nowMyWidth+1].equals(" "))
			{
				map[nowMyHeight][nowMyWidth] = " ";
			nowMyWidth = nowMyWidth+1;
			map[nowMyHeight][nowMyWidth] = "나";
			}
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
	
	public void setMap(String[][] map)
	{
		this.map=map;
	}
	
	//get모음
	
	public int getFloor()
	{
		return floor;
	}
	
	public String[][] getMap()
	{
		return map;
	}
	
	
}
