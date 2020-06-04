package meowshop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Logout.java")
public class Logout extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    
    //LOGOUT RIMUOVE USERNAME ED EMAIL DALLA SESSIONE
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("utente")!=null) {	session.removeAttribute("utente");}
        if(session.getAttribute("email")!=null) {	session.removeAttribute("email");}
        response.sendRedirect("Home.jsp");
    }
}
