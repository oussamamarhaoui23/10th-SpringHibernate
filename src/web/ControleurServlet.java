package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IProduitMetier;
import dao.Produit;
import dao.ProduitMetierImpl;
@WebServlet(name="cs", urlPatterns = {"/controleur", "*.do"})
public class ControleurServlet extends HttpServlet{
	
	private IProduitMetier metier;
	
	@Override
	public void init() throws ServletException {
		metier = new ProduitMetierImpl();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String path= request.getServletPath();
	   if(path.equals("/index.do")) {
		   request.setAttribute("produits", metier.listProduits());
		   request.getRequestDispatcher("produits.jsp").forward(request, response);
	   }else if(path.equals("/chercher.do")) {
		   ProduitModel model = new ProduitModel();
		   String motCle = request.getParameter("motCle");
		   model.setMotCle(motCle);
		   List<Produit> prods = metier.ProduitParMC("%"+motCle+"%");
		   model.setProduits(prods);
		   request.setAttribute("model", model);
		   request.getRequestDispatcher("produits.jsp").forward(request, response);

	   }else if(path.equals("/saisie.do")) {
		   request.getRequestDispatcher("saisieProduit.jsp").forward(request, response);
	   }else if(path.equals("/saveProduit.do") && (request.getMethod().equals("POST"))) {
		   String designation = request.getParameter("designation");
		   double prix = Double.parseDouble(request.getParameter("prix"));
		   int quantite = Integer.parseInt(request.getParameter("quantite"));
		   Produit p = metier.addProduit(new Produit(designation, prix, quantite));
		   request.setAttribute("produit", p);
		   request.getRequestDispatcher("Confirmation.jsp").forward(request, response);

		   
	   }else if(path.equals("/delete.do")) {
		   Long id = Long.parseLong(request.getParameter("id"));
           metier.delete(id);
           response.sendRedirect("index.do");
	   }else if(path.equals("/edit.do")) {
		   Long id = Long.parseLong(request.getParameter("id"));
           Produit p = metier.getProduit(id);
		   request.setAttribute("produit", p);
		   request.getRequestDispatcher("EditProduit.jsp").forward(request, response);
	   }else if(path.equals("/updateProduit.do") && (request.getMethod().equals("POST"))) {
		   Long id = Long.parseLong(request.getParameter("id"));
		   String designation = request.getParameter("designation");
		   double prix = Double.parseDouble(request.getParameter("prix"));
		   int quantite = Integer.parseInt(request.getParameter("quantite"));
		   Produit p = new Produit(designation, prix, quantite);
		   p.setId(id);
		   metier.update(p);
		   request.setAttribute("produit", p);
		   request.getRequestDispatcher("Confirmation.jsp").forward(request, response);
	   }
	}
   @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
}
}
