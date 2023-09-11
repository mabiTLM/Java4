package makeCardGame230901.battleBundle;

import java.io.Serializable;
import makeCardGame230901.battleBundle.enemyActBunble.EnemyActAi;
import makeCardGame230901.characterBundle.PlayerCharacter;
import makeCardGame230901.characterBundle.enemyBundle.EnemyCharacter;
import makeCardGame230901.village.MoveInVillage;

public class BattleCombine implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 5511722642112669026L;
  private PlayerCharacter player;
  private Battle battle;
  private EnemyActAi enemyActAi;
  EnemyCharacter currentEnemy;
  private int playerTurnGaze = 0;// 행동게이지

  public BattleCombine(PlayerCharacter playerCharacter, Battle battle) {
    this.player = playerCharacter;
    this.battle = battle;
    enemyActAi = new EnemyActAi(playerCharacter, battle);
  }

  public void battleCombine(MoveInVillage moveInVillage) {
    // 조우시 행동
    battle.encounter();

    // 속도계산

    while (true) {
      // 행동게이지 개념
      playerTurnGaze = playerTurnGaze + player.getSpeed();// 속도만큼 행동게이지증가
      if (playerTurnGaze >= 100)// 행동게이지 100이상일때 행동
      {
        battle.setPlayerTurn(true);
      }
      for (int i = 0; i < battle.currentEnemy.length; i++) {
        currentEnemy = battle.currentEnemy[i];
        currentEnemy.setTurnGaze(currentEnemy.getTurnGaze() + currentEnemy.getSpeed());// 적 행동게이지 증가

        if (currentEnemy.getTurnGaze() >= 100 && currentEnemy.getTurnGaze() > playerTurnGaze)
        // 행동게이지가 차고 적이 높을경우 상대턴부터 받는다.
        {
          battle.currentEnemy[i].setEnemyTurn(true);
          battle.setPlayerTurn(false);
        }

      }
      // 여기까지 행동게이지 처리


      if (battle.getPlayerTurn()) {
        battle.playerTurnStart();
      }
      while (battle.getPlayerTurn()) {
        battle.targetLockOn(this);
        if (battle.getPlayerTurn() == false) {
          playerTurnGaze = playerTurnGaze - 100;// 행동끝났으면 수치낮추기
          break;
        }
      }
      if (battle.playerWin()) // 전투 승리
      {
        break;
      }

      // 모든 몬스터 제거시 실행종료


      // 몬스터행동

      for (int i = 0; i < battle.currentEnemy.length; i++) // 적의 수만큼 반목
      {
        while (battle.currentEnemy[i].getEnemyTurn())// 턴이 켜져있을 때
        {
          battle.currentEnemy[i].setTurnGaze(battle.currentEnemy[i].getTurnGaze() - 100);
          battle.currentEnemy[i].setEnemyTurn(false);
          enemyActAi.totalAi(i);
        }
        if (player.getHp() <= 0) // 사망처리
        {
          break;
        }
      }
      if (player.getHp() <= 0)// 사망처리
      {
        System.out.println("전투에서 졌습니다. 처음으로 돌아갑니다.");
        moveInVillage.setLocationVillage(true);
        player.setNowFloor(0);
        break;
      }
      if (battle.playerWin()) // 전투 승리
      {
        break;
      }
    }

  }

  // set모음


  // get모음
  public Battle getBattle() {
    return battle;
  }
}
