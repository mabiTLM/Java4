package c231025.main.java.com.classJava.proxyEx;

public class SimpleStringImpl implements SimpleString {

  @Override
  public String hello(String name) {
    return "Hello " + name;
  }

  @Override
  public String intro(String name) {
    return "My name is " + name;
  }

  @Override
  public String bye(String name) {
    return "Bye " + name;
  }



}
