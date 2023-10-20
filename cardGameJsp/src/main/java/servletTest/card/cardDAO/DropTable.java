package servletTest.card.cardDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DropTable {

  public DropTable() {

  }

  public void dropTableCard(Connection con) throws SQLException {
    String deleteQuery = "drop table card";
    PreparedStatement stmt = con.prepareStatement(deleteQuery);
    stmt.executeUpdate();
    stmt.close();
  }

  public void dropTableDeck(Connection con) throws SQLException {
    String deleteQuery = "drop table deck";
    PreparedStatement stmt = con.prepareStatement(deleteQuery);
    stmt.executeUpdate();
    stmt.close();
  }

  public void dropTableVillageShop(Connection con) throws SQLException {
    String deleteQuery = "drop table villageShop";
    PreparedStatement stmt = con.prepareStatement(deleteQuery);
    stmt.executeUpdate();
    stmt.close();
  }

  public void dropTableCardInventory(Connection con) throws SQLException {
    String deleteQuery = "drop table cardInventory";
    PreparedStatement stmt = con.prepareStatement(deleteQuery);
    stmt.executeUpdate();
    stmt.close();
  }


}
