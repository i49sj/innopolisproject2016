<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 31.10.2016
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student edit</title>
    <h2><a href="/studentlist">Home</a></h2>
</head>
<body>
<form method = "POST">

    <table class="tg">
        <tr>
            <th width="50">id</th>
            <th width="80">First name</th>
            <th width="80">Last name</th>
            <th width="80">Gender</th>
            <th width="80">Birth date</th>
        </tr>
            <tr>
                <jsp:useBean id="student" class="server.entity.Student" scope="application"/>
                <td><input type="text" name="id" value="${student.id}"/></td>
                <td><input type="text" name="firstName" value="${student.firstName}"/></td>
                <td><input type="text" name="lastName" value="${student.lastName}"/></td>
                <td><input type="text" name="gender" value="${student.gender}"/></td>
                <td><input type="text" name="birthDate" value="${student.birthDate}"/></td>
            </tr>
    </table>
    <input type='submit' value="Save" />

</form>
</body>
</html>
