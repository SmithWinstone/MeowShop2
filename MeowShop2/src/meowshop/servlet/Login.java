package meowshop.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import meowshop.bean.UtenteBean;
import meowshop.dao.LoginDao;

@WebServlet("/Login.java")
public class Login extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    LoginDao dao = new LoginDao(); 

    //LOGIN SETTA USERNAME E EMAIL NELLA SESSIONE
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        if(dao.check(email, pass)) {
            HttpSession session = request.getSession();
            UtenteBean utente = dao.getUtente();
            session.setAttribute("utente", utente);
            session.setAttribute("email", email);
            //se il log in ha successo redirect 
            response.sendRedirect("Home.jsp");
        }
        else {
            response.sendRedirect("pageErrore.jsp");
        }
    }
}
