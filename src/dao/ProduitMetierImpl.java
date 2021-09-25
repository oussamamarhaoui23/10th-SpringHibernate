package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import util.HibernateUtil;

public class ProduitMetierImpl implements IProduitMetier{

	@Override
	public Produit addProduit(Produit p) {
		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		//avant de faire toute application dans la bd il faudrait que l'operation soit transactionel.
		//je commence la transaction.
		session.beginTransaction();
		//Enregistrer le produit
		try {
			session.save(p);
		} catch (Exception e) {
			//s'il y a une exception on fait rollback sinon il suffit de faire commit.
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		//pour l'operation soit prise en considération il faudrait valider la transaction
		session.getTransaction().commit();
		return p;
	}

	@Override
	public List<Produit> listProduits() {
		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		//pour executer une requête on va créer un objet de type Query
		/*il y a 2 méthode createQuery:  et createSQLQuery : vous écrivez la requête SQL c'est de langage purement SQL ce qui est déconseiller.
		 * pcq quand on fait le Mapping objet relationnel je n'ai pas forcément besoin de savoir ce qu'est ce passe au niveau de la bd. 
		 * Mais quand on fait le mapping objet relationnel tout ce que je connais c'est la classe Produit
		 * donc avec la  méthode Query on va utiliser ce qu'on appelle le HQL : hibernate query language.
		 * le langage HQL la différence par rapport SQL au lieu de manipuler les tables et les relations entre les tables, 
		 * je manipule que les classes et les relations entre les classes et ce que devant moi  c'est un diagramme de classe et non pas un modele relationnel.
		 */
		Query query = session.createQuery("select p from Produit p");
		List<Produit> prods = query.list(); //méthode list permet de retouner la liste des produits
		/*
		 * Imaginer qu'est ce qui passe, Hibernate qu'est ce qu'il va faire?
		 * 1 - va executer la requete SQL
		 * 2 - va récuperer un objet ResultSet.
		 * 3- va créer un objet PreparedStatement
		 * 4- créer une list de produit apres while
		 * 5- pour chaque ligne il récupere les données de la ligne et les stockes dans un objet de type produit et la fin il donne LA LISTE.
		 *
		 */
		session.getTransaction().commit();
		return prods;
	}

	@Override
	public List<Produit> ProduitParMC(String mc) {
		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("select p from Produit p where p.designation like :x");
		query.setParameter("x", "%"+mc+"%");
		List<Produit> prods = query.list();
		session.getTransaction().commit();
		return prods;
	}

	@Override
	public Produit getProduit(Long id) {
		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		//créer un objet list
		Object p = session.get(Produit.class, id);
		//il faut tester si objet !!= null
		if(p==null) throw new  RuntimeException("Produit Introuvable"); //exception non serveillé
		session.getTransaction().commit();
		//faire un sous casting
		return (Produit) p;
	}

	@Override
	public void update(Produit p) {
		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		session.update(p);
		session.getTransaction().commit();
		
	}

	@Override
	public void delete(Long id) {
		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		Object p = session.get(Produit.class, id);
		if(p==null) throw new  RuntimeException("Produit Introuvable"); //exception non serveillé
		session.delete(p);
		session.getTransaction().commit();
	}

}
