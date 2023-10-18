package servletTest.card;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

  // public void makeTable() {
  // insertQuery += "drop table card;";
  // insertQuery += "create table Card(id number(10,0) generated as identity primary key,"
  // + "name varchar2(20) not null, type varchar2(20) not null,consumeMana number(10,0) not null,"
  // + "price number(10,0) not null,effect varchar2(20) default '통상',"
  // + "effectValue number(10,0) default 0,enforce varchar2(10) default 'false',"
  // + "volatility varchar2(10) default 'false');";
  // }

  /**
   * 게임을 처음시작할때 데이버베이스 세팅 일단 전부하나로 되있는데 분리해야한다.
   **/
  public void newStart() {
    TotalCardBase totalCardBase = new TotalCardBase();
    try {
      connect();
      String deleteQuery = "drop table card";
      PreparedStatement stmt = con.prepareStatement(deleteQuery);
      stmt.executeUpdate();
      stmt.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
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
    } catch (Exception e) {
      e.printStackTrace();
    }

    try {
      String deleteQuery = "drop table deck";
      PreparedStatement stmt = con.prepareStatement(deleteQuery);
      stmt.executeUpdate();
      stmt.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    try {
      String createDeckQuery = "create table Deck (id number(10,0) not null,"
          + "name varchar2(20) not null, type varchar2(20) not null,cardvalue number(10,0) not null,consumeMana number(10,0) not null,"
          + "price number(10,0) not null,effect varchar2(20) default '통상',"
          + "effectValue number(10,0) default 0,enforce varchar2(10) default 'false',"
          + "volatility varchar2(10) default 'false')";
      PreparedStatement crePstmt = con.prepareStatement(createDeckQuery);
      crePstmt.executeUpdate();
      crePstmt.close();
    } catch (Exception e) {
      e.printStackTrace();
    }


    try {
      String deleteQuery = "drop table villageShop";
      PreparedStatement stmt = con.prepareStatement(deleteQuery);
      stmt.executeUpdate();
      stmt.close();
    } catch (Exception e) {
      e.printStackTrace();
    }


    try {
      String createDeckQuery =
          "create table villageShop (id number(10,0) generated as identity primary key,"
              + "name varchar2(20) not null, type varchar2(20) not null,cardvalue number(10,0) not null,consumeMana number(10,0) not null,"
              + "price number(10,0) not null,effect varchar2(20) default '통상',"
              + "effectValue number(10,0) default 0,enforce varchar2(10) default 'false',"
              + "volatility varchar2(10) default 'false')";
      PreparedStatement crePstmt = con.prepareStatement(createDeckQuery);
      crePstmt.executeUpdate();
      crePstmt.close();

      for (int i = 0; i < totalCardBase.shopSellCard().length; i++) {
        String insertQuery =
            "insert into villageShop (name,type,cardValue,consumeMana,price,effect,effectValue,volatility) values (?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(insertQuery);
        pstmt.setString(1, totalCardBase.shopSellCard()[i].getCardName());
        pstmt.setString(2, totalCardBase.shopSellCard()[i].getCardType().toString());
        pstmt.setInt(3, totalCardBase.shopSellCard()[i].getCardValue());
        pstmt.setInt(4, totalCardBase.shopSellCard()[i].getCardConsumeMana());
        pstmt.setInt(5, totalCardBase.shopSellCard()[i].getCardPrice());
        pstmt.setString(6, totalCardBase.shopSellCard()[i].getEffect());
        pstmt.setInt(7, totalCardBase.shopSellCard()[i].getEffectValue());
        pstmt.setString(8, String.valueOf(totalCardBase.shopSellCard()[i].getVolatility()));
        pstmt.executeUpdate();
        pstmt.close();

      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    try {
      String deleteQuery = "drop table cardInventory";
      PreparedStatement stmt = con.prepareStatement(deleteQuery);
      stmt.executeUpdate();
      stmt.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    try {
      String createDeckQuery = "create table cardInventory (id number(10,0) not null,"
          + "name varchar2(20) not null, type varchar2(20) not null,cardvalue number(10,0) not null,consumeMana number(10,0) not null,"
          + "price number(10,0) not null,effect varchar2(20) default '통상',"
          + "effectValue number(10,0) default 0,enforce varchar2(10) default 'false',"
          + "volatility varchar2(10) default 'false')";
      PreparedStatement crePstmt = con.prepareStatement(createDeckQuery);
      crePstmt.executeUpdate();
      crePstmt.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    try {
      con.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  /**
   * fromDeck카드의 id번째 카드를 toDeck에 넣는다.
   **/
  public void insertDeck(int id, String fromDeck, String toDeck) {
    try {
      CardVO temp = getCard(id, fromDeck);// 안에서 닫아버리니까 뒤에서 열자
      int finalCard = 0;
      for (int i = 0; i < 100; i++) {
        if (getCard(i, toDeck) == null) {
          finalCard = i + 1;
          break;
        }
      }
      connect();
      String insertQuery = "insert into " + toDeck
          + "(id,name,type,cardValue,consumeMana,price,effect,effectValue,volatility) values (?,?,?,?,?,?,?,?,?)";
      PreparedStatement pstmt = con.prepareStatement(insertQuery);
      pstmt.setInt(1, finalCard);
      pstmt.setString(2, temp.getCardName());
      pstmt.setString(3, temp.getCardType().toString());
      pstmt.setInt(4, temp.getCardValue());
      pstmt.setInt(5, temp.getCardConsumeMana());
      pstmt.setInt(6, temp.getCardPrice());
      pstmt.setString(7, temp.getEffect());
      pstmt.setInt(8, temp.getEffectValue());
      pstmt.setString(9, String.valueOf(temp.getVolatility()));
      pstmt.executeUpdate();
      pstmt.close();
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public CardVO getCard(int id, String from) {
    CardVO temp = null;
    try {
      connect();
      String query = "select * from " + from + " where id = ?";
      PreparedStatement pstmt = con.prepareStatement(query);
      pstmt.setInt(1, id + 1);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        temp = new CardVO(rs.getInt("id"), rs.getString("name"), rs.getString("type"),
            rs.getInt("cardvalue"), rs.getInt("consumemana"), rs.getInt("price"),
            rs.getString("effect"), rs.getInt("effectvalue"), rs.getString("enforce"),
            rs.getString("volatility"));
      }
      rs.close();
      pstmt.close();
      con.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return temp;
  }

  public void DBLengthCheck(String from) {
    try {
      connect();

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
