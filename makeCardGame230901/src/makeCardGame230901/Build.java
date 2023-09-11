package makeCardGame230901;

import java.io.Serializable;
import makeCardGame230901.battleBundle.Battle;
import makeCardGame230901.battleBundle.BattleCombine;
import makeCardGame230901.characterBundle.PlayerCharacter;
import makeCardGame230901.characterBundle.PlayerReset;
import makeCardGame230901.mapBundle.MoveInDungeon;
import makeCardGame230901.village.MoveInVillage;

public class Build implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = -233598961694881345L;
  private PlayerCharacter player = new PlayerCharacter();
  private Battle battle = new Battle(player);
  private BattleCombine battleCombine = new BattleCombine(player, battle);
  private MoveInVillage moveInvillage = new MoveInVillage();
  private PlayerReset resetData = new PlayerReset();
  private MoveInDungeon moveInDungeon = new MoveInDungeon(battleCombine, moveInvillage, player);
  SettingMenu settingMenu = new SettingMenu();

  void build() {
    while (true) {
      while (moveInvillage.getLocationVillage()) // 마을에서 초기덱을 강화할수있게, 마을에 위치해있는가를 판단
      {
        moveInvillage.MoveVillage(player);
        // 던전에 가기전에 덱, 인벤토리 복사, 스텟최대치 복사
        if (player.getOpenMenu()) {
          settingMenu.printSettingMenu(player, this);
        }
      }
      resetData.setResetData(player);
      while (!moveInvillage.getLocationVillage()) // 마을에 있지 않을때
      {
        moveInDungeon.dungeonEntrance();
        if (player.getOpenMenu()) {
          settingMenu.printSettingMenu(player, this);
        }
      }

      if (moveInvillage.getLocationVillage())// 마을로 나와질경우 초기화
      {
        int tempMoney = player.getMoney();
        player = new PlayerCharacter();
        battle = new Battle(player);
        battleCombine = new BattleCombine(player, battle);
        moveInvillage = new MoveInVillage();
        moveInDungeon = new MoveInDungeon(battleCombine, moveInvillage, player);
        player.setMoeny(tempMoney);// 돈은 직전껄로
        resetData.getResetData(player);// 나머진 리셋데이터 저장한걸로
      }
    }
  }
}
