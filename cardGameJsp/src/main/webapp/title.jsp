<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0' />
<title>시작화면</title>
<link rel='stylesheet' href='styles/title.css' />
</head>
<body>

	<div id="root">

		<div class="padding-box">
			<div class="startButton">
				<form action='title' method='post'>
					<input type='submit' name='start' value='새로운 시작' style='text-align: center; font-size: 50px' class="titleButton">
				</form>
			</div>
			<br/>
			<div class="loadButton">
				<form action='title' method='post'>
					<input type='submit' name='start' value='이어하기' style='text-align: center; font-size: 50px' class="titleButton">
				</form>
			</div>
		</div>
	</div>
</body>
</html>