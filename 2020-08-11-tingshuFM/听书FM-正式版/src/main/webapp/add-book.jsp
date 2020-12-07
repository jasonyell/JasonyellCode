<%@ page import="com.jasonyell.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("/login.html");
        return;
    }
%>

<html>
<head>
    <title>听书FM | 上传书籍</title>
</head>
<body>
    <form method="post" action="/post-book">
        <div>
            <label for="title">
                书籍标题：
                <input type="text" id="title" name ="title">
            </label>
        </div>
        <div>
            <label>
                <button type="submit">上传</button>
            </label>
        </div>
    </form>
</body>
</html>
