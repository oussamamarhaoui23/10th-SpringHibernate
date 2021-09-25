<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Saisir un produit</title>
</head>
<body>
 <%@include file="header.jsp" %>
   <p></p>
   <div class="container">
     <div class="card">
       <div class="card-header">Saisie un produit</div>
       <div class="card-body">
       
          <form action="updateProduit.do" method="post">
           <div class="form-group">
             <label class="control-label"> ID : </label> <label>${produit.id}</label>
             <input type="hidden" name="id" class="form-control" value="${produit.id}">
          </div>
          
           <div class="form-group">
             <label class="control-label">Désignation : </label>
             <input type="text" name="designation" class="form-control" value="${produit.designation}">
          </div>
          
           <div class="form-group">
             <label class="control-label">Prix : </label>
             <input type="text" name="prix" class="form-control" value="${produit.prix}">
          </div>
          
           <div class="form-group">
             <label class="control-label">Quantité : </label>
             <input type="text" name="quantite" class="form-control"value="${produit.quantite}">
          </div>
          
           <div class="form-group">
             <button class="btn btn-outline-primary">Update</button>
          </div>
          </form>
         
       </div>
     </div>
   </div>
   
</body>
</html>