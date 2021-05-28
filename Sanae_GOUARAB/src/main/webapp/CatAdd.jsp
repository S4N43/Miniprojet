<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.css" rel="stylesheet" />
<script src="js/bootstrap.js" ></script>
</head>
<body>

 <div class="row">
<div class="col-md-4">
<form action="Addcat" method="post">
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Nom de categorie</label>
    <input type="text" name="nom_cat" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
  
  <button type="submit" class="btn btn-primary" >Ajouter categorie</button>
</form>
</div>
</div>
 
 
</body>
</html>
