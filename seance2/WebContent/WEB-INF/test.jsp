<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="menu.jsp" %>
Bonjour bienvenue dans la ... JSP
<%
String Variable = (String)request.getAttribute("msg");
out.println("Contenu du msg : "+Variable);
%>
<br/>
<%
String c = (String)request.getAttribute("c");
if(c.equals("jour")) {
	out.println("Bonjour");
}
else {
	out.println("Bonne nuit");
}
%>

</body>
</html>