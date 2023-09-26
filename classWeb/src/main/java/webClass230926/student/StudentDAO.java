package webClass230926.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
  public List<StudentVO> getList() {
    List<StudentVO> list = new ArrayList<StudentVO>();

    try {
      Class.forName("oracle.jdbc.OracleDriver");
      Connection con =
          DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "java", "qwer");
      String query = "select * from student";
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
        StudentVO temp =
            new StudentVO(rs.getInt("id"), rs.getString("name"), rs.getString("student_id"),
                rs.getString("student_pw"), rs.getInt("age"), rs.getString("student_id"));
      }

    } catch (Exception e) {

    }

    return list;

  }

}
