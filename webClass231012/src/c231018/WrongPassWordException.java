package c231018;

public class WrongPassWordException extends Exception {

  WrongPassWordException(String message) {
    super(message);
  }

  // 사용처는?
  // 1. Bean 2. DAO 3. Servlet 4. FrontEnd(jsp) 3번에서 체크하는게 맞다.

}
