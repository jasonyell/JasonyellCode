<%--
  Created by IntelliJ IDEA.
  User: JasonYell
  Date: 2021/4/3
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>hello spring</h2>
    <%=request.getParameter("username")%><br>
    <%=request.getParameter("name")%>
<hr>
${username}
</body>
</html>
