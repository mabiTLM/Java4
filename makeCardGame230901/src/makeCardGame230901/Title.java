package makeCardGame230901;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class Title {
  Build b;

  void title() {
    while (true) {
      Scanner scan = new Scanner(System.in);
      try {
        System.out.println("1.새로운 시작");
        System.out.println("2.불러오기");
        int choice = scan.nextInt();
        scan.nextLine();
        if (choice == 1) {
          b = new Build();

        } else if (choice == 2) {// 불러온 b를 b에 집어넣어야한다.
          System.out.println("몇번 데이터를 불러옵니까?");
          choice = scan.nextInt();
          scan.nextLine();
          load(choice);
        }
        b.build();
        break;

      } catch (Exception e) {
        scan.nextLine();
        e.printStackTrace();
      }
    }
  }

  void load(int saveNumber) {
    try {
      String path =
          "C:\\Users\\KGA\\git\\Java4\\makeCardGame230901\\save\\savedata" + saveNumber + ".db";
      FileInputStream fis = new FileInputStream(path);
      ObjectInputStream ois = new ObjectInputStream(fis);
      b = (Build) ois.readObject();
    } catch (Exception e) {
      e.getStackTrace();
    }
  }
}
