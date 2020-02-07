package server;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentDetail
 */
@WebServlet("/StudentDetail")
public class StudentDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/STUDENT";

	// Database credentials
	private static final String USER = "root";
	private static final String PASS = "root";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html><html><body>");
		out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
		String Firstname = request.getParameter("firstName");
		String Lastname = request.getParameter("lastName");
		String Fathername = request.getParameter("fatherName");
		String Email = request.getParameter("email_id");
		int age=Integer.parseInt(request.getParameter("age"));
		int cls=Integer.parseInt(request.getParameter("class"));
		try {
			// Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// Open a connection
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT email from StudentDetail WHERE email='"+Email+"'");
			
			if(!rs.next()){
			
				int inserted = stmt.executeUpdate("INSERT INTO studentDetail " + "VALUES (lower('"
						+ Firstname + "'),lower('" + Lastname + "'),'" + Fathername
						+ "', '" + Email + "', "+age+", "+cls+")");
				if(inserted==1){
					out.println("<script>swal('Details successfully added', '"+Email+" has been added to Student List', 'success')");
					out.println(".then(() => { window.location = '/EAD-3/index.html'; })</script>");
				} else {
					out.println("<script>swal('Oops!', 'Something went wrong!', 'error')");
					out.println(".then(() => { window.location = '/EAD-3/index.html'; })</script>");
				}
			} else {
				out.println("<script>swal('"+Email+" already exists', 'Try with another email addredd!', 'error')");
				out.println(".then(() => { window.location = '/EAD-3/index.html'; })</script>");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			out.close();
		}
	}

}
