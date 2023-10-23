<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<div class="box">
					<a href="elite.jsp"> <img src="images/dungeon/elite.png"
						alt="엘리트" class="elite">
					</a>
				</div>
				<div class="box">
					<a href="normal.jsp"> <img src="images/dungeon/normal.png"
						alt="일반적" class="elite">
					</a>
				</div>
				<div class="box">
					<a href="fire.jsp"> <img src="images/dungeon/fire.png"
						alt="모닥불" class="elite">
					</a>
				</div>

				<div class="box">
					<a href="dungeonShop.jsp"> <img src="images/dungeon/dungeonShop.png"
						alt="상점" class="elite">
					</a>
				</div>

				<div class="box">
					<a href="event.jsp"> <img src="images/dungeon/event.png"
						alt="던전지도" class="elite">
					</a>
				</div>
			</div>
		</div>
	</div>

</body>
</html>