package servletTest.card.cardDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import makeCardGame230901.cardBundle.TotalCardBase;

public class CreateTable {
  TotalCardBase totalCardBase = new TotalCardBase();

  public CreateTable() {

  }

  public void creatCardTable(Connection con) throws SQLException {
    String createQuery = "create table Card(id number(10,0) generated as identity primary key,"
        + "name varchar2(20) not null, type varchar2(20) not null,cardValue number(10,0) not null,consumeMana number(10,0) not null,"
        + "price number(10,0) not null,effect varchar2(20) default '통상',"
        + "effectValue number(10,0) default 0,enforce varchar2(10) default 'false',"
        + "volatility varchar2(10) default 'false')";
    PreparedStatement crePstmt = con.prepareStatement(createQuery);
    crePstmt.executeUpdate();
    crePstmt.close();
    for (int i = 0; i < totalCardBase.totalCard().length; i++) {
      String insertQuery =
          "insert into Card (name,type,cardValue,consumeMana,price,effect,effectValue,volatility) values (?,?,?,?,?,?,?,?)";
      PreparedStatement pstmt = con.prepareStatement(insertQuery);
      pstmt.setString(1, totalCardBase.totalCard()[i].getCardName());
      pstmt.setString(2, totalCardBase.totalCard()[i].getCardType().toString());
      pstmt.setInt(3, totalCardBase.totalCard()[i].getCardValue());
      pstmt.setInt(4, totalCardBase.totalCard()[i].getCardConsumeMana());
      pstmt.setInt(5, totalCardBase.totalCard()[i].getCardPrice());
      pstmt.setString(6, totalCardBase.totalCard()[i].getEffect());
      pstmt.setInt(7, totalCardBase.totalCard()[i].getEffectValue());
      pstmt.setString(8, String.valueOf(totalCardBase.totalCard()[i].getVolatility()));
      pstmt.executeUpdate();
      pstmt.close();
    }

  }
}
