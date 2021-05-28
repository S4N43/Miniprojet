<%@page import="com.util.Bibmanager"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.List" %>
<%@page import="com.util.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css.css" rel="stylesheet" />
</head>
<body>
<%
Bibmanager um=new Bibmanager();
User ut=(User) session.getAttribute("user");
%>

<% 
if(request.getParameter("op")!=null)
{
	if(request.getParameter("op").equals("Delete"))
	{
		int id = Integer.parseInt(request.getParameter("id"));
		um.deleteUser(id);
	}
	if(request.getParameter("op").equals("Update"))
	{
		int id = Integer.parseInt(request.getParameter("id"));
		um.updatUser(id,ut);
	}
}
%>

<%
List<User> us=um.allUsers();
%>

<table id="tabuser">
	<thead>
		<tr>
			<th>ID</th>
			<th>UserName</th>
			<th>Password</th>
			<th>Role</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<%
		for(User u: us)
		{
			if(ut.getRole().equalsIgnoreCase("admin")){
		%>
		<tr>
		<td><%= u.getId() %> </td>
		<td><%= u.getLog() %> </td>
		<td><%= u.getPass() %> </td>
		<td><%= u.getRole() %> </td>
		<td><a href='?op=Delete&id=<%=u.getId() %>'>Delete</a></td>
		</tr>
		<%} 
		else{%>
		<% if(ut.getId()==(u.getId())){%>
		<tr>
		<td><%= u.getId() %> </td>
		<td><%= u.getLog() %> </td>
		<td><%= u.getPass() %> </td>
		<td><%= u.getRole() %> </td>
		<td><a href='?op=Update&id=<%=u.getId() %>'>Update</a></td>
		</tr>
		<%} } }%>
	</tbody>
</table>

 
</br></br>
<div>
<% if(ut.getRole().equalsIgnoreCase("etudiant")) {%>
<a href='CatAff.jsp' ><button>Afficher les categories</button></a>
<a href='LivAff.jsp' ><button>Afficher les livres</button></a>
<%} %>
<% if(ut.getRole().equalsIgnoreCase("admin")) {%>
<td><a href='CatAdd.jsp'><button>Ajouter une categorie</button></a></td>
<td><a href='LivAdd.jsp'><button>Ajouter un livre</button></a></td>
<%} %>
</div>
</body>
</html>