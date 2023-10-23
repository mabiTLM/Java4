package servletTest.card.cardDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DropTable {

  public DropTable() {

  }

  private Connection con;



  public void dropTableDeck() throws Exception {
    connect();
    String deleteQuery = "drop table deck";
    PreparedStatement stmt = con.prepareStatement(deleteQuery);
    stmt.executeUpdate();
    stmt.close();
    con.close();
  }

  public void dropTableVillageShop() throws Exception {
    connect();
    String deleteQuery = "drop table villageShop";
    PreparedStatement stmt = con.prepareStatement(deleteQuery);
    stmt.executeUpdate();
    stmt.close();
    con.close();
  }

  public void dropTableCardInventory() throws Exception {
    connect();
    String deleteQuery = "drop table cardInventory";
    PreparedStatement stmt = con.prepareStatement(deleteQuery);
    stmt.executeUpdate();
    stmt.close();
    con.close();
  }

  private void connect() throws Exception {
    Context ctx = new InitialContext();
    Context envContext = (Context) ctx.lookup("java:/comp/env");
    DataSource dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
    con = dataFactory.getConnection();
  }


}
