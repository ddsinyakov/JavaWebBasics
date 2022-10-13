<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <h1>Привет мир</h1>
    <br>

    <a href="login.jsp">Login</a>
    <a href="signup.jsp">Sign up</a>

    <img src="img/Tomcat.png" alt="" width="300">
    <img src="img/Glassfish.png" alt="" width="300">
    <br>
    Кіт їсть рибу

    <jsp:include page="WEB-INF/fragment.jsp" />

    <jsp:include page="WEB-INF/footer.jsp" />
</body>
</html>