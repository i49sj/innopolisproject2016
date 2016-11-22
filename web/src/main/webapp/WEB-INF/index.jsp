<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<section>
  <a href="lessonlist">Lesson list</a>
  <hr>
  <table border="1" cellpadding="8" cellspacing="0">
    <thead>
    <tr>
      <th>First name</th>
      <th>Last name</th>
      <th>Gender</th>
      <th>Birth date</th>
      <th></th>
      <th></th>
    </tr>
    </thead>
    <c:forEach items="${list}" var="studentEntity">
      <jsp:useBean id="studentEntity" scope="page" type="ru.innopolis.studentproject.common.entity.StudentEntity"/>
      <tr>
        <td>${studentEntity.firstName}</td>
        <td>${studentEntity.lastName}</td>
        <td>${studentEntity.gender}</td>
        <td>${studentEntity.birthDate}</td>
        <td><a href="studentedit/${studentEntity.id}">Update</a></td>
        <td><a href="studentedit/del/${studentEntity.id}">Delete</a></td>
      </tr>
    </c:forEach>
  </table>
  <a href="studentedit/add/">Add Student</a>
</section>
  <body>

  </body>
</html>
