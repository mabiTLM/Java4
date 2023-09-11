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

  // void load() {
  // Scanner scan = new Scanner(System.in);
  // try {
  // System.out.println("몇번 데이터를 불러옵니까?");
  // int choice = scan.nextInt();
  // scan.nextLine();
  // String path =
  // "C:\\Users\\KGA\\git\\Java4\\makeCardGame230901\\save\\savedata" + choice + ".db";
  // FileInputStream fis = new FileInputStream(path);
  // ObjectInputStream ois = new ObjectInputStream(fis);
  //
  // this.b = (Build) ois.readObject();
  // b.build();
  //
  // } catch (Exception e) {
  // e.printStackTrace();
  // }
  // }
}
