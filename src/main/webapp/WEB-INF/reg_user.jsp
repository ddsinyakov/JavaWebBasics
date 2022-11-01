<%-- Форма регистрации нового пользователя --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%--<%--%>
<%--    String home = request.getContextPath() ;--%>
<%--%>--%>

<%--<div class="container">--%>
<%--  <div class="row justify-content-center">--%>
<%--    <div class="col-md-5">--%>
<%--      <div class="card">--%>
<%--        <h2 class="card-title text-center">Register</h2>--%>
<%--        <div class="card-body py-md-4">--%>
<%--          <form method="post">--%>
<%--          <div class="form-group">--%>
<%--            <input type="text" class="form-control" name="userLogin" placeholder="Login" /> <br>--%>
<%--            <input type="text" class="form-control" name="userName" placeholder="Name Surname" /> <br>--%>
<%--            <input type="password" class="form-control" name="userPassword" placeholder="Password"> <br>--%>
<%--            <input type="password" class="form-control" name="confirmPassword" placeholder="Confirm password"><br>--%>
<%--          </div>--%>
<%--            <div class="d-flex flex-row align-items-center justify-content-between">--%>
<%--            <button type="submit" class="btn btn-primary">Create Account</button>--%>
<%--          </div>--%>
<%--          </form>--%>
<%--        </div>--%>
<%--      </div>--%>
<%--    </div>--%>
<%--  </div>--%>
<%--</div>--%>
<%@ page contentType="text/html;charset=UTF-8" %><%
  String home = request.getContextPath() ;
  String regError = (String) request.getAttribute( "regError" ) ;
  String regOk = (String) request.getAttribute( "regOk" ) ;

  String lastUserLogin = (String) request.getSession().getAttribute("lastUserLogin");
  String lastUserName = (String) request.getSession().getAttribute("lastUserName");
  String lastUserEmail = (String) request.getSession().getAttribute("lastUserEmail");
%>
<div class="container">
  <div class="row justify-content-center">
    <div class="col-md-5">
      <div class="card">
        <h2 class="card-title text-center">Register</h2>
        <% if( regError != null ) { %>
          <h3 class="card-title text-center reg-error"><%=regError%></h3>
        <% } %>
        <% if( regOk != null ) { %>
          <h3 class="card-title text-center reg-ok"><%=regOk%></h3>
        <% } %>
        <div class="card-body py-md-4">
          <form method="post" action="" enctype="multipart/form-data">
            <div class="form-group">
              <input type="text" class="form-control" name="userLogin" placeholder="Login"
                <% if (lastUserLogin != null) { %>
                      value="<%=lastUserLogin%>"
                <% } %>
              /><br>
              <input type="text" class="form-control" name="userName" placeholder="Name Surname"
                <% if (lastUserName != null) { %>
                     value="<%=lastUserName%>"
                <% } %>
              /><br>
              <input type="email" class="form-control" name="userEmail" placeholder="Email"
                <% if (lastUserEmail != null) { %>
                     value="<%=lastUserEmail%>"
                <% } %>
              /><br>
              <input type="password" class="form-control" name="userPassword" placeholder="Password"><br>
              <input type="password" class="form-control" name="confirmPassword" placeholder="Confirm password"><br>
              <input type="file" class="form-control" name="userAvatar">
            </div>
            <br>
            <div class="d-flex flex-row align-items-center justify-content-between">
              <button type="submit" class="btn btn-primary">Create Account</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>