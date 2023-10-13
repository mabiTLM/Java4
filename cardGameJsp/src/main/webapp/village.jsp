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

	<div id="root">
		<div class="category">
			<div class="flex-box">
				<div class="cardBorder">
					<img src="images/card/attack.png" alt="기본공격" class="sellCard" />
				</div>
				<div class="cardBorder">
					<img src="images/card/attack.png" alt="기본공격" class="sellCard" />
				</div>
				<div class="cardBorder">
					<img src="images/card/attack.png" alt="기본공격" class="sellCard" />
				</div>
				<div class="cardBorder">
					<img src="images/card/attack.png" alt="기본공격" class="sellCard" />
				</div>
				<div class="cardBorder">
					<img src="images/card/attack.png" alt="기본공격" class="sellCard" />
				</div>
				<div class="cardBorder">
					<img src="images/card/attack.png" alt="기본공격" class="sellCard" />
				</div>
				<div class="cardBorder">
					<img src="images/card/attack.png" alt="기본공격" class="sellCard" />
				</div>
				<div class="cardBorder">
					<img src="images/card/attack.png" alt="기본공격" class="sellCard" />
				</div>
				<div class="cardBorder">
					<img src="images/card/attack.png" alt="기본공격" class="sellCard" />
				</div>
				<div class="cardBorder">
					<img src="images/card/attack.png" alt="기본공격" class="sellCard" />
				</div>
				<div class="cardBorder">
					<img src="images/card/attack.png" alt="기본공격" class="sellCard" />
				</div>


			</div>
		</div>
		<!-- 여기에 카드 불러오는 로직만들어서 출력 일단 하나만 -->
		<div class="editDeck">
			<a href=editDeck.jsp>
				<img src="images/village/editDeck.png" alt="덱수정" class="editDeckIcon"/>
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