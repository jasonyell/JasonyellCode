<%--
  Created by IntelliJ IDEA.
  User: JasonYell
  Date: 2021/4/3
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSON</title>
</head>
<body>
    <input type="button" value="JSON请求" onclick="test()">
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        function test() {
            var params = '{"userName":"admin","userPwd":"123456"}';
            $.ajax({
               type:"post",
               url:"query04",
               data:params,
                contentType:"application/json;charset=UTF-8", // 传递JSON格式的数据
                dataType:"json", // 服务端返回数据格式是JSON格式
                success:function(data){
                    console.log(data);
                }
            });
        }
    </script>
</body>
</html>
