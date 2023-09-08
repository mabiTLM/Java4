package makeCardGame230901.mapBundle;

import java.util.Random;

import makeCardGame230901.battleBundle.BattleCombine;
import makeCardGame230901.characterBundle.PlayerCharacter;
import makeCardGame230901.village.MoveInVillage;

public class FirstFloor extends StageBase
{
	FirstFloor(BattleCombine battleCombine, MoveInVillage moveInvillage, PlayerCharacter player) {
		super(battleCombine, moveInvillage, player);
		// TODO Auto-generated constructor stub
	}

	Random random = new Random();
	
	public void makeFirstMap()
	{		
		for(int i = 0; i < mapHeight;i++)
		{
			for(int j =0; j<mapWidth; j++)
			{
				int roomPercent= random.nextInt(100);
				int roomType=0;
				if(i==mapHeight-1)
				{
					continue;
				}
				if(roomPercent>=92)//강한몹
				{
					roomType=1;
				}
				else if(roomPercent>=39)//일반몹1
				{
					roomType=2;
				}
				else if(roomPercent>=17)//이벤트
				{
					roomType=3;
				}
				else if(roomPercent>=5)//불
				{
					roomType=4;
				}
				else if(roomPercent>=0)//상점
				{
					roomType=5;
				}
				
				firstMap[i][j]=roomType;
			}
		}
	}
	
//	public static void main(String[] args)//맵생성 도우미
//	{
//		FirstFloor FirstFloor= new FirstFloor();
//		FirstFloor.makeFirstMap();
//		
//		while(true) {
//			FirstFloor.watchMap();
//			FirstFloor.movePlayer();
//		
//		}
//	}
}
