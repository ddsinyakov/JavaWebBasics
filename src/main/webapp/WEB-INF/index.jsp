<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String login = (String) request.getSession().getAttribute("login");
    String password = (String) request.getSession().getAttribute("password");
    String repeatPassword = (String) request.getSession().getAttribute("repeatPassword");
%>


<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

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