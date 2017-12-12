import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String strUsername = request.getParameter("username");
		String strPassword = request.getParameter("password");

		if (CreateDao.save(strUsername, strPassword)) {
			RequestDispatcher rd = request.getRequestDispatcher("created");
			rd.forward(request, response);
		} else {
			out.print("Error occured while creating user.");
			RequestDispatcher rd = request.getRequestDispatcher("create.html");
			rd.include(request, response);
		}

		out.close();
	}

}