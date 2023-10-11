package c231011;

// 그래서 코트 분할이 뭔데?
public class UserBean {
  // VO 랑 같은 개념
  // 규칙이 정해져 있다.
  private int id;
  private String name;
  private String userId;
  private String password;
  // private String address;
  // private String phone;
  // private String handphone;

  public UserBean() {

  }

  public void setId(int id) {
    this.id = id;
  };

  public int getId() {
    return id;
  };

  public void setName(String name) {
    this.name = name;
  };

  public String getName() {
    return name;
  };

  public void setUserId(String userId) {
    this.userId = userId;
  };

  public String getUserId() {
    return userId;
  };

  public void setPassword(String password) {
    this.password = password;
  };

  public String getPassword() {
    return password;
  };

}
