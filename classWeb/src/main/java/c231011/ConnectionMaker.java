package c231011;

import java.sql.Connection;

public interface ConnectionMaker {
  public Connection makeConnection() throws Exception;
}
