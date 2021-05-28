<%@page import="java.util.List" %>
<%@page import="com.util.cate"%>
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
cate ct=(cate) session.getAttribute("categorie");
%>

<%
List<cate> cs=um.allcat();
%>

<table id="tabuser">
  <thead>
    <tr>
      <th scope="col">ID de categorie</th>
      <th scope="col">Nome de categorie</th>
    </tr>
  </thead>
  <tbody>
  	<%
	for(cate c: cs){
	%>	
    <tr>
      <td><%=c.getClecat() %></td>
      <td><%=c.getNom_cat() %></td>
    </tr>
    <%
	}
	%>
  </tbody> 
  </table>

</body>
</html>