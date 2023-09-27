package webClass230926.homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {

  private Connection con;

  /**
   * 게시글 나열하기
   **/
  public List<BoardVO> getList() {
    List<BoardVO> list = new ArrayList<BoardVO>();

    try {
      connect();
      String query = "select * from Board";
      PreparedStatement stmt = con.prepareStatement(query);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        BoardVO temp = new BoardVO(rs.getInt("id"), rs.getString("title"), rs.getString("writer"),
            rs.getString("post"), rs.getString("created_at"));
        list.add(temp);
      }
      rs.close();
      stmt.close();
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }

  /**
   * 다른 함수들 처리를 위해 모든 정보 불러오기
   **/
  public BoardVO getBoard(int postId) {
    BoardVO temp = null;
    try {
      connect();
      String query = "select * from board where id=?";
      PreparedStatement pstmt = con.prepareStatement(query);
      pstmt.setInt(1, postId);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        temp = new BoardVO(rs.getInt("id"), rs.getString("title"), rs.getString("writer"),
            rs.getString("post"), rs.getString("created_at"));
      }
      rs.close();
      pstmt.close();
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return temp;
  }


  /**
   * 게시글쓰기
   **/
  public BoardVO insertBoard(String title, String writer, String post) {
    BoardVO temp = null;
    try {
      connect();
      String insertQuery = "insert into board (title,writer,post) values (?,?,?)";;
      PreparedStatement pstmt = con.prepareStatement(insertQuery);
      pstmt.setString(1, title);
      pstmt.setString(2, writer);
      pstmt.setString(3, post);
      pstmt.executeUpdate();
      pstmt.close();
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return temp;
  }

  /**
   * 게시글번호기반으로 삭제
   **/
  public BoardVO deleteBoard(int id) {
    BoardVO temp = null;
    try {
      connect();
      String deleteQuery = "delete from board where id =?";
      PreparedStatement pstmt = con.prepareStatement(deleteQuery);
      pstmt.setInt(1, id);
      pstmt.executeUpdate();
      pstmt.close();
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return temp;
  }

  /**
   * 게시글번호기반으로 수정
   **/
  public BoardVO editBoard(int id, String title, String post) {
    BoardVO temp = null;
    try {
      connect();
      String updateQuery = "update board set title=?, post=? where id = ?";
      PreparedStatement pstmt = con.prepareStatement(updateQuery);
      pstmt.setString(1, title);
      pstmt.setString(2, post);
      pstmt.setInt(3, id);
      pstmt.executeUpdate();
      pstmt.close();
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return temp;
  }



  private void connect() throws Exception {
    Context ctx = new InitialContext();
    Context envContext = (Context) ctx.lookup("java:/comp/env");
    DataSource dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
    con = dataFactory.getConnection();
  }
}
