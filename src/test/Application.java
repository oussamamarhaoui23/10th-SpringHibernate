package test;

import java.util.List;

import dao.IProduitMetier;
import dao.Produit;
import dao.ProduitMetierImpl;

public class Application {

	public static void main(String[] args) {
         IProduitMetier metier = new ProduitMetierImpl();
         metier.addProduit(new Produit("MacBook Pro", 12000, 23));
         metier.addProduit(new Produit("HP 8443", 8000, 9));
         metier.addProduit(new Produit("Imprimante HP 238", 9849, 14));
         
         List<Produit> prods = metier.listProduits();
         for(Produit p:prods) {
        	 System.out.println(p.toString());
         }
         
         System.out.println("--------------------");
         List<Produit> prods1 = metier.ProduitParMC("%Imp%");
         for(Produit p1:prods1) {
        	 System.out.println("Produit par MC : "+p1.toString());
         }
         System.out.println("----------------------------");
         Produit p = metier.getProduit(1L);
         System.out.println(p.getDesignation());
         System.out.println(p.getPrix());
         
         p.setPrix(1111);
         metier.update(p);
         metier.delete(3L);
         
	}

}
