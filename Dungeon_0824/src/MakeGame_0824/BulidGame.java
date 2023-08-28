package MakeGame_0824;

import MakeGame_0824.CharacterBundle.MainPlayerCharacter;
import MakeGame_0824.MapBundle.Dungeon.DungeonFirstMap;
import MakeGame_0824.MapBundle.Dungeon.DungeonFirstMapReverse;
import MakeGame_0824.MapBundle.Dungeon.DungeonMap;
import MakeGame_0824.MapBundle.Dungeon.DungeonSecondMap;
import MakeGame_0824.MapBundle.Dungeon.MoveInDungeon;
import MakeGame_0824.MapBundle.Village.MoveInVIllage;
import MakeGame_0824.MapBundle.Village.VillageMap;
import MakeGame_0824.StoryBundle.IntroStory;
import MakeGame_0824.StoryBundle.StoryText;
import MakeGame_0824.StoryBundle.Tutorial;

public class BulidGame
{
	MainPlayerCharacter mainChar = new MainPlayerCharacter();
	DungeonMap d = new DungeonMap();	
	StoryText s= new StoryText(mainChar);
	Battle b = new Battle(mainChar,d);
	VillageMap v = new VillageMap(mainChar);
	
	MoveInVIllage villageCombine = new MoveInVIllage(mainChar,d);
	MoveInDungeon dungeonCombine = new MoveInDungeon(mainChar,d,s,b,v);
	void build()
	{
		while(true)
		{
		villageCombine.combineMoveInVillage(mainChar, d, v, s);
		//던전입장
		if(d.getFloor()==1) //층수조절 //여기서 날짜초기화중
			{
			d= new DungeonFirstMap();
			d.MapSetting();
			//반복을 막기 위해 층수를 음수로 빼둡니다
			}
		else if(d.getFloor()==-1)
		{
			d= new DungeonFirstMapReverse();
			d.MapSetting();
			}
		else if(d.getFloor()==2)
		{
			d= new DungeonSecondMap();
			d.MapSetting();
			}
		
		dungeonCombine.moveInDungeon(mainChar,d,s,b,v);	
			
		if(d.getFloor()==0)//출구로 나왔을때만 마을로 돌아간다
		{
			v.setCurrentLocation(2);
		}
		}
	}
}

