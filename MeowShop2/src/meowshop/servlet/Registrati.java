package meowshop.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javacode.DriverManagerConnectionPool;

/**
 * Servlet implementation class Registrati
 */
@WebServlet("/Registrati")
public class Registrati extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String dataNascita = request.getParameter("dataNascita");
		String email = request.getParameter("email"); 
		String password = request.getParameter("password");
		
		try {
			Connection con;		
			con = DriverManagerConnectionPool.getConnection();					
			PreparedStatement ps= con.prepareStatement("insert into utente values(?,?,?,?,?,'utente');");
			ps.setString(1, nome);
			ps.setString(2, cognome);
			ps.setString(3, dataNascita);
			ps.setString(4, email);
			ps.setString(5, password);
			int rs = ps.executeUpdate();			
			if(rs>0) { 
				System.out.println("Registrazione effettuata con successo.");
			}
			DriverManagerConnectionPool.releaseConnection(con);
			response.sendRedirect("Home.jsp");
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
