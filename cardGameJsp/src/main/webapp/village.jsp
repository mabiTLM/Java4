<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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

	<div class="root">
		<div class="area">
			<img src="images/village/shop.png" alt="상점" class="shop" />
		</div>
		<div class="category">
			<img src="images/card/attack.png" alt="기본공격" class="sellCard" />
		</div>
		<!-- 여기에 카드 불러오는 로직만들어서 출력 일단 하나만 -->
		<a href=editDeck.jsp>
			<div>
				<!-- 이미지 다른걸로 갈아끼기 -->
				<img src="images/deckEdit.png" alt="덱수정" class="editDeck" />
			</div>
		</a>
		<a href=dungeon.jsp>
			<div>
				<!-- 이미지 다른걸로 갈아끼기 -->
				<img src="images/dungeonEntrance.png" alt="모험으로" class="inToTheDungeon" />
			</div>
		</a>

	</div>

</body>
</html>