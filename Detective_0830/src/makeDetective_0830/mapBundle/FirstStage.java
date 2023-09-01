package makeDetective_0830.mapBundle;

public class FirstStage extends MapBase {
	
	int[][] firstMap = { //0은 이동가능, 1은 세로벽, 2는 가로벽 , 3은 문
			{1,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,1},
			{1,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,1},
			{1,0,1,2,3,2,1,2,3,2,1,2,3,2,1,2,3,2,1,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,1,2,3,2,1,2,3,2,1,2,3,2,1,2,3,2,1,0,1},
			{1,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,1},
			{1,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,1}
	};
	
	
	
	@Override
	public void makeMap() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args)//맵생성도우미 
	{
		for(int i = 0; i<8; i++)
		{
			
			for(int j = 0; j<21; j++)
			{
				System.out.print("0,");
				
			}
			System.out.println();
		}
	}

}
