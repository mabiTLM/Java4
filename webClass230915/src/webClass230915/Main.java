package webClass230915;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
  public static void main(String[] args) {
    try {
      Class.forName("oracle.jdbc.OracleDriver");
      Connection con =
          DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "java", "qwer");

      // String update = "update student set student_id='KDS' where id =1";
      // Statement stmt2 = con.createStatement();
      // ResultSet rs2 = stmt2.executeQuery(update);

      // String insertQuery =
      // "insert into student (name,student_id,password,age,gitaddress) values (?,?,?,?,?)";
      // PreparedStatement pstmt = con.prepareStatement(insertQuery); // ?로넣어서 추가할 준비를 해준다.
      // pstmt.setString(1, "송성민");
      // pstmt.setString(2, "ssm");
      // pstmt.setString(3, "2631");
      // pstmt.setInt(4, 23);
      // pstmt.setString(5, "송성민");
      // pstmt.executeUpdate();


      String query = "select * from student";
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(query);// 쿼리를 실행해라

      while (rs.next()) {
        System.out.println(rs.getString("name") + " : " + rs.getInt("age"));
      }

      // rs.next();
      // System.out.println(rs.getString("name") + " : " + rs.getInt("age"));
      // rs.next();
      // System.out.println(rs.getString("name") + " : " + rs.getInt("age"));

      stmt.close();
      rs.close();
      con.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
