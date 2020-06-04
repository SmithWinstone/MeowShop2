package meowshop.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javacode.DriverManagerConnectionPool;
import meowshop.bean.ProdottoBean;

/**
 * Servlet implementation class MostraArticoli
 */
@WebServlet(name="/MostraArticoli", urlPatterns= {"/mostraArticoli"})
public class MostraArticoli extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostraArticoli() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String categoria = request.getParameter("categoria"); // = 1: cucce, 2:svago, 3:trasporto
		System.out.println("categoria :" + categoria);
		
		try {
			Connection con;		
			con = DriverManagerConnectionPool.getConnection();
			//operazioni
			
			
		
			PreparedStatement ps= con.prepareStatement("SELECT * FROM prodotto WHERE categoria = ?");
			ps.setString(1, categoria);
		
			ResultSet rs = ps.executeQuery();
			
			ArrayList <ProdottoBean> listaProdotti = new ArrayList<ProdottoBean>();		
		
			while(rs.next()) {
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				int stock = rs.getInt(3);
				float prezzo = rs.getFloat(4);
				String categ = rs.getString(5);
				String foto = rs.getString(6);
				String descrizione = rs.getString(7);
				ProdottoBean prodotto = new ProdottoBean(id, nome, descrizione, foto, categ, stock, prezzo);
				listaProdotti.add(prodotto);			
			}
			System.out.println("servlet: " + listaProdotti.size());
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/prodotto.jsp");
			request.setAttribute("prodotti", listaProdotti);
			request.setAttribute("categoria", categoria);
			dispatcher.forward(request, response);	
			DriverManagerConnectionPool.releaseConnection(con);
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
		
			
			
			} // fine DoGet
		
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
