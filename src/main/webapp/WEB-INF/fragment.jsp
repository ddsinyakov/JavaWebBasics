<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String[] languages = new String[] {"English", "Ukrainian", "Japan", "Chinese", "French"};
%>

<label for="languages"> Languages </label>

<select id="languages">
    <% for (String lang: languages) { %>
        <option value=""><%= lang %></option>
    <% } %>
</select>
