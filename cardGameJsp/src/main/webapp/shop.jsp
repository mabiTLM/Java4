<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="servletTest.card.*" pageEncoding="UTF-8"%>
<%!CardDAO cardDAO = new CardDAO();

  private CardVO dungeonShop(int i) {
    CardVO temp = cardDAO.getCard(i,"dungeonshop");
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

			<%
			for (int i = 0; i < cardDAO.dBLengthCheck("dungeonshop"); i++) {
			%>

			<div class="cardBorder">
				<img src="images/card/<%=dungeonShop(i).getCardName()%>.png" alt="<%=dungeonShop(i).getCardName()%>" class="sellCard" />
			</div>
			<%
			}
			%>			

		</div>


	</div>

</body>
</html>