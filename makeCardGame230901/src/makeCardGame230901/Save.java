package makeCardGame230901;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
import makeCardGame230901.characterBundle.PlayerCharacter;

public class Save implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 8225874556481421357L;

  public void save(PlayerCharacter player, Build build) {
    try {
      player.setSave(false);
      Scanner scan = new Scanner(System.in);
      System.out.println("몇번칸에 저장하나요?");
      int saveNumber = scan.nextInt();
      scan.nextLine();
      String path =
          "C:\\Users\\KGA\\git\\Java4\\makeCardGame230901\\save\\savedata" + saveNumber + ".db";
      FileOutputStream fos = new FileOutputStream(path);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(build);
      oos.flush();
      oos.close();
      fos.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
