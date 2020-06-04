package meowshop.bean;

import java.util.ArrayList;

public class ListaOrdini {
	ArrayList<Ordine> listaOrdini;
	
	public ListaOrdini() {
		super();
		listaOrdini=new ArrayList<Ordine>();
	}

	public ListaOrdini(ArrayList<Ordine> listaOrdini) {
		super();
		listaOrdini=new ArrayList<Ordine>();
		this.listaOrdini = listaOrdini;
	}
	
	public void addOrdine(Ordine ordine) {
		Ordine nuovoOrdine=new Ordine(ordine.getCarrello(),ordine.getNumOrdine(),ordine.getUtente(),
				ordine.getData(),ordine.getNumeroCarta(),ordine.getNomeSpedizione(),ordine.getCognomeSpedizione(),
				ordine.getIndirizzo(),ordine.getCittà(),ordine.getCap(),ordine.getProvincia(),ordine.getNomeIntestatario(),ordine.getCognomeIntestatario(),
				ordine.getMeseScadenza(),ordine.getAnnoScadenza(),ordine.getCvv());
		this.listaOrdini.add(nuovoOrdine);		
	}
	
	public Ordine getOrdine(int i) {
		return this.listaOrdini.get(i);
	}
		
	public ArrayList<Ordine> getListaOrdini() {
		return listaOrdini;
	}

	public void setListaOrdini(ArrayList<Ordine> listaOrdini) {
		this.listaOrdini = listaOrdini;
	}
	
	public int lunghezzaListaOrdini() {
		return this.listaOrdini.size();
	}

	
}
