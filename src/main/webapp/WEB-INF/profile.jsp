<%@ page import="step.learning.entities.User" %>
<%@ page contentType="text/html;charset=UTF-8" %><%
  User authUser = (User) request.getAttribute( "AuthUser" ) ;
  String home = request.getContextPath() ;
%>
<div class="user-profile">
  <h1>Кабинет пользователя</h1>
  <img class="profile-avatar"
       src="<%=home%>/image/<%=authUser.getAvatar()%>"
       alt="<%=authUser.getLogin()%>" />

  <fieldset class="profile-fieldset">
    <legend>Возможно для изменения</legend>
    <p class="profile-name">
      <span>Name:</span> <b><%= authUser.getName() %></b>
    </p>
  </fieldset>
</div>
<script>
  document.addEventListener( "DOMContentLoaded", () => {
    const nameElement = document.querySelector( ".profile-name b" ) ;
    if( ! nameElement ) throw "'.profile-name b' not found" ;
    nameElement.addEventListener( "click", nameClick ) ;
    nameElement.addEventListener( "blur", nameBlur ) ;
  });
  function nameClick(e) {
    e.target.setAttribute( "contenteditable", "true" ) ;
    e.target.focus() ;
    e.target.savedText = e.target.innerText ;
  }
  function nameBlur(e) {
    e.target.removeAttribute( "contenteditable" ) ;
    if( e.target.savedText !== e.target.innerText ) {
      if( confirm( "Сохранить изменения?" ) ) {
        // console.log( e.target.innerText ) ;
        fetch( "/WebBasics/register/?name="+e.target.innerText, {
          method: "PUT",
          headers: {
          },
          body: ""
        }).then( r => r.text() )
                .then( t => console.log(t) ) ;
      }
      else {
        e.target.innerText = e.target.savedText ;
      }
    }
  }
</script>