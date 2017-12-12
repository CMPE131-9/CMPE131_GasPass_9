import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class InsertedServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String strUserID=request.getParameter("userID");
		String strGallons = request.getParameter("gallons");
		out.println("Transaction by "+strUserID+" with a purchase of "+strGallons + " gallons has been saved successfully.");
		out.print("Current price is $" + SelectDao.getPrice());
		RequestDispatcher rd = request.getRequestDispatcher("insert.html");
		rd.include(request, response);
		out.close();
	}
}