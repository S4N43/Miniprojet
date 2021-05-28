<%@page import="com.util.livre"%>
<%@page import="java.util.List" %>
<%@page import="com.util.Bibmanager"%>
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
livre lt=(livre) session.getAttribute("livre");
%>

<%
List<livre> ls=um.alllivres();
%>

<table id="tabuser">
  <thead>
    <tr>
      <th scope="col">Nome de livre</th>
      <th scope="col">Nome de Auteur</th>
      <th scope="col">Id de sa categorie</th>
    </tr>
  </thead>
  <tbody>
  	<%
	for(livre l: ls){
	%>	
    <tr>
      <td><%=l.getNom_liv() %></td>
      <td><%=l.getNom_aut() %></td>
      <td><%=l.getClecat() %></td>
    </tr>
    <%
	}
	%>
  </tbody> 
  </table>

</body>
</html>