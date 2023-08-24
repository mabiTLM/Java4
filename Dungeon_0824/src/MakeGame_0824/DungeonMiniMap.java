package MakeGame_0824;

public class DungeonMiniMap extends DungeonFirstMap
{
	void minimap() 
	{
		whereAmI();//내위치를 잡고
		//주변을 출력
		for(int i = -1; i<2;i++)
		{
			for(int j = -1; j<2;j++)
				{
				System.out.print(firstMap[nowMyHeight+i][nowMyWidth+j]);
				}
			System.out.println();
		}
	}
}
