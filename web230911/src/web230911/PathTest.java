package web230911;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
  public static void test() {
    // String path
    // Path path = Paths.get("./");
    // System.out.println(path.toAbsolutePath());// 절대경로

    Path path = Paths.get("C:\\Users\\KGA\\git\\Java4\\web230911\\src");
    // System.out.println(path.toAbsolutePath());

    // Path path = Paths.get("src/web230911/../web230908"); // 뒤로 갔다가 앞으로 가라
    // System.out.println(path.toAbsolutePath().normalize());

    File file = new File(path.toString() + "\\Main1.java");
    System.out.println(file.exists());

    try {
      // file.createNewFile();
      file.mkdir();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
