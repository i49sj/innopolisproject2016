<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<section>
<form action="/j_spring_security_check" name="login" method="post">
    <p>Введите логин: <input type="text" required name = "username"> </p>
    <p>Введите пароль: <input type="password" required name = "password"> </p>
    <input type="submit" value="Send"/>
</form>
</section>
<body>

</body>
</html>