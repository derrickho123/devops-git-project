

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Import these libraries from java.io and java.sql
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String t = request.getParameter("title");
		String d = request.getParameter("description");
		String a = request.getParameter("text");
		String u = request.getParameter("url");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/materialdetails", "root", "password");

			PreparedStatement ps = con.prepareStatement("insert into MATERIALDETAILS values(?,?,?,?)");

			ps.setString(1, t);
			ps.setString(2, d);
			ps.setString(3, a);
			ps.setString(4, u);

			int i = ps.executeUpdate();

			if (i > 0){
				PrintWriter writer = response.getWriter();
				writer.println("<h1>" + "You have successfully created a material!" +
						"</h1>");
				response.sendRedirect("http://localhost:8090/LearningPlatformJavaEE/MaterialServlet/dashboard");
				writer.close();
			}
		}
		catch (Exception exception) {
			System.out.println(exception);
			out.close();
		}

		doGet(request, response);
	}

}
