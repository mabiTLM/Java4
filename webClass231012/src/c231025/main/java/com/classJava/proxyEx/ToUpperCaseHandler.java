package c231025.main.java.com.classJava.proxyEx;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ToUpperCaseHandler implements InvocationHandler {
  SimpleString target;

  public ToUpperCaseHandler(SimpleString target) {
    this.target = target;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    String ret = (String) method.invoke(target, args);
    if (ret instanceof String && method.getName().equals("hello")) {
      return ret.toUpperCase();
    } else {
      return ret;
    }



    // 1004일자 필터
  }

  // [] args 는 값을 전부 다 넣는다

}
