<%@ page import="step.learning.entities.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    User user = (User) request.getAttribute("AuthUser");
    String error = (String) request.getAttribute("AuthError");
    String path = request.getContextPath();
%>

<div class="auth-fragment">

    <% if (user == null ) { %>

        <form method="post" action="">
            <label>
                Login:
                <input type="text" name="userLogin">
            </label>

            <label>
                Password:
                <input type="text" name="userPassword">
            </label>

            <input type="hidden" name="userForm" value="true">

            <input type="submit" value="Submit">
            <a class="auth-sign-up" href="<%=path%>/register/"> Sign up</a>
        </form>

    <% } else { %>
        <h1>
           Username: <%=user.getName()%>
        </h1>

        <a href="<%=path%>/profile">
            <img src="<%=path%>/image/<%=user.getAvatar()%>" alt="" class="avatar">
        </a>

        <% if (user.getEmailCode() != null) { %>
            <a href="<%=path%>/checkmail/" title="You need to confirm your email">&#x1F4E7;</a>
        <% } %>

        <a href="?logout=true">Log out</a>
    <% } %>


</div>
