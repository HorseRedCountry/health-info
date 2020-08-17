
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+
                request.getServerName()+":"+
                request.getServerPort()+path+"/";
    %>
    <base href="<%=basePath%>"/>
    <title>主页</title>
</head>
<body>
<img width="900" height="482" alt="" style="background: url(img/index.jpg) no-repeat center;" >
</body>
</html>
