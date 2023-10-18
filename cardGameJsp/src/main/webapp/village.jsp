<%@ page language="java" contentType="text/html; charset=UTF-8" import="servletTest.card.*" pageEncoding="UTF-8"%>

<%!private CardVO VillageShop(int i) {
    CardDAO cardDAO = new CardDAO();
    CardVO temp = cardDAO.getCard(i, "villageShop");
    return temp;
  }%>


<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0' />
<title>마을</title>
<script src='scripts/makeCardGame.js'></script>
<link rel='stylesheet' href='styles/villageStyle.css' />
</head>

<body>

	<div id="root">
		<div class="category">
			<div class="flex-box">

				<%
				for (int i = 0; i < 20; i++) {
				%>
				<div class="cardBorder">
					<div class="card-area">
						<div class="card-area-inner">
							<img src="images/card/<%=VillageShop(i).getCardName()%>.png" alt="<%=VillageShop(i).getCardName()%>" class="sellCard" />

							<div class="card-mana"><%=VillageShop(i).getCardConsumeMana()%></div>

							<div class="card-explain-area"><%=VillageShop(i).cardExplain()%></div>
							<div class="card-price"><%=VillageShop(i).getCardPrice()%></div>
						</div>
					</div>
				</div>
				<%
				}
				%>

			</div>
		</div>
		<!-- 여기에 카드 불러오는 로직만들어서 출력 일단 하나만 -->
		<div class="editDeck">
			<a href=editDeck.jsp>
				<img src="images/village/editDeck.png" alt="덱수정" class="editDeckIcon" />
				<button class="editDeckButton">덱수정</button>
			</a>
		</div>
		<div class="inToTheDungeon">
			<a href=dungeon.jsp>
				<img src="images/dungeonEntrance.png" alt="모험으로" class="inToTheDungeonIcon" />
				<button class="dungeonButton">입장하기</button>
			</a>
		</div>
	</div>
</body>
</html>