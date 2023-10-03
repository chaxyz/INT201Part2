<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: INT202&204
  Date: 9/26/2023
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${courseRegistered.history}" var="entry">
    <h3>Semeter ${entry.key}</h3>
    <hr>
    <c:forEach items="${entry.value}" var="subject">
        ${subject.subjectId}, ${subject.title}, ${subject.credit}<br>
    </c:forEach> ----------------------------<br><br>
</c:forEach>


</body>
</html>
