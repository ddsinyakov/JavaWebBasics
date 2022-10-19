<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String fromDemoFilter = (String) request.getAttribute("DemoFilter");
    String[] users = (String[]) request.getAttribute("Users");
%>


<html>
<head>
    <title>Filters</title>
</head>
<body>
    <h1>Filters</h1>

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

    <ul>
        <% for(String user: users) { %>
            <%=user%> <br>
        <% } %>
    </ul>
</body>
</html>
