package meowshop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import meowshop.bean.Carrello;

/**
 * Servlet implementation class AggiungiCarrello
 */
@WebServlet("/AggiungiCarrello")
public class AggiungiCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       //prende carrello da sessione e applica metodo addItem(int itemID)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int itemID = Integer.parseInt(request.getParameter("itemID"));
        HttpSession session = request.getSession();
        Carrello carrello=(Carrello)session.getAttribute("carrello");
        carrello.addItem(itemID);
        session.setAttribute("carrello", carrello);
        
        response.sendRedirect("carrello.jsp");
	}

}
