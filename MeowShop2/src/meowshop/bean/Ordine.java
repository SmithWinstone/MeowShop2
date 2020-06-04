package meowshop.bean;

public class Ordine {
	Carrello carrello;
	String utente,data,numeroCarta,nomeSpedizione,cognomeSpedizione,indirizzo,città,cap,provincia,nomeIntestatario,cognomeIntestatario;
	int meseScadenza,annoScadenza,cvv,numOrdine;
	
	public Ordine() {
		super();
	}
	
	public Ordine(Carrello carrello,int numOrdine, String utente, String data, String numeroCarta, String nomeSpedizione,String cognomeSpedizione,
			String indirizzo, String città, String cap, String provincia, String nomeIntestatario,
			String cognomeIntestatario, int meseScadenza, int annoScadenza, int cvv) {
		super();
		this.carrello=new Carrello();
		carrello.copiaCarrello(this.carrello);
		this.numOrdine = numOrdine;
		this.utente = utente;
		this.data = data;
		this.numeroCarta = numeroCarta;
		this.cognomeSpedizione = cognomeSpedizione;
		this.nomeSpedizione = nomeSpedizione;
		this.indirizzo = indirizzo;
		this.città = città;
		this.cap = cap;
		this.provincia = provincia;
		this.nomeIntestatario = nomeIntestatario;
		this.cognomeIntestatario = cognomeIntestatario;
		this.meseScadenza = meseScadenza;
		this.annoScadenza = annoScadenza;
		this.cvv = cvv;
	}
	public int getNumOrdine() {
		return numOrdine;
	}

	public void setNumOrdine(int numOrdine) {
		this.numOrdine = numOrdine;
	}

	public Carrello getCarrello() {
		return carrello;
	}
	public void setCarrello(Carrello carrello) {
		this.carrello = carrello;
	}
	public String getUtente() {
		return utente;
	}
	public void setUtente(String utente) {
		this.utente = utente;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getNumeroCarta() {
		return numeroCarta;
	}
	public void setNumeroCarta(String numeroCarta) {
		this.numeroCarta = numeroCarta;
	}
	public String getNomeSpedizione() {
		return nomeSpedizione;
	}
	public void setNomeSpedizione(String nomeSpedizione) {
		this.nomeSpedizione = nomeSpedizione;
	}
	public String getCognomeSpedizione() {
		return cognomeSpedizione;
	}
	public void setCognomeSpedizione(String cognomeSpedizione) {
		this.cognomeSpedizione = cognomeSpedizione;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getCittà() {
		return città;
	}
	public void setCittà(String città) {
		this.città = città;
	}
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getNomeIntestatario() {
		return nomeIntestatario;
	}
	public void setNomeIntestatario(String nomeIntestatario) {
		this.nomeIntestatario = nomeIntestatario;
	}
	public String getCognomeIntestatario() {
		return cognomeIntestatario;
	}
	public void setCognomeIntestatario(String cognomeIntestatario) {
		this.cognomeIntestatario = cognomeIntestatario;
	}
	public int getMeseScadenza() {
		return meseScadenza;
	}
	public void setMeseScadenza(int meseScadenza) {
		this.meseScadenza = meseScadenza;
	}
	public int getAnnoScadenza() {
		return annoScadenza;
	}
	public void setAnnoScadenza(int annoScadenza) {
		this.annoScadenza = annoScadenza;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	
}
