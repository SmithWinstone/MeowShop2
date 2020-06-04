package meowshop.bean;

import java.util.ArrayList;

/*Carrello{
Arraylist di ItemOrder
-Carrello()
-public List<ItemOrder> getItemsOrdered()
-public synchronized void addItem(int itemID)
-public synchronized void setNumOrdered(int itemID, int numOrdered)
}
*/
public class Carrello {
	ArrayList <ItemOrder> carrello;

	public Carrello() {
		this.carrello=new ArrayList<ItemOrder>();
	}
		
	public int getIndexProdotto(int itemID) {
		for(int i=0;i<carrello.size();i++) {
			if(carrello.get(i).getProdotto().getId()==itemID) {
				return i;
			}
		}
		return -1;
	}
	
	public synchronized void addItem(int itemID) {
		int indexProdotto=getIndexProdotto(itemID);
		if(indexProdotto==-1) {
			ProdottoBean prodotto=new ProdottoBean(itemID);
			ItemOrder item=new ItemOrder(prodotto);
			this.carrello.add(item);
			}
		else {
			setNumOrdered(itemID, carrello.get(indexProdotto).getQuantitàItem()+1);
		}
	}
	
	public synchronized void addItem(ItemOrder itemOrder) {
		ItemOrder item=new ItemOrder(itemOrder.getProdotto(),itemOrder.getQuantitàItem());
			this.carrello.add(item);
	}
	
	
	public void clearCarrello() {
		carrello.clear();
	}
	
	public void copiaCarrello(Carrello c) {
		for(int i=0;i<carrello.size();i++)
			c.addItem(this.carrello.get(i));
	}
	
	
	public synchronized void setNumOrdered(int itemID, int numOrdered) {
		for (ItemOrder i:carrello) {
			if(i.getProdotto().getId()==itemID) {
				i.setQuantitàItem(numOrdered);
			}
		}
	}
	
	public synchronized int getLunghezzaCarrello() {
		return carrello.size();
	}

	
	public synchronized ItemOrder getItemOrder(int index) {
		return carrello.get(index);
	}
	
}
