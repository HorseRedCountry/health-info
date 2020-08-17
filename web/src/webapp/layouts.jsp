
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

</body>
</html>
