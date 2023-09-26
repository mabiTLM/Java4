package servletTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/title")
public class Title extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Title() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  response.setCharacterEncoding("UTF-8");
	  response.getWriter().append("<!DOCTYPE html>"
	      + "<html lang=\"ko\">"
	      + "  <head>"
	      + "    <meta charset=\"UTF-8\" />"
	      + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />"
	      + "    <title>시작화면</title>"
	      + "    <script src=\"/scripts/makeCardGame.js\"></script>"
	      + "    <link rel=\"stylesheet\" href=\"/styles/style.css\" />"
	      + "  </head>"
	      + "  <body>"
	      + "    <a href=\"village\">"
	      + "      <button style=\"text-align: center; font-size: 100px\" onclick=\"newGame()\">"
	      + "        새로운 시작"
	      + "      </button>"
	      + "    </a>"
	      + "  </body>"
	      + "</html>"
	      );
	  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
