package web230911.fileIO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;


public class FileIOTest {
  public static void test() {
    try {
      Writer writer = new FileWriter(
          "C:/Users/KGA/eclipse-workspace/web230911/src/web230911/byteStream/test.txt");
      writer.write('a');
      writer.write("bc");
      writer.write("가나다라");
      // writer.write("글적기");
      writer.flush();
      writer.close();

      Reader reader = new FileReader(
          "C:/Users/KGA/eclipse-workspace/web230911/src/web230911/byteStream/test.txt");

      char[] arr = new char[10];

      int count = reader.read(arr);

      System.out.println(count + " : " + new String(arr, 0, count));
      // while (true) {
      // System.out.println((char) reader.read());
      // if (reader.read() == -1) {
      // break;
      // }
      // }

      reader.close();
    } catch (Exception e) {

    }
  }

}
