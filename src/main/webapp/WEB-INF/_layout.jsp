<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String pageBody = "/WEB-INF/" + request.getAttribute("pageBody");
    String path = request.getContextPath();
%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="<%=path%>/styles/style.css">
    <title>Document</title>
</head>
<body>
    <jsp:include page="/WEB-INF/authfragment.jsp" />

    <jsp:include page="<%=pageBody%>"/>


    <jsp:include page="footer.jsp" />
</body>
</html>
