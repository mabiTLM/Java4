package c231025.test.java.com.classJava.proxyEx;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.lang.reflect.Proxy;
import org.junit.Test;
import c231025.main.java.com.classJava.proxyEx.SimpleString;
import c231025.main.java.com.classJava.proxyEx.SimpleStringImpl;
import c231025.main.java.com.classJava.proxyEx.SimpleStringUpper;
import c231025.main.java.com.classJava.proxyEx.ToUpperCaseHandler;

public class SimpleStringTest {
  @Test
  public void DecoTest() {
    SimpleString simpleStringImpl = new SimpleStringImpl();
    SimpleString simpleString = new SimpleStringUpper();

    ((SimpleStringUpper) simpleString).setSimpleString(simpleStringImpl);
    assertThat(simpleString.hello("한"), is("HELLO 한"));
    assertThat(simpleString.intro("한"), is("MY NAME IS 한"));
    assertThat(simpleString.bye("한"), is("BYE 한"));
  }

  @Test
  public void handlerTest() {
    SimpleString ssProxied = (SimpleString) Proxy.newProxyInstance(getClass().getClassLoader(),
        new Class[] {SimpleString.class}, new ToUpperCaseHandler(new SimpleStringImpl()));
    assertThat(ssProxied.hello("한"), is("HELLO 한"));
    assertThat(ssProxied.intro("한"), is("MY NAME IS 한"));
    assertThat(ssProxied.bye("한"), is("BYE 한"));
  }
}
