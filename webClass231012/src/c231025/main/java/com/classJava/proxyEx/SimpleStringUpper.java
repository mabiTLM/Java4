package c231025.main.java.com.classJava.proxyEx;

public class SimpleStringUpper implements SimpleString {
  private SimpleString simpleString;

  public void setSimpleString(SimpleString simpleString) {
    this.simpleString = simpleString;
  };

  @Override
  public String hello(String name) {
    return simpleString.hello(name).toUpperCase();
  }

  @Override
  public String intro(String name) {
    return simpleString.intro(name).toUpperCase();
  }

  @Override
  public String bye(String name) {
    return simpleString.bye(name).toUpperCase();
  }

}
