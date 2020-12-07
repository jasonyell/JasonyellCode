<%@ page import="com.jasonyell.service.BookService" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jasonyell.model.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%!
    // 这里定义属性方法
    private BookService bookService;

    public void jspInit() {
        bookService = new BookService();
    }
%>
<%
    // 这里是执行 java 代码
    List<Book> books = bookService.list();
%>
<!DOCTYPE html>
<html lang="zh-hans">
<head>
    <meta charset="utf-8">
    <title>听书FM </title>
</head>
<body>
    <header>
        <nav>
            <ol>
                <li><a href ="/register.html">注册</a></li>
                <li><a href ="/login.html">登录</a></li>
                <li><a href ="/add-book.jsp">上传书籍</a></li>
            </ol>
        </nav>
    </header>

    <main>
        <!--
            <ol>
                <li>
                    <a href="/book?bid=<bid>">书籍名称</a>上传者：用户名
                </li>
            </ol>
        -->
        <ol>
            <% for (Book book : books) { %>
            <li>
                <a href="/book.jsp?bid=<%= book.bid %>"><%= book.title %></a>
                <span>上传者: <%= book.user.username %></span>
            </li>
            <% } %>
        </ol>
    </main>
</body>
</html>
