<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="servletTest.card.*" pageEncoding="UTF-8"%>

<%!private CardVO Inventory(int i) {
    CardDAO cardDAO = new CardDAO();
    CardVO temp = cardDAO.getCard(i, "cardInventory");
    return temp;
  }%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>덱 수정 화면</title>
<link rel='stylesheet' href='styles/editDeck.css' />
</head>
<body>
	<!-- 일단 임시 카드 두개 -->
	<div id="root">
		<div class="inventory">
			<div class="inventory-area">
			
			<!-- 길이를 받아오는 함수를 만들어야 한다. 다른 애들도 임시 숫자말고 -->
			
				<div class="card">
					<img src="images/card/attack.png" alt="카드" />
					<div class="mana"></div>
				</div>
				<div class="card">
					<img src="images/card/attack.png" alt="카드" />
					<div class="mana"></div>
				</div>

			</div>
		</div>
		<div class="deck">
			<div class="deck-area">
				<div class="deck-in-card">
					<img src="images/card/inDeck/tempCard.png" alt="카드" class="deck-in-card" />
				</div>
			

				<div class="edit-button">
					<a href="village.jsp">완료</a>
				</div>
			</div>
		</div>



	</div>

</body>
</html>