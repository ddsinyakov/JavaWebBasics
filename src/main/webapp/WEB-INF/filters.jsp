<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String fromDemoFilter = (String) request.getAttribute("DemoFilter");
%>


<html>
<head>
    <title>Filters</title>
</head>
<body>
    Filters

    <p>
        <% if (fromDemoFilter == null) { %>
            Do not work!
        <% } else { %>
            <%=fromDemoFilter%>
        <% }  %>
    </p>

    <p>
        User count: <%=request.getAttribute("Count")%>
    </p>
</body>
</html>
