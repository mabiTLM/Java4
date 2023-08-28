package NumberPuzzle_0828;

import java.util.Scanner;

public class NumberPuzzleClass
{
	public static void main(String[] args)
	{
		int[][] arr = new int[5][5];
		int playerX= 4;
		int playerY= 4;		
		
		for(int i = 0; i <5;i++)
		{
			for(int j = 0; j <5;j++)
			{
				arr[i][j] = i*5+j+1;
			}
		}
		
		arr[playerY][playerX]=0;
		
//		for(int i = 0; i<1000; i++)
//		{
//			int num1 = (int) (Math.random()*5);
//			int num2 = (int) (Math.random()*5);
//			int num3 = (int) (Math.random()*5);
//			int num4 = (int) (Math.random()*5);
//			
//			int temp = arr[num1][num2];
//			arr[num1][num2]=arr[num3][num4];
//			arr[num3][num4]= temp;
//		}
		
		
		for(int i = 0; i <1000;i++)
		{
			int temp = (int)(Math.random()*4+1)*2;	
			int[] playerPosition = NumberPuzzleClass.move(arr,playerY,playerX,temp);
			playerX = playerPosition[0];
			playerY = playerPosition[1];
//			boolean isShuffle=shuffle(arr,playerY,playerX,temp);
//			if(isShuffle)
//			{
//				switch(temp)
//				{
//				case 2:
//					playerY=playerY+1;
//					break;
//				case 4:
//					playerX-=1;
//					break;
//				case 6:
//					playerX++;
//					break;
//				case 8:
//					--playerY;
//					break;
//					
//				}
//			}
		}
		
		
		while(true)
		{
			Scanner scanner = new Scanner(System.in);
			int input = scanner.nextInt();
			int[] playerPosition = NumberPuzzleClass.move(arr,playerY,playerX,input);
			playerX = playerPosition[0];
			playerY = playerPosition[1];

//			boolean isShuffle=shuffle(arr,playerY,playerX,input);
//			
//			if(isShuffle)
//			{
//				switch(input)
//				{
//				case 2:
//					playerY=playerY+1;
//					break;
//				case 4:
//					playerX-=1;
//					break;
//				case 6:
//					playerX++;
//					break;
//				case 8:
//					--playerY;
//					break;
//					
//				}
//			}
			
			for(int i = 0; i <5;i++)
			{
				for(int j = 0; j <5;j++)
				{
					if(arr[i][j]==0)
					{
						System.out.print("p\t");}
					else
					{
						System.out.print(arr[i][j]+"\t");
						}
					}
				System.out.print("\n");
				}
			}
		}
	
		static boolean shuffle(int[][] arr, int idx1, int idx2, int direction)
		{
			int temp = arr[idx1][idx2];
			switch(direction)
			{
			case 2:
				if(idx1==4) return false;
				arr[idx1][idx2] = arr[idx1+1][idx2];
				arr[idx1+1][idx2]=temp;				
				return true;
			case 4:
				if(idx2==0) return false;
				arr[idx1][idx2] = arr[idx1][idx2-1];
				arr[idx1][idx2-1]=temp;				
				return true;
			case 6:
				if(idx2==4) return false;
				arr[idx1][idx2] = arr[idx1][idx2+1];
				arr[idx1][idx2+1]=temp;
				return true;
			case 8:
				if(idx1==0) return false;
				arr[idx1][idx2] = arr[idx1-1][idx2];
				arr[idx1-1][idx2]=temp;
				return true;
				
				default:
					return true;
			}
		}
		
	public static int[] move(int[][] arr,int playerY,int playerX,int temp)
	{
		boolean isShuffle=shuffle(arr,playerY,playerX,temp);
		if(isShuffle)
		{
			switch(temp)
			{
			case 2:
				playerY=playerY+1;
				break;
			case 4:
				playerX-=1;
				break;
			case 6:
				playerX++;
				break;
			case 8:
				--playerY;
				break;
				
			}
		}
		return new int[]{playerX,playerY};
	}
}
