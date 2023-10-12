package c231012.singleton;

import c231012.connection.ConnectionMaker;
import c231012.connection.OracleCM;

public class Test {

  public static void main(String[] args) throws Exception {
    ConnectionMaker maker = new OracleCM();
    SingletonDAO dao = SingletonDAO.getInstance(maker);
    SingletonDAO dao1 = SingletonDAO.getInstance(maker);
    SingletonDAO dao2 = SingletonDAO.getInstance(maker);
    System.out.println(dao);
    System.out.println(dao1);
    System.out.println(dao2);

    // UserBean user = new UserBean();
    // user.setName("김남");
    // user.setUserId("knk");
    // user.setPassword("1234");
    // dao.add(user);
  }

}
