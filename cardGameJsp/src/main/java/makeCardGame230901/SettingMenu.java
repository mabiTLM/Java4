package makeCardGame230901;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
import makeCardGame230901.characterBundle.PlayerCharacter;

public class SettingMenu implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 8225874556481421357L;

  public void printSettingMenu(PlayerCharacter player, Build build) {
    Scanner scan = new Scanner(System.in);
    while (true) {
      try {
        player.setOpenMenu(false);
        System.out.println("1.저장하기");
        System.out.println("2.불러오기");
        System.out.println("3.돌아간다.");
        int choice = scan.nextInt();
        scan.nextLine();

        if (choice == 1) {
          save(build);
        }

        else if (choice == 2) {
          load(build);
        }

        else if (choice == 3) {
          break;
        }
      }

      catch (Exception e) {
        scan.nextLine();
        e.printStackTrace();
      }
    }
  }


  public void save(Build build) {
    try {
      Scanner scan = new Scanner(System.in);
      System.out.println("몇번칸에 저장하나요?");
      int saveNumber = scan.nextInt();
      scan.nextLine();
      String path =
          SettingMenu.class.getResource("").getPath().replace("bin/makeCardGame230901/", "save");
      File file = new File(path);
      if (!file.exists()) {
        file.mkdir();
      }
      FileOutputStream fos = new FileOutputStream(path + "/savedata" + saveNumber + ".db");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(build);
      oos.flush();
      oos.close();
      fos.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void load(Build build) {
    Scanner scan = new Scanner(System.in);
    try {
      System.out.println("몇번 데이터를 불러옵니까?");
      int choice = scan.nextInt();
      scan.nextLine();
      String path = SettingMenu.class.getResource("").getPath().replace("bin/makeCardGame230901/",
          "save/savedata") + choice + ".db";
      FileInputStream fis = new FileInputStream(path);
      ObjectInputStream ois = new ObjectInputStream(fis);

      build = (Build) ois.readObject();
      build.build();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
