package meowshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.cj.xdevapi.JsonArray;

import javacode.DriverManagerConnectionPool;
import meowshop.bean.Carrello;
import meowshop.bean.ItemOrder;
import meowshop.bean.ListaOrdini;
import meowshop.bean.Ordine;
import meowshop.bean.ProdottoBean;
import meowshop.bean.UtenteBean;


/*select ordine.numOrdine,utente,data,numeroCarta,nomeSpedizione,cognomeSpedizione,indirizzo,citt‡,
 * cap,provincia,nomeIntestatario,cognomeIntestatario,meseScadenza,annoScadenza,cvv,idProdotto,quantit‡,nome,prezzo,foto 
 * from ordine join ordineprodotto join prodotto 
 * where ordine.numOrdine = ordineprodotto.numOrdine and prodotto.id = ordineprodotto.idProdotto and ordine.utente = ?;
*/


public class ProvaListaOrdiniDao {
	
	public ProvaListaOrdiniDao() {
		super();
	}
	
	public JSONArray getListaOrdini(String email) {
		//ListaOrdini listaOrdini=new ListaOrdini();
		JSONArray jArray = new JSONArray();

	try {
		Connection con;		
		con = DriverManagerConnectionPool.getConnection();					
		PreparedStatement ps= con.prepareStatement("select "
				+ "ordine.numOrdine,utente,data,numeroCarta,nomeSpedizione,cognomeSpedizione,indirizzo,citt‡,cap,provincia,"
				+ "nomeIntestatario,cognomeIntestatario,meseScadenza,annoScadenza,cvv,"
				+ "idProdotto,quantit‡,nome,prezzo,foto,categoria,descrizione "
				+ "from ordine join ordineprodotto join prodotto "
				+ "where ordine.numOrdine = ordineprodotto.numOrdine "
				+ "and prodotto.id = ordineprodotto.idProdotto and ordine.utente = ? "
				+ "order by ordine.numOrdine;");
		ps.setString(1, email);

		ResultSet rs = ps.executeQuery();
		
		
		
		//int numeroOrdine=-1;
//		carrello=new Carrello();
//		ordine=new Ordine();

//		ArrayList<Ordine> preListaOrdini=new ArrayList <Ordine>();
		while(rs.next()) {
		 
			
			JSONObject jObj = new JSONObject();
		    //dati prodotto
		    jObj.put("categoria", rs.getString("categoria"));
		    jObj.put("descrizione", rs.getString("descrizione"));
		    jObj.put("foto", rs.getString("foto"));
		    jObj.put("idProdotto", rs.getInt("idProdotto"));
		    jObj.put("nomeProdotto", rs.getString("nome"));
		    jObj.put("prezzo", rs.getFloat("prezzo"));
		    //dati ordine
		    jObj.put("numOrdine",rs.getInt("numOrdine"));
		    jObj.put("utente",rs.getString("utente"));
		    jObj.put("data",rs.getString("data"));
		    jObj.put("numeroCarta",rs.getString("numeroCarta"));
		    jObj.put("nomeSpedizione",rs.getString("nomeSpedizione"));
		    jObj.put("cognomeSpedizione",rs.getString("cognomeSpedizione"));
		    jObj.put("indirizzo",rs.getString("indirizzo"));
		    jObj.put("citt‡",rs.getString("citt‡"));
		    jObj.put("cap",rs.getString("cap"));
		    jObj.put("provincia",rs.getString("provincia"));
		    jObj.put("nomeIntestatario",rs.getString("nomeIntestatario"));
		    jObj.put("cognomeIntestatario",rs.getString("cognomeIntestatario"));
		    jObj.put("meseScadenza",rs.getInt("meseScadenza"));
		    jObj.put("annoScadenza",rs.getInt("annoScadenza"));
		    jObj.put("cvv",rs.getInt("cvv"));
		    
		    jArray.put(jObj);
			
			
			
			
			
		/*	if(numeroOrdine==rs.getInt("numOrdine")) {
				//allora Ë lo stesso ordine ma prodotto diverso, crea ProdottoBean->crea itemOrder->aggiungi al carrello
				categoria=rs.getString("categoria");
				descrizione=rs.getString("descrizione");
				foto=rs.getString("foto");
				id=rs.getInt("idProdotto");
				nome=rs.getString("nome");
				prezzo=rs.getFloat("prezzo");
				prodottoBean=new ProdottoBean(id,nome,descrizione,foto,categoria,0,prezzo);
				
				
				//prodottoBean.setCategoria(rs.getString("categoria"));
				//prodottoBean.setDescrizione(rs.getString("descrizione"));
				//prodottoBean.setFoto(rs.getString("foto"));
				//prodottoBean.setId(rs.getInt("idProdotto"));
				//prodottoBean.setNome(rs.getString("nome"));
				//prodottoBean.setPrezzo(rs.getFloat("prezzo"));
				
				itemOrder=new ItemOrder(prodottoBean,rs.getInt("quantit‡"));
				System.out.println("IF STESSO ORDINE- PRELEVATO PRODOTTO :"+prodottoBean.getNome());
				System.out.println("ITEM : nome->"+itemOrder.getNome()+" quantit‡->"+itemOrder.getQuantit‡Item());
				carrello.addItem(itemOrder);
			}
			else {
				//allora Ë un nuovo ordine, quindi aggiungi il carrello all'ordine e l'ordine alla listaOrdini, 				
				ordine.setNumOrdine(rs.getInt("numOrdine"));
				ordine.setUtente(rs.getString("utente"));
				ordine.setData(rs.getString("data"));
				ordine.setNumeroCarta(rs.getString("numeroCarta"));
				ordine.setNomeSpedizione(rs.getString("nomeSpedizione"));
				ordine.setCognomeSpedizione(rs.getString("cognomeSpedizione"));
				ordine.setIndirizzo(rs.getString("indirizzo"));
				ordine.setCitt‡(rs.getString("citt‡"));
				ordine.setCap(rs.getString("cap"));
				ordine.setProvincia(rs.getString("provincia"));
				ordine.setNomeIntestatario(rs.getString("nomeIntestatario"));
				ordine.setCognomeIntestatario(rs.getString("cognomeIntestatario"));
				ordine.setMeseScadenza(rs.getInt("meseScadenza"));
				ordine.setAnnoScadenza(rs.getInt("annoScadenza"));
				ordine.setCvv(rs.getInt("cvv"));
				ordine.setCarrello(carrello);

				
//				preListaOrdini.add(ordine);
				listaOrdini.addOrdine(ordine);		
//				listaOrdini.setListaOrdini(preListaOrdini);

				//pulisci carrello, a quel punto ripeti i passi di sopra
				carrello.clearCarrello();

				categoria=rs.getString("categoria");
				descrizione=rs.getString("descrizione");
				foto=rs.getString("foto");
				id=rs.getInt("idProdotto");
				nome=rs.getString("nome");
				prezzo=rs.getFloat("prezzo");
				prodottoBean=new ProdottoBean(id,nome,descrizione,foto,categoria,0,prezzo);
				itemOrder=new ItemOrder(prodottoBean,rs.getInt("quantit‡"));
				carrello.addItem(itemOrder);
				System.out.println("ELSE NUOVO ORDINE- PRELEVATO PRODOTTO :"+prodottoBean.getNome());

			}*/
			//aggiorna numeroOrdine
			//numeroOrdine=rs.getInt(1);
		}
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
	System.out.println("PROVA FINALE PROVALISTAORDINIDAO: LUNGHEZZA LISTAORDINI: "+jArray.length()+"     EXPECTED 15+");
	return jArray;
	}
}
