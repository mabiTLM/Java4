package makeCardGame230901.mapBundle;

import makeCardGame230901.battleBundle.BattleCombine;
import makeCardGame230901.characterBundle.PlayerCharacter;
import makeCardGame230901.village.MoveInVillage;

public class MoveInDungeon
{
	BattleCombine battleCombine;
	MoveInVillage moveInvillage;
	PlayerCharacter player;
	
	public MoveInDungeon(BattleCombine battleCombine,MoveInVillage moveInvillage,PlayerCharacter player)
	{
		this.battleCombine=battleCombine;
		this.moveInvillage=moveInvillage;
		this.player=player;
	}
	
	
	
	public void dungeonEntrance()
	{
		FirstFloor floor = new FirstFloor(battleCombine,moveInvillage,player);
		floor.makeFirstMap();
		while(!moveInvillage.getLocationVillage()) //언제나갈지 생각하자
		{
			floor.watchMap();
			floor.movePlayer();
		}
	}
	
}
