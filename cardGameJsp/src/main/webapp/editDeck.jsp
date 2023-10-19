<%@ page language="java" contentType="text/html; charset=UTF-8" import="servletTest.card.*" pageEncoding="UTF-8"%>

<%!CardDAO cardDAO = new CardDAO();

  private CardVO Inventory(int i) {
    CardVO temp = cardDAO.getCard(i);
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


	<div id="root">
		<div class="inventory">
			<div class="inventory-area">

				<%
				for (int i = 0; i < cardDAO.DBLengthCheck("cardinventory"); i++) {

				  if (Inventory(i).getIsInDeck().equals("false")) {
				%>

				<form action="editDeck" method='post' class="inventory-card-area">
					<div class="card-area-inner">
						<input type="hidden" name="card-index" value="<%=i%>" />
						<input type="hidden" name="is-in-deck" value="true" />
						<button class="in-to-deck-button">
							<img src="images/card/<%=Inventory(i).getCardName()%>.png" alt="<%=Inventory(i).getCardName()%>" class="inventoryCard" />
							<div class="card-mana"><%=Inventory(i).getCardConsumeMana()%></div>
							<div class="card-explain-area"><%=Inventory(i).cardExplain()%></div>
						</button>
					</div>

				</form>
				<%
				}
				}
				%>
			</div>
		</div>

		<div class="deck">
			<div class="deck-area">

				<%
				for (int i = 0; i < cardDAO.DBLengthCheck("cardinventory"); i++) {
				  if (Inventory(i).getIsInDeck().equals("true")) {
				%>

				<form action="editDeck" method='post' class="deck-in-card">
					<div class="deck-area-inner">
						<input type="hidden" name="card-index" value="<%=i%>" />
						<input type="hidden" name="is-in-deck" value="false" />
						<button class="in-to-deck-button">
							<div class="deck-in-card-text">
								<div class="deck-in-card-mana"><%=Inventory(i).getCardConsumeMana()%></div>
								<div class="deck-in-card-name"><%=Inventory(i).getCardName()%></div>
							</div>
							<img src="images/card/inDeck/<%=Inventory(i).getCardName()%>.png" alt="<%=Inventory(i).getCardName()%>" class="deck-in-cardimg" />
						</button>
					</div>
				</form>

				<%
				}
				}
				%>


			</div>
		</div>
		<div class="edit-button-area">
			<div class="edit-button">
				<a href="village.jsp">
					<button class="edit-deck-finish">완료</button>
				</a>
			</div>
		</div>


	</div>

</body>
</html>