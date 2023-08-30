package NumberPuzzleOOP_0828;

 

public class Shuffle

{

public static void changeArray(

int[][] arr,

int idx1X,

int idx1Y,

int idx2X,

int idx2Y

)

{

int temp = arr[idx1Y][idx1X];

arr[idx1Y][idx1X] = arr[idx2Y][idx2X];

arr[idx2Y][idx2X] = temp;

}

}