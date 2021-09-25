package web;

import java.util.ArrayList;
import java.util.List;

import dao.Produit;

public class ProduitModel {
   private List<Produit> produits = new ArrayList<Produit>();
   private String motCle;
   
   public ProduitModel() {
	// TODO Auto-generated constructor stub
}

public List<Produit> getProduits() {
	return produits;
}

public void setProduits(List<Produit> produits) {
	this.produits = produits;
}

public String getMotCle() {
	return motCle;
}

public void setMotCle(String motCle) {
	this.motCle = motCle;
}
}
