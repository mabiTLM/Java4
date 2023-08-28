package NumberPuzzleOOP_0828;

 

public class Moving

{

protected Player player;

 

public void setPlayer(Player player)// 이거 넣으면 다른곳에서 안바꿔도된다.

{

this.player = player;

}

 

protected boolean movePlayer(int[][] puzzle, int direction) //자체행동도 있으니 is처리안한다

{

int playerX= player.getX();

int playerY= player.getY();

int movingPlayerX = playerX;

int movingPlayerY = playerY;

switch(direction)

{

case 2:

movingPlayerY++;

break;

case 4:

movingPlayerX--;

break;

case 6:

movingPlayerX++;

break;

case 8:

movingPlayerY--;

break;

default:

break;

}

if(getIsOut(puzzle,movingPlayerY,movingPlayerX))

{

return false;

}

Shuffle.changeArray(puzzle, playerX, playerY, movingPlayerX, movingPlayerY);

player.setPosition(movingPlayerX, movingPlayerY);

return true;

}

 

// protected boolean movePlayer(int[][] puzzle, String direction)

// {

// int playerX= player.getX();

// int playerY= player.getY();

// int movingPlayerX = playerX;

// int movingPlayerY = playerY;

// switch(direction) //스트링이 받아지나..?

// {

// case "후":

// movingPlayerY++;

// break;

// case "좌":

// movingPlayerX--;

// break;

// case "우":

// movingPlayerX++;

// break;

// case "상":

// movingPlayerY--;

// break;

// default:

// break;

// }

// if(getIsOut(puzzle,movingPlayerY,movingPlayerX))

// {

// return false;

// }

// Shuffle.changeArray(puzzle, playerX, playerY, movingPlayerX, movingPlayerY);

// player.setPosition(movingPlayerX, movingPlayerY);

// return true;

// }

 

 

private boolean getIsOut(int[][] arr, int movingPlayerY, int movingPlayerX)

{

if(movingPlayerX>arr[0].length-1||

movingPlayerX<0||

movingPlayerY>arr.length-1||

movingPlayerY<0

)return true;

return false;

}

 

}

 