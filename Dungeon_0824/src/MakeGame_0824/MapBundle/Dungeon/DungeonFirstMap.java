package MakeGame_0824.MapBundle.Dungeon;

import java.util.Scanner;

public class DungeonFirstMap extends DungeonMap
{
	String[][] firstMap;
	@Override
	public void MapSetting() 
	{
		setFloor(1);
		setMap(new String[][]//하나의 던전을 돌려서 사용한다
		{
			{"벽","벽","벽","벽","벽","벽","벽","벽","밑","벽"},
			{"벽"," ","벽","벽"," "," "," ","벽"," ","벽"},
			{"벽"," ","벽","벽"," ","벽"," ","벽"," ","벽"},
			{"벽"," ","벽","벽"," ","벽"," ","벽"," ","벽"},
			{"벽"," "," "," "," ","벽"," ","벽"," ","벽"},
			{"벽"," ","벽"," ","벽","벽"," ","벽"," ","벽"},
			{"벽"," ","벽"," ","벽"," "," ","벽"," ","벽"},
			{"벽"," ","벽"," ","벽","벽"," "," "," ","벽"},
			{"벽","나","벽"," "," ","벽","벽","벽"," ","벽"},
			{"벽","출구","벽","벽","벽","벽","벽","벽","벽","벽"}
		});
	
	firstMap = getMap();
	
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
			if(firstMap[nowMyHeight-1][nowMyWidth].equals("밑"))
			{
				setFloor(getFloor()+1);
				break;
			}			
			else if(firstMap[nowMyHeight-1][nowMyWidth].equals(" "))
			{
				firstMap[nowMyHeight][nowMyWidth] = " ";
				nowMyHeight = nowMyHeight-1;
				firstMap[nowMyHeight][nowMyWidth] = "나";
			}
			break;
		case 2:
			if(firstMap[nowMyHeight+1][nowMyWidth].equals("출구"))
			{
				setFloor(getFloor()-1);
				break;
			}	
			else if(firstMap[nowMyHeight+1][nowMyWidth].equals(" "))
				{
				firstMap[nowMyHeight][nowMyWidth] = " ";
				nowMyHeight = nowMyHeight+1;
				firstMap[nowMyHeight][nowMyWidth] = "나";
				}
			break;
		case 4:
			if(firstMap[nowMyHeight][nowMyWidth-1].equals(" "))
			{
				firstMap[nowMyHeight][nowMyWidth] = " ";
				nowMyWidth = nowMyWidth-1;
				firstMap[nowMyHeight][nowMyWidth] = "나";
			}
			break;
		case 6:
			if(firstMap[nowMyHeight][nowMyWidth+1].equals(" "))
			{
				firstMap[nowMyHeight][nowMyWidth] = " ";
				nowMyWidth = nowMyWidth+1;
				firstMap[nowMyHeight][nowMyWidth] = "나";
			}
			break;
		default:
				System.out.println("8,4,6,2만 입력해주세요");
				break;
		}
	}
}

//	public static void main(String[] args) //맵 생성도우미
//	{
//		for(int i = 0; i < 10; i ++)
//		{
//			for(int j = 0; j < 10; j ++) {
//				System.out.print(firstMap[i][j]);
//			}
//			System.out.println("");
//		}
//		for(int i = 0; i < 10; i ++)
//		{
//			for(int j = 0; j < 10; j ++) {
//				System.out.print("\"벽\""+",");
//			}
//			System.out.println("");
//		}