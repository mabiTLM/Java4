package c231026.test.java.com.classJava.proxyEx;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.Test;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import c231025.main.java.com.classJava.proxyEx.SimpleString;
import c231025.main.java.com.classJava.proxyEx.SimpleStringImpl;

// import static org.hamcrest.CoreMatchers.is;

public class DynamicProxyTest {
  public static class UppercaseAdvice implements MethodInterceptor {
    // 익명 클래스
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
      String ret = (String) invocation.proceed();
      return ret.toUpperCase();
    }
  }

  @Test
  public void proxyFactoryBean() {
    ProxyFactoryBean pfBean = new ProxyFactoryBean();
    pfBean.setTarget(new SimpleStringImpl());
    pfBean.addAdvice(new MethodInterceptor() {
      // 익명 클래스
      @Override
      public Object invoke(MethodInvocation invocation) throws Throwable {
        String ret = (String) invocation.proceed();
        return ret.toUpperCase();
      }
    });

    SimpleString proxiedSS = (SimpleString) pfBean.getObject();
    assertThat(proxiedSS.hello("한"), is("HELLO 한"));
    assertThat(proxiedSS.intro("한"), is("MY NAME IS 한"));
    assertThat(proxiedSS.bye("한"), is("BYE 한"));
  }

  @Test
  public void pointcutAdvisor() {
    ProxyFactoryBean pfBean = new ProxyFactoryBean();
    pfBean.setTarget(new SimpleStringImpl());

    NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
    pointcut.setMappedName("*o");

    pfBean.addAdvisor(new DefaultPointcutAdvisor(pointcut, new UppercaseAdvice()));
    SimpleString proxiedSS = (SimpleString) pfBean.getObject();
    assertThat(proxiedSS.hello("한"), is("HELLO 한"));
    assertThat(proxiedSS.intro("한"), is("MY NAME IS 한"));
    assertThat(proxiedSS.bye("한"), is("Bye 한"));
  }

  @Test
  public void classNamePointcutAdvisor() {

    NameMatchMethodPointcut classMethodPointcut = new NameMatchMethodPointcut() {
      @Override
      public ClassFilter getClassFilter() {
        return new ClassFilter() {
          @Override
          public boolean matches(Class<?> targetClass) {

            return targetClass.getSimpleName().startsWith("SimpleStringI");
          }
        };
      }
    };
    classMethodPointcut.setMappedName("*o");
    checkAdvisor(new SimpleStringImpl(), classMethodPointcut, true);

    class SimpleStringTest extends SimpleStringImpl {
    }
    checkAdvisor(new SimpleStringTest(), classMethodPointcut, false);

    class SimpleStringIntro extends SimpleStringImpl {
    }
    checkAdvisor(new SimpleStringIntro(), classMethodPointcut, true);
  }

  private void checkAdvisor(Object target, Pointcut pointcut, boolean isAdviced) {
    ProxyFactoryBean pfBean = new ProxyFactoryBean();
    pfBean.setTarget(target);
    pfBean.addAdvisor(new DefaultPointcutAdvisor(pointcut, new UppercaseAdvice()));
    SimpleString proxiedSS = (SimpleString) pfBean.getObject();

    if (isAdviced) {
      assertThat(proxiedSS.hello("한"), is("HELLO 한"));
      assertThat(proxiedSS.intro("한"), is("MY NAME IS 한"));
      assertThat(proxiedSS.bye("한"), is("Bye 한"));
    } else {
      assertThat(proxiedSS.hello("한"), is("Hello 한"));
      assertThat(proxiedSS.intro("한"), is("My name is 한"));
      assertThat(proxiedSS.bye("한"), is("Bye 한"));
    }
  }
}
