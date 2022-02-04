import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MaterialServlet
 */
@WebServlet("/MaterialServlet")
public class MaterialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String jdbcURL = "jdbc:mysql://localhost:3306/materialdetails";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";

	private static final String INSERT_MATERIALS_SQL = "INSERT INTO MaterialDetails" + " (title, description, text, url) VALUES " + " (?, ?, ?);";
	private static final String SELECT_MATERIAL_BY_ID = "select title,description,text,url from MaterialDetails where title =?";
	private static final String SELECT_ALL_MATERIALS = "select * from MaterialDetails ";
	private static final String DELETE_MATERIALS_SQL = "delete from MaterialDetails where title = ?;";
	private static final String UPDATE_MATERIALS_SQL = "update MaterialDetails set title = ?,description= ?, text =?,url =? where title = ?;";

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	private void listMaterials(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException
	{
		List <Material> materials = new ArrayList <>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement =
						connection.prepareStatement(SELECT_ALL_MATERIALS);) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String title = rs.getString("title");
				String description = rs.getString("description");
				String text = rs.getString("text");
				String url = rs.getString("url");
				materials.add(new Material(title, description, text, url));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("listMaterials", materials);
		request.getRequestDispatcher("/materialManagement.jsp").forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		String title = request.getParameter("title");
		Material existingMaterial = new Material("", "", "", "");

		try (Connection connection = getConnection();

				PreparedStatement preparedStatement =
						connection.prepareStatement(SELECT_MATERIAL_BY_ID);) {
			preparedStatement.setString(1, title);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				title = rs.getString("title");
				String description = rs.getString("description");
				String text = rs.getString("text");
				String url = rs.getString("url");
				existingMaterial = new Material(title, description, text, url);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		request.setAttribute("material", existingMaterial);
		request.getRequestDispatcher("/materialEdit.jsp").forward(request, response);
	}

	private void updateMaterial(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		String oriTitle = request.getParameter("oriTitle");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String text = request.getParameter("text");
		String url = request.getParameter("url");

		try (Connection connection = getConnection(); PreparedStatement statement =
				connection.prepareStatement(UPDATE_MATERIALS_SQL);) {
			statement.setString(1, title);
			statement.setString(2, description);
			statement.setString(3, text);
			statement.setString(4, url);
			statement.setString(5, oriTitle);
			int i = statement.executeUpdate();
		}
		response.sendRedirect("http://localhost:8090/LearningPlatformJavaEE/MaterialServlet/dashboard");
	}
	
	private void deleteMaterial(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		
		String title = request.getParameter("title");
		
		try (Connection connection = getConnection(); PreparedStatement statement =
				connection.prepareStatement(DELETE_MATERIALS_SQL);) {
				 statement.setString(1, title);
				 int i = statement.executeUpdate();
				 }
		response.sendRedirect("http://localhost:8090/LearningPlatformJavaEE/MaterialServlet/dashboard");
	}


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MaterialServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String action = request.getServletPath();
		try {
			switch (action) {
			case "/MaterialServlet/delete":
				deleteMaterial(request, response);
				break;
			case "/MaterialServlet/edit":
				showEditForm(request, response);
				break;
			case "/MaterialServlet/update":
				updateMaterial(request, response);
				break;
			case "/MaterialServlet/dashboard":
				listMaterials(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
