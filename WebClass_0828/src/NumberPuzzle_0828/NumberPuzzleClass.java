package NumberPuzzle_0828;

 

import java.util.Scanner;

 

public class NumberPuzzleClass

{

 

public static void main(String[] args)

{

int[][] arr = new int[5][5];

int playerX= 4;

int playerY= 4;

Scanner scanner = new Scanner(System.in);

for(int i = 0; i <5;i++)

{

for(int j = 0; j <5;j++)

{

arr[i][j] = i*5+j+1;

}

}

 

arr[playerY][playerX]=0;

 

// for(int i = 0; i<1000; i++)

// {

// int num1 = (int) (Math.random()*5);

// int num2 = (int) (Math.random()*5);

// int num3 = (int) (Math.random()*5);

// int num4 = (int) (Math.random()*5);

//

// int temp = arr[num1][num2];

// arr[num1][num2]=arr[num3][num4];

// arr[num3][num4]= temp;

// }

 

 

// for(int i = 0; i <1000;i++)

// {

// int temp = (int)(Math.random()*4+1)*2;

// int[] playerPosition = NumberPuzzleClass.move(arr,playerY,playerX,temp);

// playerX = playerPosition[0];

// playerY = playerPosition[1];

//// boolean isShuffle=shuffle(arr,playerY,playerX,temp);

//// if(isShuffle)

//// {

//// switch(temp)

//// {

//// case 2:

//// playerY=playerY+1;

//// break;

//// case 4:

//// playerX-=1;

//// break;

//// case 6:

//// playerX++;

//// break;

//// case 8:

//// --playerY;

//// break;

////

//// }

//// }

// }

 

System.out.println("자, 게임을 시작하자.");

 

for(int i = 0; i <5;i++)

{

for(int j = 0; j <5;j++)

{

if(arr[i][j]==0)

{

System.out.print("p\t");}

else

{

System.out.print(arr[i][j]+"\t");

}

}

System.out.print("\n");

}

 

 

while(true)

{

boolean isEnding = true;

for(int i = 0; i < 5; i++)

{

if(isEnding == false) break;

for(int j = 0; j < 5; j++)

{

if(i==4&&j==4)break;

if(arr[i][j]!=i*5+j+1)

{

isEnding= false;

}

}

}

if(isEnding)

{

System.out.println("탈출해라");

break;

}

System.out.println("p를 이동해 퍼즐을 맞춰라.");

System.out.println("8 : 상 / 2 : 하 / 4 : 좌 / 6 : 우");

int input = scanner.nextInt();

int[] playerPosition = NumberPuzzleClass.move(arr,playerY,playerX,input);

playerX = playerPosition[0];

playerY = playerPosition[1];

 

// boolean isShuffle=shuffle(arr,playerY,playerX,input);

//

// if(isShuffle)

// {

// switch(input)

// {

// case 2:

// playerY=playerY+1;

// break;

// case 4:

// playerX-=1;

// break;

// case 6:

// playerX++;

// break;

// case 8:

// --playerY;

// break;

//

// }

// }

 

for(int i = 0; i <5;i++)

{

for(int j = 0; j <5;j++)

{

if(arr[i][j]==0)

{

System.out.print("p\t");}

else

{

System.out.print(arr[i][j]+"\t");

}

}

System.out.print("\n");

}

}

}

 

static boolean shuffle(int[][] arr, int idx1, int idx2, int direction)

{

int temp = arr[idx1][idx2];

switch(direction)

{

case 2:

if(idx1==4) return false;

arr[idx1][idx2] = arr[idx1+1][idx2];

arr[idx1+1][idx2]=temp;

return true;

case 4:

if(idx2==0) return false;

arr[idx1][idx2] = arr[idx1][idx2-1];

arr[idx1][idx2-1]=temp;

return true;

case 6:

if(idx2==4) return false;

arr[idx1][idx2] = arr[idx1][idx2+1];

arr[idx1][idx2+1]=temp;

return true;

case 8:

if(idx1==0) return false;

arr[idx1][idx2] = arr[idx1-1][idx2];

arr[idx1-1][idx2]=temp;

return true;

 

default:

return true;

}

}

 

public static int[] move(int[][] arr,int playerY,int playerX,int temp)

{

boolean isShuffle=shuffle(arr,playerY,playerX,temp);

if(isShuffle)

{

switch(temp)

{

case 2:

playerY=playerY+1;

break;

case 4:

playerX-=1;

break;

case 6:

playerX++;

break;

case 8:

--playerY;

break;

 

}

}

return new int[]{playerX,playerY};

}

}