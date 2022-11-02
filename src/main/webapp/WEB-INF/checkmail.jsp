<%@ page import="step.learning.entities.User" %><%--
  Created by IntelliJ IDEA.
  User: Дима Синяков
  Date: 01.11.2022
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User authUser = (User) request.getAttribute("AuthUser");
    String home = request.getContextPath();

    String confirmOk = (String) request.getAttribute("confirm");
    String confirmError = (String) request.getAttribute("confirmError");
%>

<div class="check-mail">

    <% if (confirmOk == null) { %>

        <% if(authUser == null) { %>
            <h1>You need to be authorized</h1>
        <% } else if(authUser.getEmailCode() == null) { %>
            <h1>Email is submitted</h1>
            <h2>If you want to change your email go to <a href="<%=home%>/profile">account settings</a></h2>
        <% } else if(authUser.getEmailCodeAttempts() > 3) { %>
            <h1>There are no attempts left</h1>
        <% } else { %>
            <h1>Submit Email</h1>
            <form>
                <label for="confirm">Confirm E-mail</label>
                <input type="text" name="confirm" id="confirm">
                <input type="submit" value="Submit">
            </form>
        <% } %>

        <% if (confirmError != null) { %>
            <b class="confirm-error"><%=confirmError%></b>
        <% } %>

    <% } else { %>
        <h1>E-mail confirmed</h1>
    <% } %>

</div>
