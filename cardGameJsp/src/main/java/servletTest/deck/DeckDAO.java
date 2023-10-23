package servletTest.deck;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DeckDAO {
  private Connection con;


  public void createTableDeck() {
    try {
      connect();
      String createDeckQuery = "create table Deck (id number(10,0) not null,"
          + "name varchar2(20) not null, type varchar2(20) not null,cardvalue number(10,0) not null,consumeMana number(10,0) not null,"
          + "price number(10,0) not null,effect varchar2(20) default '통상',"
          + "effectValue number(10,0) default 0,enforce varchar2(10) default 'false',"
          + "volatility varchar2(10) default 'false')";
      PreparedStatement crePstmt = con.prepareStatement(createDeckQuery);
      crePstmt.executeUpdate();
      crePstmt.close();
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }


  public void dropTableDeck() {
    try {
      connect();
      String deleteQuery = "drop table deck";
      PreparedStatement stmt = con.prepareStatement(deleteQuery);
      stmt.executeUpdate();
      stmt.close();
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void connect() throws Exception {
    Context ctx = new InitialContext();
    Context envContext = (Context) ctx.lookup("java:/comp/env");
    DataSource dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
    con = dataFactory.getConnection();
  }

}
