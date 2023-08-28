package NumberPuzzleOOP_0828;

import java.util.Scanner;

public class MainToUseString 
{
	public static void main(String[] args)
	{
		int x = 0;
		int y = 0;
		Puzzle puzzle = new Puzzle();
		Player player = new Player();
		Scanner scanner = new Scanner(System.in);
		
		puzzle.setPlayer(player);
				
		while(true)
		{
			System.out.println("퍼즐의 길이?");
			String countX = scanner.nextLine();
			if(countX.isEmpty()==false&&countX.replaceAll("[0-9]","").isEmpty())
			{
				if(Integer.valueOf(countX)>1)
				{
					x=Integer.valueOf(countX);
					break;
				}
			}
			System.out.println("다시");
		}
		while(true)
		{
			System.out.println("퍼즐의 줄수?");
			String countY = scanner.nextLine();
			if(countY.isEmpty()==false&&countY.replaceAll("[0-9]","").isEmpty())
			{
				if(Integer.valueOf(countY)>1)
				{
					y=Integer.valueOf(countY);
					break;
				}
			}
			System.out.println("다시");
		}
		puzzle.setPuzzle(x,y);
		puzzle.print();
		while(true)
		{
			int temp = -1;
			if(puzzle.getIsEnd())break;
			System.out.println("p를 옮겨서 1 ~ " + (y * x -1) + "순서로 맞춰라.");
			System.out.println("2 : 하 / 8 : 상 / 4 : 좌 / 6 : 우 / 0 : 종료 / 5 : 리셋");
			String direction = scanner.nextLine();
			
			if(direction.isEmpty()==false&&direction.replaceAll("[0-9]","").isEmpty())
			{
				temp=Integer.valueOf(direction);
			}
			
			if(direction.equals("종료")||temp==0) break;
			if(direction.equals("리셋")||temp==5) puzzle.shuffle();
			
			if(temp!=-1) {puzzle.movePlayer(temp);}
			else {puzzle.movePlayer(direction);}
				
			puzzle.print();
		}
		System.out.println("끝");
	}
}