package c231017.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface StatementStrategy {
  PreparedStatement makePstmt(Connection conn) throws SQLException;
}
