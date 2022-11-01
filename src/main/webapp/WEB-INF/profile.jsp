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
      <span>Name:</span> <b data-fieldname="name"><%= authUser.getName() %></b>
    </p>
    <p class="profile-name">
      <span>Login:</span> <b data-fieldname="login"><%= authUser.getLogin() %></b>
    </p>
    <p class="profile-name">
      <span>E-mail:</span> <b data-fieldname="email"><%= authUser.getEmail() %></b>
    </p>
    <p class="profile-fieldset-avatar">
      <span>Image:</span>
      <input type="file" id="avatar-input" name="avatar-input"> <br>
      <input type="button" value="Save" id="avatar-save-button">
    </p>
  </fieldset>

</div>
<script>
  document.addEventListener( "DOMContentLoaded", () => {
    const avatarSaveButton = document.getElementById("avatar-save-button")
    if (!avatarSaveButton) throw "'#avatar-save-button' not found"

    avatarSaveButton.addEventListener('click', avatarSaveClick)

    for(let element of  document.querySelectorAll( ".profile-name b" )) {
      element.addEventListener( "click", nameClick )
      element.addEventListener( "blur", nameBlur )
      element.addEventListener( "keydown", nameKeyDown )
    }
  });

  function nameClick(e) {
    e.target.setAttribute( "contenteditable", "true" )
    e.target.focus()
    e.target.savedText = e.target.innerText
  }

  function nameBlur(e) {
    e.target.removeAttribute( "contenteditable" )
    if( e.target.savedText !== e.target.innerText ) {
      if( confirm( "Сохранить изменения?" ) ) {
        const fieldName = e.target.getAttribute("data-fieldname")
        const fieldValue = e.target.innerText
        const url = "/WebBasics/register/?" + fieldName + "=" + fieldValue
        console.log(url)
        fetch( url, {
          method: "PUT",
          headers: {},
          body: ""
        })
          .then( r => r.text() )
          .then( t => {
            console.log(t)
            if (t === "Ok") location = location
            else {
              e.target.innerText = e.target.savedText
              alert(t)
            }
          } ) ;
      }
      else {
        e.target.innerText = e.target.savedText
      }
    }
  }

  function nameKeyDown(e) {
    if (e.keyCode === 13) {
      e.preventDefault()
      e.target.blur()
      return false
    }
  }

  function avatarSaveClick(e) {
    const avatarInput = document.getElementById("avatar-input")
    if (!avatarInput) throw "'#avatar-input' not found"

    if(avatarInput.files.length === 0) {
      alert("Select file")
      return
    }

    let formData = new FormData()
    formData.append("userAvatar", avatarInput.files[0])

    fetch( "/WebBasics/register/", {
      method: "PUT",
      headers: {},
      body: formData
    })
      .then( r => r.text() )
      .then( t => {
        if (t === "Ok") location = location
        else alert(t)
      } ) ;
  }
</script>