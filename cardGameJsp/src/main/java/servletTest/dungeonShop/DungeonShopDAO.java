package servletTest.dungeonShop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import makeCardGame230901.cardBundle.TotalCardBase;

public class DungeonShopDAO {

  private TotalCardBase totalCardBase = new TotalCardBase();
  private Connection con;

  public void createDungeonShopTable() throws Exception {
    connect();

    String createQuery =
        "create table dungeonShop(id number(10,0) generated as identity primary key,"
            + "name varchar2(20) not null, type varchar2(20) not null,cardValue number(10,0) not null,consumeMana number(10,0) not null,"
            + "price number(10,0) not null,effect varchar2(20) default '통상',"
            + "effectValue number(10,0) default 0,enforce varchar2(10) default 'false',"
            + "volatility varchar2(10) default 'false')";
    PreparedStatement crePstmt = con.prepareStatement(createQuery);
    crePstmt.executeUpdate();
    crePstmt.close();
    for (int i = 0; i < totalCardBase.dungeonShopCard().length; i++) {
      String insertQuery =
          "insert into dungeonShop (name,type,cardValue,consumeMana,price,effect,effectValue,volatility) values (?,?,?,?,?,?,?,?)";
      PreparedStatement pstmt = con.prepareStatement(insertQuery);
      pstmt.setString(1, totalCardBase.dungeonShopCard()[i].getCardName());
      pstmt.setString(2, totalCardBase.dungeonShopCard()[i].getCardType().toString());
      pstmt.setInt(3, totalCardBase.dungeonShopCard()[i].getCardValue());
      pstmt.setInt(4, totalCardBase.dungeonShopCard()[i].getCardConsumeMana());
      pstmt.setInt(5, totalCardBase.dungeonShopCard()[i].getCardPrice());
      pstmt.setString(6, totalCardBase.dungeonShopCard()[i].getEffect());
      pstmt.setInt(7, totalCardBase.dungeonShopCard()[i].getEffectValue());
      pstmt.setString(8, String.valueOf(totalCardBase.dungeonShopCard()[i].getVolatility()));
      pstmt.executeUpdate();
      pstmt.close();
      con.close();

    }
  }



  private void connect() throws Exception {
    Context ctx = new InitialContext();
    Context envContext = (Context) ctx.lookup("java:/comp/env");
    DataSource dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
    con = dataFactory.getConnection();
  }

}
