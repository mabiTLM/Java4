package test;

import java.util.Scanner;

public class testFindLetter {
  public static void main(String[] args) {

    // 문제마다 클래스를 새로파서 주석으로 달아놨습니다.

    Find find = new Find();
    Reverse reverse = new Reverse();
    StringTrim removeBlank = new StringTrim();
    UpperLower upperLower = new UpperLower();
    FindChar findChar = new FindChar();
    HowManyLetter howManyLetter = new HowManyLetter();
    Prime prime = new Prime();
    Calculate calculate = new Calculate();
    FindArray findArray = new FindArray();
    UpdownGame updownGame = new UpdownGame();

    find.findInString('a', "abcda");

    reverse.reverseString("잘뒤집어지나");

    removeBlank.trimString("공백이 잘 지워 집니다.");

    upperLower.upperLowerChaneg("aBcDeeF");

    System.out.println(findChar.findCharIndex("Hello, World", 'o'));

    System.out.println(howManyLetter.countWords("I am a boy"));

    System.out.println(prime.isPrime(7));

    System.out.println(calculate.calculateDigitSum(123456789));

    int[] printFindArray = findArray.FindCommonItems(new int[] {1, 5, 5, 10},
        new int[] {3, 4, 5, 5, 10}, new int[] {5, 5, 10, 20});
    for (int i = 0; i < printFindArray.length; i++) {
      System.out.print(printFindArray[i]);
      if (i == printFindArray.length - 1) {
        System.out.println();
      } else {
        System.out.print(",");
      }
    }

    updownGame.updownGame();


  }
}


/**
 * 주어진 문자열에서 특정 문자의 개수를 세는 프로그램을 작성하라.
 **/
class Find {
  void findInString(char target, String find) {

    char[] temp = find.toCharArray();

    int result = 0;
    for (int i = 0; i < temp.length; i++) {
      if (temp[i] == target) {
        result++;
      }
    }
    System.out.println(target + "에는 " + find + "가 " + result + "개 있다.");
  }
}


/**
 * 주어진 문자열을 거꾸로 뒤집는 프로그램을 작성하라
 **/
class Reverse {
  void reverseString(String target) {

    char[] temp = target.toCharArray();
    String reverseTemp = "";
    for (int i = 0; i < temp.length; i++) {
      reverseTemp += temp[temp.length - 1 - i];
    }
    System.out.println(target + "(을)를 뒤집으면 " + reverseTemp);
  }
}


/**
 * 문자열에서 모든 공백을 제거하는 프로그램을 작성하라
 **/
class StringTrim {
  void trimString(String target) {
    System.out.println(target + "의 공백을 제거하면 " + target.replace(" ", ""));

  }
}


/**
 * 주어진 문자열에서 모든 소문자를 대문자로 바꾸고 대문자는 소문자로 바꾸는 프로그램을 작성하라.
 **/
class UpperLower {
  void upperLowerChaneg(String target) {
    char[] temp = target.toCharArray();
    char[] uppertemp = target.toUpperCase().toCharArray();
    char[] lowertemp = target.toLowerCase().toCharArray();
    String result = "";

    for (int i = 0; i < temp.length; i++) {
      if (temp[i] == uppertemp[i]) {
        result += lowertemp[i];
      } else {
        result += uppertemp[i];
      }
    }
    System.out.println(target + "의 대소문자를 뒤집으면 " + result);
  }

}


/**
 * 문자열 속에 문자 찾기를 수행하는 함수를 완성하라
 **/
class FindChar {
  public static int findCharIndex(String str, char targetChar) {
    return str.indexOf(targetChar);
  }
}


/**
 * 문자열을 입력받으면 단어의 갯수를 출력하는 함수를 완성하라.
 **/
class HowManyLetter {

  public static int countWords(String str) {

    int result = 0;

    if (!str.isEmpty()) {
      String[] temp = str.split(" ");
      result = temp.length;
    }

    return result;
  }
}


/**
 * 주어진 숫자가 소수인지 판별하는 solution을 완성하라.
 **/
class Prime {

  public static boolean isPrime(int num) {
    boolean result = true;
    for (int i = 2; i < num; i++) {
      if (num % i == 0) {
        result = false;
        break;
      }
    }
    if (num < 2) {
      result = false;
    }
    return result;
  }
}


/**
 * 사용자가 입력한 양의 정수의 각 자리수의 합을 구하는 Solution 을 완성하라.
 **/
class Calculate {
  public static int calculateDigitSum(int num) {

    int result = 0;

    while (true) {
      if (num <= 0) {
        break;
      }
      result += num % 10;
      num = num / 10;

    }
    return result;
  }
}


/**
 * k개의 정렬된 배열에서 공통항목을 찾는 Solution을 완성하라.단, 중복은 허용하지 않는다.
 **/
class FindArray {

  static int[] FindCommonItems(int[] arr1, int[] arr2, int[] arr3) {

    int[] resultArr1Arr2 = {};
    int[] resultArr2Arr3 = {};

    int[] result = {};

    for (int i = 0; i < arr1.length; i++) {
      for (int j = 0; j < arr2.length; j++) {
        if (arr1[i] == arr2[j]) {
          resultArr1Arr2 = add(resultArr1Arr2, arr2[j]);
        }
      }
    }

    for (int i = 0; i < arr3.length; i++) {
      for (int j = 0; j < arr2.length; j++) {
        if (arr2[j] == arr3[i]) {
          resultArr2Arr3 = add(resultArr2Arr3, arr2[j]);
        }
      }
    }

    for (int i = 0; i < resultArr1Arr2.length; i++) {
      for (int j = 0; j < resultArr2Arr3.length; j++) {
        if (resultArr2Arr3[j] == resultArr1Arr2[i]) {
          result = add(result, resultArr2Arr3[j]);
        }
      }
    }


    return result;
  }

  static int[] add(int[] result, int num) {

    boolean same = false;
    int[] temp = result;

    for (int i = 0; i < result.length; i++) {
      if (result[i] == num) {
        same = true;
        break;
      }
    }

    if (!same) {
      temp = new int[result.length + 1];

      for (int i = 0; i < result.length; i++) {
        temp[i] = result[i];
      }
      temp[result.length] = num;
    }

    return temp;
  }

}


/**
 * Up & Down 게임 만들기
 **/
class UpdownGame {

  void updownGame() {
    Scanner scan = new Scanner(System.in);
    int choice = 0;
    boolean gameOn = true;
    while (gameOn) {
      int answer = (int) (Math.random() * 1000);
      int canCollect = 10;

      while (canCollect > 0) {
        System.out.println("남은 횟수 : " + canCollect);

        System.out.print("숫자를 골라주세요 : ");

        try {
          choice = scan.nextInt();
          canCollect--;

          if (choice > answer) {
            System.out.println("숫자가 정답보다 큽니다.");
          } else if (choice < answer) {
            System.out.println("숫자가 정답보다 작습니다.");
          } else {
            System.out.println("정답 입니다.");
            break;
          }


        } catch (Exception e) {
          scan.nextLine();
          System.out.println("숫자만 입력해주세요");
          e.printStackTrace();
        }
      } // 내부while

      while (true) {
        System.out.println("1.재시작 2.종료");
        try {
          choice = scan.nextInt();
          scan.nextLine();
          if (choice == 1) {
            break;
          } else if (choice == 2) {
            gameOn = false;
            break;
          } else {
            System.out.println("다시 입력해주세요");
          }
        } catch (Exception e) {
          scan.nextLine();
          System.out.println("숫자만 입력해주세요");
          e.printStackTrace();
        }
      }
    } // 재시작 while
  }

}

