package c231011;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
  // Spring에서 쓸까? 당연하다

  // protected abstract Connection connect() throws Exception;

  private ConnectionMaker maker;

  public UserDAO(ConnectionMaker maker) {
    this.maker = maker;
  }

  public void add(UserBean user) throws Exception {
    Connection conn = maker.makeConnection();
    String query = "insert into users (name,user_id,password) values (?,?,?)";
    PreparedStatement pstmt = conn.prepareStatement(query);
    pstmt.setString(1, user.getName());
    pstmt.setString(2, user.getUserId());
    pstmt.setString(3, user.getPassword());
    pstmt.executeUpdate();

    pstmt.close();
    conn.close();
  }

  public UserBean get(String userId) throws Exception {
    Connection conn = maker.makeConnection();
    String query = "select * from users where user_id=?";
    PreparedStatement pstmt = conn.prepareStatement(query);
    pstmt.setString(1, userId);
    ResultSet rs = pstmt.executeQuery();

    UserBean user = null;

    if (rs.next()) {
      user = new UserBean();
      user.setId(rs.getInt("id"));
      user.setName(rs.getString("name"));
      user.setUserId(rs.getString("user_id"));
      user.setPassword(rs.getString("password"));
    }
    pstmt.close();
    conn.close();

    return user;
  }
}
