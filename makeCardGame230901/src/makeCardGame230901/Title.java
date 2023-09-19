package makeCardGame230901;

import java.io.Serializable;
import java.util.Scanner;

public class Title implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 543632777029542776L;
  Build b;
  SettingMenu settingMenu = new SettingMenu();

  void title() {
    Scanner scan = new Scanner(System.in);
    while (true) {
      try {
        System.out.println("1.새로운 시작");
        System.out.println("2.불러오기");
        int choice = scan.nextInt();
        scan.nextLine();
        if (choice == 1) {
          System.out.println("잠깐 세상좀 구하고 올게");
          scan.nextLine();
          b = new Build();
          b.build();

        } else if (choice == 2) {// 불러온 b를 b에 집어넣어야한다.
          settingMenu.load(b);
        }

      } catch (Exception e) {
        scan.nextLine();
        e.printStackTrace();
      }
    }
  }
}
