<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit Page</title>
  </head>
  <body>
    <h1>Edit person page</h1>
    <hr/>
    <form action="Save" method="POST">
      <input type="hidden" name="id" value="${person.id}"/>
      <table>
        <tr><th>ID:</th><td>${person.id}</td></tr>
        <tr><th>First Name:</th><td><input name="firstName" value="${person.firstName}" /></td></tr>
        <tr><th>Last Name:</th><td><input name="lastName" value="${person.lastName}" /></td></tr>
        <tr><th>Age:</th><td><input name="age" value="${person.age}" /></td></tr>
        <tr><th>Email:</th><td><input name="email" value="${person.email}" /></td></tr>
        <tr><td style="center" colspan="2"><button>Save</button></td></tr>
      </table>
      
    </form>
  </body>
</html>
