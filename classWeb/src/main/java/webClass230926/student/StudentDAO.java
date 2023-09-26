package webClass230926.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(query);
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
    String query = "select * from student";
    Class.forName("oracle.jdbc.OracleDriver");
    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "java", "qwer");
    PreparedStatement stmt = con.prepareStatement(query);
    ResultSet rs = stmt.executeQuery();
  }

}
