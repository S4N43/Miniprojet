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

</br>
<h>BIBLIOTHEQUE FSBM</h>
</br>
</br>
<form action="Adduser" method="post">
Login:<input type="text" name="log" /><br/>
Password:<input type="password" name="pass" /><br/>
Role: <select name="role">
<option>admin</option>
<option>etudiant</option>
</select>
<a href='index.jsp'>
<input type="submit" value="envoyer" />
</a>
</form>


<hr/>
<hr/>
<div class="row">
<div class="col-md-4">
<form action="test" method="post">
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Login</label>
    <input type="text" name="log" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input type="password" name="pass" class="form-control" id="exampleInputPassword1">
  </div>
  
  <button type="submit" class="btn btn-primary" >Submit</button>
</form>
</div>
</div>
<%
if(request.getParameter("res")!=null)
{
	if(request.getParameter("res").equals("err"))
	{
		%>
		<p>UserName or Password is Incorrect ..!</p>
		<%	
	}
}
%>

</body>
</html>