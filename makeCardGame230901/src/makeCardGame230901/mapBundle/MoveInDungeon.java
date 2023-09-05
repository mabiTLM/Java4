package makeCardGame230901.mapBundle;

import makeCardGame230901.battleBundle.BattleCombine;
import makeCardGame230901.village.MoveInVillage;

public class MoveInDungeon
{
	BattleCombine battleCombine;
	MoveInVillage moveInvillage;
	
	public MoveInDungeon(BattleCombine battleCombine,MoveInVillage moveInvillage)
	{
		this.battleCombine=battleCombine;
		this.moveInvillage=moveInvillage;
	}
	
	
	
	public void dungeonEntrance()
	{
		FirstFloor floor = new FirstFloor(battleCombine,moveInvillage);
		System.out.println("지금은 1층밖에 없다.");
		floor.makeFirstMap();
		while(!moveInvillage.getLocationVillage()) //언제나갈지 생각하자
		{
			floor.watchMap();
			floor.movePlayer();
		}
	}
	
}
