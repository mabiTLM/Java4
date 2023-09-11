package web230911;

import web230911.buffered.BufferedTest;
import web230911.byteStream.OutputStreamTest;
import web230911.fileIO.FileIOTest;
import web230911.fileIO.SubTest;

public class Main {
  public static void main(String[] args) {
    MatchTest.test();
    OptionsTest.test();
    OutputStreamTest.test();
    FileIOTest.test();
    SubTest.test();
    BufferedTest.test();
  }
}
