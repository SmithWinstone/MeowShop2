package meowshop.bean;


/*ItemOrder{
ProdottoBean, int numItems
-ItemOrder(ProdottoBean)
- public ProdottoBean getItem()
-getters and setters
}
*/
public class ItemOrder {
	ProdottoBean prodotto;
	int quantit‡;
	
	public ItemOrder(ProdottoBean prodotto, int quantit‡) {
		this.prodotto = new ProdottoBean(prodotto.getId(),prodotto.getNome(),prodotto.getDescrizione(),prodotto.getFoto(),
				prodotto.getCategoria(),prodotto.getnDisponibili(),prodotto.getPrezzo());
		this.quantit‡ = quantit‡;
	}
	public ItemOrder(ProdottoBean prodotto) {
		super();
		this.prodotto = prodotto;
		this.quantit‡ = 1;
	}
	public ProdottoBean getProdotto() {
		return prodotto;
	}
	public void setProdotto(ProdottoBean prodotto) {
		this.prodotto = prodotto;
	}
	public int getQuantit‡Item() {
		return quantit‡;
	}
	public void setQuantit‡Item(int quantit‡) {
		this.quantit‡ = quantit‡;
	}
	
	public String getNome() {
		return this.prodotto.getNome();
	}
	public void setNome(String nome) {
		this.setNome(nome);
	}
	public String getDescrizione() {
		return this.prodotto.getDescrizione();
	}
	public void setDescrizione(String descrizione) {
		this.prodotto.setDescrizione(descrizione);
	}
	public String getFoto() {
		return this.prodotto.getFoto();
	}
	public void setFoto(String foto) {
		this.prodotto.setFoto(foto);
	}
	public String getCategoria() {
		return this.prodotto.getCategoria();
	}
	public void setCategoria(String categoria) {
		this.prodotto.setCategoria(categoria);
	}
	public int getnDisponibili() {
		return this.prodotto.getnDisponibili();
	}
	public void setnDisponibili(int nDisponibili) {
		this.prodotto.setnDisponibili(nDisponibili);
	}
	public int getId() {
		return this.prodotto.getId();
	}
	public void setId(int id) {
		this.prodotto.setId(id);
	}
	public float getPrezzo() {
		return this.prodotto.getPrezzo();
	}
	public void setPrezzo(float prezzo) {
		this.prodotto.setPrezzo(prezzo);
	}

	
	
	
	
	
}
