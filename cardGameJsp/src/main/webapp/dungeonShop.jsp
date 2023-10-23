<%@ page language="java" contentType="text/html; charset=UTF-8" import="servletTest.card.*" pageEncoding="UTF-8"%>
<%!CardDAO cardDAO = new CardDAO();

  private CardVO dungeonShop(int i) {
    CardVO temp = cardDAO.getCard(i, "dungeonshop");
    return temp;
  }%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>던전 상점</title>
<link rel='stylesheet' href='styles/dungeonShop.css' />
</head>
<body>

	<div id="root">

		<div class="padding-box">

			<div class="sell-card-area">

				<%
				for (int i = 0; i < cardDAO.dBLengthCheck("dungeonshop"); i++) {
				%>
				<form action="dungeonShop" method='post' class="buy-form-area">
					<div class="card-area-inner">
						<input type="hidden" name="card-index" value="<%=i%>" />
						<button class="buy-button">
							<img src="images/card/<%=dungeonShop(i).getCardName()%>.png" alt="<%=dungeonShop(i).getCardName()%>" class="sellCard" />
							<div class="card-mana"><%=dungeonShop(i).getCardConsumeMana()%></div>
							<div class="card-name"><%=dungeonShop(i).getCardName()%></div>
							<div class="card-explain-area"><%=dungeonShop(i).cardExplain()%></div>
							<div class="card-price-area"><%=dungeonShop(i).getCardPrice()%></div>
						</button>
					</div>
				</form>
				<%
				}
				%>

			</div>
		</div>

	</div>

</body>
</html>