package dao;

import java.util.List;

public interface IProduitMetier {
   public Produit addProduit(Produit p);
   public List<Produit> listProduits();
   public List<Produit> ProduitParMC(String mc);
   public Produit getProduit(Long id);
   public void update(Produit p);
   public void delete(Long id);
}
