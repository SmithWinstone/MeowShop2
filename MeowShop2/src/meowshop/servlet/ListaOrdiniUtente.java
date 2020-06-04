package meowshop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import meowshop.bean.ListaOrdini;
import meowshop.bean.UtenteBean;
import meowshop.dao.ProvaListaOrdiniDao;

/**
 * Servlet implementation class ListaOrdiniUtente
 */
@WebServlet(name="/ListaOrdiniUtente", urlPatterns= {"/ListaOrdiniUtente"})
public class ListaOrdiniUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtenteBean utente=(UtenteBean) request.getSession().getAttribute("utente");
		String email=utente.getEmail();
		System.out.println("prima di ProvaListaOrdiniDao   (listaordiniutente.java) email= "+email);
		ProvaListaOrdiniDao listaOrdiniDao=new ProvaListaOrdiniDao();
		JSONArray jArray=new JSONArray();
		System.out.println("AAAAAAA");
		jArray=listaOrdiniDao.getListaOrdini(email);
		System.out.println("ListaOrdiniDao WORKAAAAAA");
		try {

			System.out.println("ESEMPIO: numordine primo ordine di listaordini (listaordiniutente.java)"+jArray.getJSONObject(1).getString("categoria"));
			System.out.println("ESEMPIO: numordine primo ordine di listaordini (listaordiniutente.java)"+jArray.getJSONObject(12).getString("categoria"));

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("ESEMPIO: cap primo ordine di listaordini (listaordiniutente.java)"+listaOrdini.getOrdine(1).getCap());		
//		System.out.println("ESEMPIO: numordine ultimo ordine di listaordini (listaordiniutente.java)"+listaOrdini.getOrdine(13).getNumOrdine());
//		System.out.println("ESEMPIO: cap ultimo ordine di listaordini (listaordiniutente.java)"+listaOrdini.getOrdine(13).getCap());
//		System.out.println("LUNGHEZZA lista(listaordiniutente.java): "+listaOrdini.lunghezzaListaOrdini());
		
		

		request.getSession().setAttribute("listaOrdini", jArray);
		response.sendRedirect("listaOrdiniUtente.jsp");
	}

}
