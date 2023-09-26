package webClass230926.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class StudentDAO {
  private Connection con;

  public List<StudentVO> getList() {
    List<StudentVO> list = new ArrayList<StudentVO>();

    try {
      connect();
      // Class.forName("oracle.jdbc.OracleDriver");
      // Connection con =
      // DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "java", "qwer");
      String query = "select * from student";
      PreparedStatement stmt = con.prepareStatement(query);
      ResultSet rs = stmt.executeQuery();
      // Statement stmt = con.createStatement();
      // ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
        StudentVO temp =
            new StudentVO(rs.getInt("id"), rs.getString("name"), rs.getString("student_id"),
                rs.getString("password"), rs.getInt("age"), rs.getString("gitaddress"));
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
