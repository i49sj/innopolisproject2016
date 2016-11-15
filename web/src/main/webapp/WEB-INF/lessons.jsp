<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<section>
    <a href="studentlist">Lesson list</a>
    <hr>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>id</th>
            <th>Topic</th>
            <th>Description</th>
            <th>Duration</th>
            <th>Date</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${list}" var="lesson">
            <jsp:useBean id="lesson" scope="page" type="server.entity.Lesson"/>
            <tr>
                <td>${lesson.id}</td>
                <td>${lesson.topic}</td>
                <td>${lesson.description}</td>
                <td>${lesson.duration}</td>
                <td>${lesson.lessondate}</td>
                <td><a href="lessonedit/${lesson.id}">Update</a></td>
                <td><a href="lessonedit/del/${lesson.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="lessonedit/add/">Add Lesson</a>
</section>
<body>

</body>
</html>
