<%@ page language="java" contentType="text/html; charset=UTF-8" import="makeCardGame230901.characterBundle.enemyBundle.EnemyCharacter" import="makeCardGame230901.characterBundle.enemyBundle.FirstFloorEnemy" import="servletTest.card.*" pageEncoding="UTF-8"%>
<%!private EnemyCharacter[] encount() // 어떤 적을 만날지 정해주자
	{
		int temp = (int) (Math.random() * 4 + 1);
		EnemyCharacter[] currentEnemy = new EnemyCharacter[temp];
		EnemyCharacter eArray = new FirstFloorEnemy();
		for (int i = 0; i < currentEnemy.length; i++) {
			int enemyNumberTemp = (int) (Math.random() * eArray.stageData().length);
			currentEnemy[i] = eArray.stageData()[enemyNumberTemp];
		}
		return currentEnemy;
	}%>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset='UTF-8' />
<meta name='viewport' content='width=device-width, initial-scale=1.0' />
<script src='scripts/makeCardGame.js'></script>
<link rel='stylesheet' href='styles/battle.css' />
<title>일반 배틀</title>
</head>
<body>

	<div id="root">

		<div class="padding-box">
			<div class="monster-area">
				<%
				EnemyCharacter[] monster = encount();
				for (int i = 0; i < monster.length; i++) {
					EnemyCharacter c = monster[i];
				%>
				<div class="enemystanding" id='monster<%=i%>'>
					<img src="images/battle/monster/<%=c.getName()%>.png" alt="<%=c.getName()%>>" class="enemyimg" onclick="target(<%=i%>,<%=c.getHp()%>,<%=c.getDef()%>,<%=monster.length%>)" />

					<span>
						체력 :
						<span id='monsterHp<%=i%>'>
							<%
							out.print(c.getHp());
							%>
						</span>
						<br />
						쉴드 :
						<span id='monsterDef<%=i%>'>
							<%
							out.print(c.getDef());
							%>
						</span>
						<br />
						공격력 :
						<%
						out.print(c.getAtk());
						%>
					</span>
				</div>
				<%
				}
				%>
			</div>

			<div class="player-area">
				<div class="status-area">
					<script>
						document.write("체력" + playerHp);
					</script>
					<span>
						방어력 :
						<span id="playerDefSpan">
							<script>
						document.write(playerDef);
					</script>
						</span>
					</span>
					<span>
						마나 :
						<span id="playerManaSpan">
							<script>
						document.write(playerMana);
					</script>
						</span>
					</span>
				</div>

				<div class="hand-area">

					<%!CardDAO cardDAO = new CardDAO();

    private CardVO Hand(int i) {
      CardVO temp = cardDAO.getCard(i, "deck");
      return temp;
    }%>

					<%
					for (int i = 0; i < cardDAO.dBLengthCheck("deck"); i++) {
					%>

					<div class="card-area">
						<div class="card-area-inner">
							<button class="use-button" onclick="usecard('<%=Hand(i).getCardType()%>',<%=Hand(i).getCardValue()%>,<%=Hand(i).getCardConsumeMana()%>)">
								<img src="images/card/<%=Hand(i).getCardName()%>.png" alt="<%=Hand(i).getCardName()%>>" class="hand">
								<div class="card-mana"><%=Hand(i).getCardConsumeMana()%></div>
								<div class="card-name"><%=Hand(i).getCardName()%></div>
								<div class="card-explain-area"><%=Hand(i).cardExplain()%></div>
							</button>
						</div>
					</div>
					<%
					}
					%>
					<br />
				</div>
				<div class="turnoff-area">
					<button onclick='turnFinish()' class="turnoff-button">턴종료</button>
				</div>
				<div class="battlefinish-area" id="finish-area">
					<form action='dungeon' class="finish-button">
						<input type=hidden id=finish value='전투종료' class="finish-button">
					</form>
				</div>
			</div>

		</div>
	</div>
</body>
</html>