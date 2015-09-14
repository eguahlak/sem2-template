<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List Page</title>
  </head>
  <body>
    <h1>List people page</h1>
    <hr/>
    <form action="Edit" method="POST">
      <ul>
        <c:forEach var="person" items="${people}">
          <li>(#${person.id}) ${person.name} ${person.email} <button value="${person.id}" name="id">Edit</button></li>
        </c:forEach>
      </ul>
    </form>
    <a href="Main">Main page</a>
  </body>
</html>
