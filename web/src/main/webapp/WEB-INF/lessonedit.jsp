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
            <jsp:useBean id="lessonEntity" class="ru.innopolis.studentproject.common.entity.LessonEntity" scope="application"/>
            <td><input type="text" name="id" value="${lessonEntity.id}"/></td>
            <td><input type="text" name="topic" value="${lessonEntity.topic}"/></td>
            <td><input type="text" name="description" value="${lessonEntity.description}"/></td>
            <td><input type="text" name="duration" value="${lessonEntity.duration}"/></td>
            <td><input type="text" name="lessondate" value="${lessonEntity.lessondate}"/></td>
        </tr>
    </table>
    <input type='submit' value="Save" />

</form>
</body>
</html>
