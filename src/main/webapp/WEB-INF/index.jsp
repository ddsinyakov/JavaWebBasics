<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String login = (String) request.getSession().getAttribute("login");
    String password = (String) request.getSession().getAttribute("password");
    String repeatPassword = (String) request.getSession().getAttribute("repeatPassword");

    String path = request.getContextPath();
%>


<!doctype html>
<html lang="en">

<jsp:include page="/WEB-INF/headerfragment.jsp"/>

<body>

<%--    <jsp:include page="/WEB-INF/authfragment.jsp" />--%>

    <h1>Main</h1>

    <nav>
        <a href="filters">Filters</a>
        <a href="guice">Inversion</a>
    </nav>

    <form method="post">
        <p>Login:</p>
        <label for="login">Login</label>
        <input type="text" id="login" name="login">
        <br>

        <p>Password:</p>
        <label for="password">password</label>
        <input type="password" id="password" name="password">
        <br>

        <p>Repeat Password:</p>
        <label for="repeatPassword">repeat password</label>
        <input type="password" id="repeatPassword" name="repeatPassword">
        <br>

        <input type="hidden" value="true" name="loginForm">

        <input type="submit" value="Submit">
    </form>

    <div>

        <h2>Previous data</h2>

        <p>
            Login:
            <% if (login != null) { %>
                <%=login%>
            <% } %>
        </p>

        <p>
            Password:
            <% if (login != null) { %>
            <%=password%>
            <% } %>
        </p>

        <p>
            Repeat Password:
            <% if (repeatPassword != null) { %>
            <%=repeatPassword%>
            <% } %>
        </p>
    </div>

    <br>

    <jsp:include page="fragment.jsp" />
    <jsp:include page="footer.jsp" />
</body>
</html>