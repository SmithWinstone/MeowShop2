package meowshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import meowshop.bean.UtenteBean;



public class LoginDao {
    String url = "jdbc:mysql://localhost:3306/meowshop"
            + "?useUnicode=true&useJDBCCompliantTimezoneShift=true"
            + "&useLegacyDatetimeCode=false&serverTimezone=UTC"; 
    String username="root";
    String password="Password00";
    String sql="select * from utente where email = ? and password = ?";

    UtenteBean utente;
    public boolean check(String email, String pass) {
    	String nome,cognome,dataNascita;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement st= con.prepareStatement(sql);
            st.setString(1, email);
            st.setString(2, pass);
            ResultSet rs=st.executeQuery();
            if(rs.first()) {
            nome=rs.getString("nome");
            cognome=rs.getString("cognome");
            dataNascita=rs.getString("dataNascita");
            utente=new UtenteBean(nome,cognome,dataNascita,email);
            return true;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public UtenteBean getUtente() {
        return utente;
    }

}