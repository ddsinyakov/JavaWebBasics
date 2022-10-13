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

        <p>Repeat Password:</p>
        <label for="repeatPassword">repeat password</label>
        <input type="password" id="repeatPassword">
        <br>
    </form>

    <br>
    <jsp:include page="WEB-INF/footer.jsp" />
</body>
</html>