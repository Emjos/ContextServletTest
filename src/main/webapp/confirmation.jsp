<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15.07.2022
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Note Save</title>
</head>
<body>
<h2>Note has been save</h2>
<a href="<%= request.getAttribute("noteUrl")%>">Go to note</a>
</body>
</html>
