package web230911;

import java.util.Arrays;
import java.util.OptionalDouble;

public class OptionsTest {
  public static void test() {
    int[] arr = {1, 3, 5, 7};
    int[] arr1 = {2, 4, 6, 8, 9};

    System.out.println(Arrays.stream(arr).filter(item -> item % 3 == 0).count());
    Arrays.stream(arr).filter(item -> item % 3 == 0).forEach(i -> System.out.println(i));

    System.out.println(Arrays.stream(arr1).filter(item -> item % 3 == 0).count());

    System.out.println(Arrays.stream(arr).sum());
    System.out.println(Arrays.stream(arr1).sum());


    System.out.println(Arrays.stream(arr).average().getAsDouble());
    System.out.println(Arrays.stream(arr1).average().getAsDouble());

    System.out.println(Arrays.stream(arr).max().getAsInt());
    System.out.println(Arrays.stream(arr).min().getAsInt());

    int[] arr2 = {};
    try {
      System.out.println(Arrays.stream(arr2).average().getAsDouble());
    } catch (Exception e) {
      e.printStackTrace();
      OptionalDouble od = Arrays.stream(arr2).average();
      if (od.isPresent()) {
        System.out.println(od.getAsDouble());
      } else {
        System.out.println("없어");
      }
      System.out.println(Arrays.stream(arr).average().orElse(0.0));
      System.out.println(Arrays.stream(arr2).average().orElse(0.0));

      Arrays.stream(arr2).average().ifPresent(item -> System.out.println("예외" + item));// 문제가 없다면 출력

      System.out.println(Arrays.stream(arr).reduce(0, (a, b) -> a + b / 2 + 1));
      // reduce(시작, (기존꺼,뒤에꺼)-> 계산식
      // 리듀스의 사용법 내부에 ArrayList를 넣는다던지 배열을 바꾼다던지 하는곳에서 사용 가능
    }
  }
}
