package NumberPuzzleOOP_0828;

 

import java.util.Scanner;

 

public class Main

{

public static void main(String[] args)

{

Puzzle puzzle = new Puzzle();

Player player = new Player();

 

puzzle.setPlayer(player);

 

Scanner scanner = new Scanner(System.in);

System.out.println("퍼즐의 길이?");

int countX = scanner.nextInt();

System.out.println("퍼줄의 줄수?");

int countY = scanner.nextInt();

puzzle.setPuzzle(countX,countY);

puzzle.print();

while(true)

{

if(puzzle.getIsEnd())break;

System.out.println("p를 옮겨서 1 ~ " + (countY * countX -1) + "순서로 맞춰라.");

System.out.println("2 : 하 / 8 : 상 / 4 : 좌 / 6 : 우");

int direction = scanner.nextInt();

 

if(direction == 0) break;

if(direction == 5) puzzle.shuffle();

 

puzzle.movePlayer(direction);

puzzle.print();

}

System.out.println("끝");

}

}