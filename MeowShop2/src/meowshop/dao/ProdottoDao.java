package meowshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import meowshop.bean.ProdottoBean;



public class ProdottoDao {
    String url = "jdbc:mysql://localhost:3306/meowshop"
            + "?useUnicode=true&useJDBCCompliantTimezoneShift=true"
            + "&useLegacyDatetimeCode=false&serverTimezone=UTC"; 
    String username="root";
    String password="Password00";
    String sql="select * from prodotto where id = ?";

    int id=0;
    String nome,descrizione,foto,categoria;
    int stock;
    float prezzo;

    
    
    public ProdottoDao() {
		super();
	}

	public ProdottoBean getProdotto(int id) {
    	ProdottoBean p;
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection con = DriverManager.getConnection(url,username,password);
            	PreparedStatement st= con.prepareStatement(sql);
            	st.setInt(1, id);
            	ResultSet rs=st.executeQuery();
            	if(rs.next()) {
            		nome=rs.getString("nome");
            		descrizione=rs.getString("descrizione");
            		foto=rs.getString("foto");
            		categoria=rs.getString("categoria");
            		prezzo=rs.getFloat("prezzo");
            		stock=rs.getInt("stock");
            		p=new ProdottoBean(id,nome,descrizione,foto,categoria,stock,prezzo);
            		return p;
            	}
        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
   	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //probabilmente inutile ma è un'idea per Lista Ordini
    public ArrayList<ProdottoBean> getListaProdottiDB(ArrayList<Integer> lista) {
    	ArrayList<ProdottoBean> listaProdottiDB;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection con = DriverManager.getConnection(url,username,password);
        	listaProdottiDB=new ArrayList<ProdottoBean>();
            for(Integer id:lista) {
            	PreparedStatement st= con.prepareStatement(sql);
            	st.setInt(1, id);
            	ResultSet rs=st.executeQuery();
            	rs.getInt("id");
            	rs.getString("nome");
            	rs.getString("descrizione");
            	rs.getString("foto");
            	rs.getString("categoria");
            	rs.getFloat("prezzo");
            	rs.getInt("stock");
            	ProdottoBean p=new ProdottoBean(id,nome,descrizione,foto,categoria,stock,prezzo);
            	listaProdottiDB.add(p);
            }
                return listaProdottiDB;
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}