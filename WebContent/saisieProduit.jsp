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
       
          <form action="saveProduit.do" method="post">
           <div class="form-group">
             <label class="control-label">Désignation : </label>
             <input type="text" name="designation" class="form-control">
          </div>
          
           <div class="form-group">
             <label class="control-label">Prix : </label>
             <input type="text" name="prix" class="form-control">
          </div>
          
           <div class="form-group">
             <label class="control-label">Quantité : </label>
             <input type="text" name="quantite" class="form-control">
          </div>
          
           <div class="form-group">
             <button class="btn btn-outline-primary">Save</button>
          </div>
          </form>
         
       </div>
     </div>
   </div>
   
</body>
</html>