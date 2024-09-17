<%--
  Created by IntelliJ IDEA.
  User: JasonYell
  Date: 2021/4/4
  Time: 2:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>

    <%--
        文件上传
            1.表单提交的请求方式 method = "POST"
            2.表单的类型 entype="multipart/form-data"
            3.设置文件域的name属性值
    --%>
    <h2>单文件上传</h2>
    <form action="uploadFile" method="post" enctype="multipart/form-data">
        <input type="file" name="file">
        <button>上传</button>
    </form>
    <hr>
    <h2>多文件上传</h2>
    <form action="uploadFiles" method="post" enctype="multipart/form-data">
        <input type="file" name="files">
        <input type="file" name="files">
        <input type="file" name="files">
        <button>上传</button>
    </form>
</body>
</html>
