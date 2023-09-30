package servletTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import makeCardGame230901.cardBundle.TotalCardBase;

public class CardDAO {
  private Connection con;

  // db에 자료넣기

  // drop table card;
  //
  // create table Card(
  // id number(10,0) generated as identity primary key,
  // name varchar2(20) not null,
  // type varchar2(20) not null,
  // consumeMana number(10,0) not null,
  // price number(10,0) not null,
  // effect varchar2(20) default '통상',
  // effectValue number(10,0) default 0,
  // enforce varchar2(10) default 'false',
  // volatility varchar2(10) default 'false'
  // );

  public void totalCardInsert() {
    TotalCardBase totalCardBase = new TotalCardBase();
    try {
      connect();
      String insertQuery = "drop table card;create table Card("
          + "id number(10,0) generated as identity primary key," + "name varchar2(20) not null,"
          + "type varchar2(20) not null," + "consumeMana number(10,0) not null,"
          + "price number(10,0) not null," + "effect varchar2(20) default '통상',"
          + "effectValue number(10,0) default 0," + "enforce varchar2(10) default 'false',"
          + "volatility varchar2(10) default 'false'"
          + "insert into Card (name,type,consumeMana,price,effect,effectValue,volatility) values (?,?,?,?,?,?,?)";
      PreparedStatement pstmt = con.prepareStatement(insertQuery);
      for (int i = 0; i < totalCardBase.totalCard().length; i++) {
        pstmt.setString(1, totalCardBase.totalCard()[i].getCardName());
        pstmt.setString(2, totalCardBase.totalCard()[i].getCardType().toString());
        pstmt.setInt(3, totalCardBase.totalCard()[i].getCardConsumeMana());
        pstmt.setInt(4, totalCardBase.totalCard()[i].getCardPrice());
        pstmt.setString(5, totalCardBase.totalCard()[i].getEffect());
        pstmt.setInt(6, totalCardBase.totalCard()[i].getEffectValue());
        pstmt.setString(7, String.valueOf(totalCardBase.totalCard()[i].getVolatility()));
        pstmt.executeUpdate();
        pstmt.close();
        con.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  private void connect() throws Exception {
    // Class.forName("oracle.jdbc.OracleDriver");
    // con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "java", "qwer");
    Context ctx = new InitialContext();
    // DriverManager =>DM
    // initialize 초기화
    Context envContext = (Context) ctx.lookup("java:/comp/env");
    DataSource dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
    con = dataFactory.getConnection();
  }

}
