<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Access Denied - ProgrammingFree</title>
</head>
<body>
<h1>You do not have permission to access this page!
</h1>
<form action="/logout" method="post">
              <input type="submit" value="Sign in as different user" />
              <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>  
</body>
</html>
