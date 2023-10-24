<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
int[][] mapData = (int[][]) request.getAttribute("mapData");
int[] playerLocation = (int[]) request.getAttribute("playerLocation");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>던전지도</title>
<link rel='stylesheet' href='styles/dungeon.css' />
</head>

<body>
	<div id="root">
		<!-- 몬스터를 누를경우 임시덱을 만들게해서 전투 도중 덱이 변경되도 다시 돌아올 수 있게해야한다. -->
		<!-- 한번만 랜덤으로 만들고 다시오면 고정되어야하니까 다른곳에서 맵생성을 처리해야한다. -->
		<div class="padding-box">
			<div class="map">
				<%
				for (int i = 0; i < 14; i++) {
				  for (int j = 0; j < 7; j++) {
				%>
				
				
				<%if(playerLocation[0]==i&&(playerLocation[1]==j||playerLocation[1]==j+1||playerLocation[1]==j-1)){
				  
				
				  %>
					<div class="can-click-box">
				
				<%}
				else{
				  %>
				<div class="cant-click-box">
					<%}
				%>
					<%
					switch (mapData[i][j]) {
					  case 1:
					%>
					<a href="elite.jsp">
						<img src="images/dungeon/moveIcon/elite.png" alt="엘리트" class="choice-icon">
					</a>
					<%
					break;
					case 2:
					%>
					<a href="normal.jsp">
						<img src="images/dungeon/moveIcon/normal.png" alt="일반적" class="choice-icon">
					</a>
					<%
					break;
					case 3:
					%>
					<a href="event.jsp">
						<img src="images/dungeon/moveIcon/event.png" alt="던전지도" class="choice-icon">
					</a>
					<%
					break;
					case 4:
					%>
					<a href="fire.jsp">
						<img src="images/dungeon/moveIcon/fire.png" alt="모닥불" class="choice-icon">
					</a>
					<%
					break;
					case 5:
					%>
					<a href="dungeonShop.jsp">
						<img src="images/dungeon/moveIcon/dungeonShop.png" alt="상점" class="choice-icon">
					</a>
					<%
					break;
					}
					%>
				</div>
				<%
				}
				}
				%>
			</div>
		</div>
	</div>
</body>
</html>