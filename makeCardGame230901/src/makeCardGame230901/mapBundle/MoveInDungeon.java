package makeCardGame230901.mapBundle;

import java.io.Serializable;
import makeCardGame230901.battleBundle.BattleCombine;
import makeCardGame230901.characterBundle.PlayerCharacter;
import makeCardGame230901.village.MoveInVillage;

public class MoveInDungeon implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 8715667971740467462L;
  BattleCombine battleCombine;
  MoveInVillage moveInvillage;
  PlayerCharacter player;

  public MoveInDungeon(BattleCombine battleCombine, MoveInVillage moveInvillage,
      PlayerCharacter player) {
    this.battleCombine = battleCombine;
    this.moveInvillage = moveInvillage;
    this.player = player;
  }



  public void dungeonEntrance() {
    FirstFloor floor = new FirstFloor(battleCombine, moveInvillage, player);
    floor.makeFirstMap();
    while (player.getNowFloor() == 1) {
      floor.watchMap();
      floor.movePlayer();
    }

    // 일단은 1,2층 모양이 같으니까 굳이 안바꿔도된다.
    floor = new FirstFloor(battleCombine, moveInvillage, player);
    floor.makeFirstMap();
    while (player.getNowFloor() == 2) {
      floor.watchMap();
      floor.movePlayer();
    }

    if (player.getNowFloor() != 0)// 0이 아닌상태로 끝까지 왔을때
    {
      System.out.println("게임을 클리어했습니다. 반복플레이가 가능하기에 마을로 돌아갑니다.");
      moveInvillage.setLocationVillage(true);
    }

  }

}
