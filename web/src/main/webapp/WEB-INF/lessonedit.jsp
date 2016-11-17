<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lesson edit</title>
    <h2><a href="/lesssonlist">Home</a></h2>
</head>
<body>
<form method = "POST">

    <table class="tg">
        <tr>
            <th width="50">id</th>
            <th width="80">Topic</th>
            <th width="80">Description</th>
            <th width="80">Duration</th>
            <th width="80">Date</th>
        </tr>
        <tr>
            <jsp:useBean id="lesson" class="Lesson" scope="application"/>
            <td><input type="text" name="id" value="${lesson.id}"/></td>
            <td><input type="text" name="topic" value="${lesson.topic}"/></td>
            <td><input type="text" name="description" value="${lesson.description}"/></td>
            <td><input type="text" name="duration" value="${lesson.duration}"/></td>
            <td><input type="text" name="lessondate" value="${lesson.lessondate}"/></td>
        </tr>
    </table>
    <input type='submit' value="Save" />

</form>
</body>
</html>
