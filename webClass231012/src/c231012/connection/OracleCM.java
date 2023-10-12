package c231012.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleCM implements ConnectionMaker {
  // DB와 통신하는 생성
  @Override
  public Connection makeConnection() throws Exception {
    Class.forName("oracle.jdbc.OracleDriver");
    return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "java", "qwer");
  }
}
