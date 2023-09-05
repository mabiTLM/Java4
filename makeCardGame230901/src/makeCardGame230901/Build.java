package makeCardGame230901;

import makeCardGame230901.cardBundle.Battle;
import makeCardGame230901.cardBundle.BattleCombine;
import makeCardGame230901.characterBundle.PlayerCharacter;
import makeCardGame230901.village.MoveInVillage;

public class Build {
	PlayerCharacter player = new PlayerCharacter();
	Battle battle = new Battle(player);
	BattleCombine battleCombine = new BattleCombine(player,battle);
	MoveInVillage moveInvillage = new MoveInVillage();
	PlayerReset resetData = new PlayerReset();
	
	
	void build()
	{
		while(moveInvillage.getLocationVillage())
		{
			while(moveInvillage.getLocationVillage()) //마을에서 초기덱을 강화할수있게
			{
				moveInvillage.MoveVillage(player);
				//던전에 가기전에 덱, 인벤토리 복사, 스텟최대치 복사
				resetData.setResetData(player);
			}
			
			while(!moveInvillage.getLocationVillage())
			{
				battleCombine.battleCombine(moveInvillage);//싸우고 난후 다시 마을로 나온다.
			}
			
			if(moveInvillage.getLocationVillage())//전투 종료후 초기화
			{
				int tempMoney=player.getMoney();
				player = new PlayerCharacter();
				battle = new Battle(player);
				battleCombine = new BattleCombine(player,battle);
				moveInvillage = new MoveInVillage();
				player.setMoeny(tempMoney);//돈은 직전껄로 덱과 인벤은 마을출발전껄로
				resetData.getResetData(player);//나머진 리셋데이터 저장한걸로
			}
		}
	}

}
