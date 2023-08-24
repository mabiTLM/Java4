package MakeGame_0824;

import java.util.Scanner;

public class DungeonSecondMap extends DungeonMap
{
	String[][] secondMap;
	@Override
	public void MapSetting() 
	{
		setFloor(2);
	setMap(new String[][]//하나의 던전을 돌려서 사용한다
		{
				{"벽","벽","벽","벽","벽","벽","벽","벽","벽","벽"},
				{"벽"," "," "," ","벽"," "," "," "," ","벽"},
				{"벽"," ","벽"," ","벽"," ","벽"," ","벽","벽"},
				{"벽"," ","벽"," "," "," ","벽","밑","벽","벽"},
				{"벽"," ","벽","벽"," ","벽"," ","벽"," ","벽"},
				{"벽"," "," ","벽"," ","벽"," ","벽"," ","벽"},
				{"벽"," "," ","벽"," ","벽"," ","벽"," ","벽"},
				{"벽"," "," ","벽"," ","벽"," ","벽"," ","벽"},
				{"벽"," "," "," ","나"," "," "," "," ","벽"},
				{"벽","벽","벽","벽","위","벽","벽","벽","벽","벽"}
		});
	
	secondMap = getMap();
	}
	
	@Override
	public void dungeonMapMove() 
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
		//숫자 이외 입력시 예외처리
		temp = Integer.valueOf(move);
		
		
		
		switch(temp)
		{
		case 8:			
			if(secondMap[nowMyHeight-1][nowMyWidth].equals("밑"))
			{
				
				setFloor(getFloor()+1);
				break;
			}			
			else if(secondMap[nowMyHeight-1][nowMyWidth].equals(" "))
			{
				secondMap[nowMyHeight][nowMyWidth] = " ";
				nowMyHeight = nowMyHeight-1;
				secondMap[nowMyHeight][nowMyWidth] = "나";
			}
			break;
		case 2:
			if(secondMap[nowMyHeight+1][nowMyWidth].equals("위"))
			{
				setFloor(-getFloor()+1);
				break;
			}	
			else if(secondMap[nowMyHeight+1][nowMyWidth].equals(" "))
				{
				secondMap[nowMyHeight][nowMyWidth] = " ";
				nowMyHeight = nowMyHeight+1;
				secondMap[nowMyHeight][nowMyWidth] = "나";
				}
			break;
		case 4:
			if(secondMap[nowMyHeight][nowMyWidth-1].equals(" "))
			{
				secondMap[nowMyHeight][nowMyWidth] = " ";
				nowMyWidth = nowMyWidth-1;
				secondMap[nowMyHeight][nowMyWidth] = "나";
			}
			break;
		case 6:
			if(secondMap[nowMyHeight][nowMyWidth+1].equals(" "))
			{
				secondMap[nowMyHeight][nowMyWidth] = " ";
				nowMyWidth = nowMyWidth+1;
				secondMap[nowMyHeight][nowMyWidth] = "나";
			}
			break;
		default:
				System.out.println("8,4,6,2만 입력해주세요");
				break;
		}
	}
	
	
	
}
