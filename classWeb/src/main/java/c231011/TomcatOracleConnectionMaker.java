package c231011;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class TomcatOracleConnectionMaker implements ConnectionMaker {
  public Connection makeConnection() throws Exception {
    Context ctx = new InitialContext();
    Context envContext = (Context) ctx.lookup("java:/comp/env");
    DataSource dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
    return dataFactory.getConnection();
  }
}
