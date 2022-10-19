<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String hashed1 = (String) request.getSession().getAttribute("hashed1");
    String hashed2 = (String) request.getSession().getAttribute("hashed2");
    String path = request.getContextPath();
%>

<html>

<jsp:include page="/WEB-INF/headerfragment.jsp"/>

<body>
    <jsp:include page="/WEB-INF/authfragment.jsp" />

    <h1>Inversion</h1>

    <form method="post">

        <label for="toHash"></label>
        <input type="text" name="toHash" id="toHash">

        <input type="submit" value="Submit">

    </form>

    <h2>Hashed:</h2>

    <% if (hashed1 != null ) { %>
        <p><%= hashed1 %></p>
    <% } %>

    <% if (hashed2 != null ) { %>
        <p><%= hashed2 %></p>
    <% } %>
</body>
</html>
