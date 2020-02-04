package server;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchStudent
 */
@WebServlet("/SearchStudent")
public class SearchStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/STUDENT";

	// Database credentials
	private static final String USER = "root";
	private static final String PASS = "root";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchStudent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    private static String capitalize(String str){
    	if(str == null || str.isEmpty()) {
            return str;
        }
    	return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		try {
			// Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// Open a connection
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			String firstname = request.getParameter("firstName");
			String lastname = request.getParameter("lastName");
			String request1 = "SELECT * FROM  StudentDetail WHERE FirstName=lower('"+firstname+"') AND LastName=lower('"+lastname+"') ORDER BY class";
			ResultSet students = stmt.executeQuery(request1);

			out.println("<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\"><style>th, td{padding: 10px;}table{margin-left: auto;margin-right: auto;margin-top: 50px;}table, th, td{border: solid 1px black;}h1{text-align: center;}</style><title>"+firstname+" "+lastname+"</title></head><body>");
			if (students.next()) {
				out.println("<h1>Search Results</h1><table><tr><th>First Name</th><th>Last Name</th><th>Father's Name</th><th>Email</th><th>Age</th><th>Class</th><th>Update Here</th></tr>");
				out.println("<tr><td>"+capitalize(students.getString("FirstName")) +"</td><td>"+capitalize(students.getString("LastName"))+"</td><td>"+students.getString("FatherName")+"</td><td>"+students.getString("Email")+"</td><td>"+students.getString("age")+"</td><td>"+students.getString("class")+"</td><td><a href=\"/EAD-3/updateStudent?email="+students.getString("Email")+"\">Update >></a></td></tr>");
			} else {
				out.println("<h1 style=\"color: red\">User Not Found</h1>");
			}
			
			while(students.next()){
				out.println("<tr><td>"+capitalize(students.getString("FirstName")) +"</td><td>"+capitalize(students.getString("LastName"))+"</td><td>"+students.getString("FatherName")+"</td><td>"+students.getString("Email")+"</td><td>"+students.getString("age")+"</td><td>"+students.getString("class")+"</td><td><a href=\"/EAD-3/updateStudent?email="+students.getString("Email")+"\">Update >></a></td></tr>");
			}
			out.println("</tr></table></body></html>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			out.close();
		}
	}

}
