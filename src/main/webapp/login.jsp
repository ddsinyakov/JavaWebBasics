<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="/WebBasics">Home...</a>
    <br>

    <form>
        <p>Login:</p>
        <label for="login">Login</label>
        <input type="text" id="login">
        <br>

        <p>Password:</p>
        <label for="password">password</label>
        <input type="password" id="password">
        <br>
    </form>

    <br>
    <jsp:include page="WEB-INF/footer.jsp" />
</body>
</html>
