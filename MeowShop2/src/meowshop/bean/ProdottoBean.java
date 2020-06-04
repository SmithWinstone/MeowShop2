package meowshop.bean;

import meowshop.dao.ProdottoDao;

public class ProdottoBean {

	String nome, descrizione,foto,categoria;
	int nDisponibili, id;
	float prezzo;
	
	public ProdottoBean() { }
	
	public ProdottoBean(int id) {		
		ProdottoDao dao=new ProdottoDao();
		ProdottoBean p=dao.getProdotto(id);
		this.nome=p.getNome();
		this.descrizione=p.getDescrizione();
		this.foto=p.getFoto();
		this.categoria=p.getCategoria();
		this.nDisponibili=p.getnDisponibili();
		this.id=p.getId();
		this.prezzo=p.getPrezzo();
	}
	
	
	public ProdottoBean(int id, String nome, String descrizione, String foto, String categoria, int nDisponibili,
			float prezzo) {
		this.id = id;
		this.nome = nome;
		this.descrizione = descrizione;
		this.foto = foto;
		this.categoria = categoria;
		this.nDisponibili = nDisponibili;
		this.prezzo = prezzo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getnDisponibili() {
		return nDisponibili;
	}

	public void setnDisponibili(int nDisponibili) {
		this.nDisponibili = nDisponibili;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}	
	
	
}

