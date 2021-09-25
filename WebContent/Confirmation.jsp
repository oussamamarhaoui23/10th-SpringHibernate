<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Saisir un produit</title>
</head>
<script type="text/javascript">
  function returnHome(){
	  document.location="index.do";  }
</script>
<body>
 <%@include file="header.jsp" %>
   <p></p>
   <div class="container">
     <div class="card">
       <div class="card-header">Confirmation d'un produit</div>
       <div class="card-body">
           
           <div class="form-group">
             <label class="control-label">Désignation : </label>
             <label>${produit.designation}</label>
          </div>
          
           <div class="form-group">
             <label class="control-label">Prix : </label>
             <label>${produit.prix}</label>
          </div>
          
           <div class="form-group">
             <label class="control-label">Quantité : </label>
             <label>${produit.quantite}</label>
          </div>
          
           <div class="form-group">
             <button class="btn btn-outline-success" onclick="returnHome()">Return</button>
          </div>
         
       </div>
     </div>
   </div>
   
</body>
</html>