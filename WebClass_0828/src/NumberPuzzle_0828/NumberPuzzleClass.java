package NumberPuzzle_0828;

public class NumberPuzzleClass
{
	public static void main(String[] args)
	{
		int[][] arr = new int[5][5];
		
		for(int i = 0; i <5;i++)
		{
			for(int j = 0; j <5;j++)
			{
				arr[i][j] = i*5+j+1;
			}
		}
		
		arr[4][4]=0;
		
		for(int i = 0; i<1000; i++)
		{
			int num1 = (int) (Math.random()*5);
			int num2 = (int) (Math.random()*5);
			int num3 = (int) (Math.random()*5);
			int num4 = (int) (Math.random()*5);
			
			int temp = arr[num1][num2];
			arr[num1][num2]=arr[num3][num4];
			arr[num3][num4]= temp;
		}
		
		for(int i = 0; i <5;i++)
		{
			for(int j = 0; j <5;j++)
			{
				if(arr[i][j]==0)
					{System.out.print("p\t");}
				else
					{System.out.print(arr[i][j]+"\t");}
			}
			System.out.print("\n");
		}
	}
	
		int[][] shuffle(int[][] arr, int idx1, int idx2, int direction)
		{
			int temp = arr[idx1][idx2];
			switch(direction)
			{
			case 2:
				if(idx1<4) 
				{
					arr[idx1][idx2] = arr[idx1+1][idx2];
					arr[idx1+1][idx2]=temp;
				}
				return arr;
			case 4:
				if(idx2>0)
				{
					arr[idx1][idx2] = arr[idx1][idx2-1];
					arr[idx1][idx2-1]=temp;
				}
				return arr;
			case 6:
				if(idx2<4)
				{
					arr[idx1][idx2] = arr[idx1][idx2+1];
					arr[idx1][idx2+1]=temp;
				}
				return arr;
			case 8:
				if(idx1>0)
				{
					arr[idx1][idx2] = arr[idx1-1][idx2];
					arr[idx1-1][idx2]=temp;
				}
				return arr;
			
			
				default:
					return arr;
			}
		}
		
	
}
