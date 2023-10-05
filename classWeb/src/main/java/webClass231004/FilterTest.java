package webClass231004;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;


@WebFilter("/api")
public class FilterTest extends HttpFilter implements Filter {
  private static final long serialVersionUID = -5817157711719581722L;

  public FilterTest() {
    super();

  }

  public void destroy() {}

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    // HttpSession session = ((HttpServletRequest) request).getSession();
    // response.setContentType("text/html;charset=utf-8");
    // session.setAttribute("testing", "아하하하?");
    // request.setAttribute("userId", "정");
    // response.getWriter().print("<html><head><meta charset='utf-8'/></head><body><h1>");
    // chain.doFilter(request, response);
    // response.getWriter().print("</h1></body></html>");
  }

  public void init(FilterConfig fConfig) throws ServletException {}
}
