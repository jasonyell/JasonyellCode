<%@page language="java" contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta charset="utf-8">
</head>
<body>
<h2>Hello World!</h2>

    <form action="data08" method="get">
        <%--List 参数--%>
        <input name="strList[0]" value="zhangsan" />
        <input name="strList[1]" value="list" />
        <%--map 参数 --%>
        <input name="map['aa']" value="AA" />
        <input name="map['bb']" value="BB" />
        <button type="submit"> 提交</button>
    </form>

</body>
</html>
