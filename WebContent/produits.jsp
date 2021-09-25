<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Produits</title>
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
  <div class="container">
    <div class="card">
      <div class="card-header">Products Lists</div>
      <div class="card-body">
        
        <form action="chercher.do" method="get">
           <div class="row">
           Chercher :  <div class="col-auto">
                <input type="text" name="motCle">
             </div>
             <div class="col-auto">
               <button class="btn btn-outline-primary" type="submit">Chercher </button>
             </div>
            </div>
         
        </form>
       <table class="table table-striped">
               <tr>
                 <th>ID</th>
                 <th>Désignation</th>
                 <th>Prix</th>
                 <th>Quantité</th>
               </tr>
               <c:forEach items="${produits}" var="p">
                 <tr>
                   <td>${p.id}</td>
                   <td>${p.designation}</td>
                   <td>${p.prix}</td>
                   <td>${p.quantite}</td>
                   <td>
                    <a class="btn btn-outline-danger" href="delete.do?id=${p.id}">Delete</a>
                   </td>
                   <td>
                   <a class="btn btn-outline-success" href="edit.do?id=${p.id}">Update</a>
                   </td>
                 </tr>
               </c:forEach>
            </table>
        
        
      </div>
    </div>
  </div>
</body>
</html>