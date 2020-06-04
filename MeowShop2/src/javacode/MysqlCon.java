package javacode;

import java.sql.*;
import java.util.ArrayList;

import meowshop.bean.ProdottoBean;  
class MysqlCon{  
public static void main(String args[]){ 
try{  
Class.forName("com.mysql.cj.jdbc.Driver");  
String url="jdbc:mysql://127.0.0.1:3306/meowshop?useLegacyDatetimeCode=false&amp&serverTimezone=Europe/Amsterdam&amp&useSSL=false";
Connection con=DriverManager.getConnection(url,"root","Password00");  

//here sonoo is database name, root is username and password  
PreparedStatement ps= con.prepareStatement("SELECT * FROM prodotto WHERE categoria = ?");
ps.setString(1, "categoria");
System.out.println("ps fatto");

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
	System.out.printf("Id: %d\n\n", id);
}
/*
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("select * from prodotto");  
while(rs.next())  
System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
con.close();  */
}catch(Exception e){ System.out.println(e);}  
}  
}  
