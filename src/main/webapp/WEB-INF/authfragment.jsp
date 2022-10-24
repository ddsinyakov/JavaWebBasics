<%@ page import="step.learning.entities.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    User user = (User) request.getAttribute("AuthUser");
    String error = (String) request.getAttribute("AuthError");
    String path = request.getContextPath();
%>

<div class="auth-fragment">

    <form method="post" action="">
        <label>
            Login:
            <input type="text" name="userLogin">
        </label>

        <label>
            Password:
            <input type="text" name="userPassword">
        </label>

        <input type="submit" value="Submit">
        <a class="auth-sign-up" href="<%=path%>/register/"> Sign up</a>
    </form>

    <% if (user != null) { %>
       <h1>
           Username: <%=user.getName()%>
       </h1>
        <a href="?logout=true">Log out</a>
    <% } else if (error != null) { %>
        <h2>User not found</h2>
    <% } %>

</div>
