package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/STUDENT";

	// Database credentials
	private static final String USER = "root";
	private static final String PASS = "root";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		try {
			// Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// Open a connection
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM StudentDetail WHERE EMAIL='"+email+"'");
			
			if(rs.next()){
				String firstName = rs.getString("FirstName"), lastName=rs.getString("LastName");
				String fatherName = rs.getString("FatherName"), queriedEmail = rs.getString("Email");
				String age = rs.getString("age"), cls = rs.getString("class");
				out.println("<!DOCTYPE html><html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"./styles.css\"/> <title>STUDENT </title> </head> <body><div id=\"addStudent\"> <div> <form onsubmit=\"return validateStudentForm()\" action=\"processUpdateStudent\" method=\"post\"><input type='hidden' value='"+email+"' name='originalEmail' /> <table align=\"center\" class=\"details\" cellspacing=\"0px\" width=\"40%\" cellpadding=\"10px\" > <th colspan=\"2\"><center>Update Detail</center> </th> <tr> <td> <label for=\"firstName\">First Name</label></td><td><input type=\"text\" value=\""+firstName+"\" name=\"firstName\" id=\"firstName\" placeholder=\"Enter First name\"><br/> <sup><span id=\"firstname_error\"></span></sup></td></tr><tr> <td><label for=\"lastName\">Last Name</label></td><td><input type=\"text\" name=\"lastName\" value=\""+lastName+"\" id=\"lastName\" placeholder=\"Enter Last name\"><br/> <sup><span id=\"lastname_error\"></span></sup></td></tr><tr> <td><label for=\"fatherName\">Father Name</label></td><td><input type=\"text\" name=\"fatherName\" value=\""+fatherName+"\" id=\"fatherName\" placeholder=\"Enter Father name\"><br/> <sup><span id=\"fathername_error\"></span></sup></td></tr><tr> <td><label for=\"email_id\">EmailId</label></td><td><input type=\"text\" value=\""+queriedEmail+"\" name=\"email_id\" id=\"email_id\" placeholder=\"Enter Email-Id\"><br/> <sup><span id=\"email_error\"></span></sup></td></tr><tr> <td><label for=\"age\">Age</label></td><td><input type=\"number\" value=\""+age+"\" name=\"age\" id=\"age\" placeholder=\"Enter Age\"><br/> <sup><span id=\"age_error\"></span></sup></td></tr><tr> <td><label for=\"class\">Class</label></td><td><input type=\"number\" value=\""+cls+"\" name=\"class\" id=\"class\" placeholder=\"Enter Class\"><br/> <sup><span id=\"class_error\"></span></sup></td></tr><tr> <td colspan=\"2\"> <center><button>Submit</button></center> </td></tr></table> </form> </div></div><script src=\"./scripts.js\"></script></body></html>");
			} else {
				out.println("<h1 style=\"color: red; text-align: center;\">"+email+" not found!</h1>");
			}
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
