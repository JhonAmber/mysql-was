package app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.MysqlDataSource;

import app.db.Conexion;

/**
 * Servlet implementation class ApiController
 */
@WebServlet("/")
public class ApiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out;
		out = response.getWriter();
		
		response.setContentType("text/html");
		out.println("<html>");
		out.println("<head><title>Demo</title><head>");
		out.println("<body>");
		out.println("<h1>HOLa MUNDO CRUEL</h1>");
		out.println("</body></html>");
		
		Conexion conexion = new Conexion();
		
		MysqlDataSource ds = conexion.getConexion();
		
		String query = "SELECT VERSION()";

		
        try ( Connection con = ds.getConnection() ) {
        	
       
                PreparedStatement pst = con.prepareStatement(query);
                
                ResultSet rs = pst.executeQuery();

	            if (rs.next()) {
	                String version = rs.getString(1);
	                System.out.println(version);
	            }
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(ApiController.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
