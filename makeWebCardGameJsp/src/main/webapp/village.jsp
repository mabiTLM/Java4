<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<meta name='viewport'content='width=device-width, initial-scale=1.0' />
<title>마을</title>
<script src='scripts/makeCardGame.js'></script>
<link rel='stylesheet' href='styles/villageStyle.css' />
</head>

<body>

<div>

<div>
<img src="images/village.png" alt="상점" class="shop"/>

	<a href = editDeck.jsp>
	<div>
	<img src="images/deckEdit.png" onmouseover="this.src='images/deckEditOpen.png'" onmouseout="this.src='images/deckEdit.png'" alt="덱수정" class="editDeck"/>
	</div>
 	</a>
	<a href = dungeon.jsp>
	<div> 
	<img src="images/dungeonEntrance.png" onmouseover="this.src='images/dungeonEntranceOpen.png'" onmouseout="this.src='images/dungeonEntrance.png'" alt="모험으로" class="inToTheDungeon"/>
	</div>
    </a>
    
    </div>
    
</div>
    
</body>
</html>