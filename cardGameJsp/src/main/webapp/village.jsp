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
		<div class="havegold">10000G</div>

		<div class="goldimg-area">
			<img src="images/village/gold.png" alt="금화주머니" class="havegoldimg" />
		</div>

		<div class="category">
			<div class="flex-box">

				<%
				CardDAO cardDAO = new CardDAO();
				for (int i = 0; i < cardDAO.DBLengthCheck("villageshop"); i++) {
				%>
				<div class="cardBorder">
					<!-- 영역자체를 form으로해서 보내자 -->
					<form action='village' method='post' class="card-area">
						<div class="card-area-inner">
							<input type="hidden" name="card-index" value="<%=i%>" />
							<button class="buy-button">
								<img src="images/card/<%=VillageShop(i).getCardName()%>.png" alt="<%=VillageShop(i).getCardName()%>" class="sellCard" />
								<div class="card-mana"><%=VillageShop(i).getCardConsumeMana()%></div>
								<div class="card-explain-area"><%=VillageShop(i).cardExplain()%></div>
								<div class="card-price"><%=VillageShop(i).getCardPrice()%></div>
							</button>
						</div>

					</form>
				</div>
				<%
				}
				%>

			</div>
		</div>
		<div class="editDeck">
			<a href=editDeck.jsp>
				<img src="images/village/editDeck.png" alt="덱수정" class="editDeckIcon" />
				<button class="editDeckButton">덱수정</button>
			</a>
		</div>
		<div class="inToTheDungeon">
			<form action="village.jsp">
			<!-- 이거눌렀을때 deck DB만들게하자 기존 전투에서 임시덱쓰던것처럼 -->
				<img src="images/dungeonEntrance.png" alt="모험으로" class="inToTheDungeonIcon" />
				<button class="dungeonButton">입장하기</button>
			</form>
		</div>
	</div>
</body>
</html>