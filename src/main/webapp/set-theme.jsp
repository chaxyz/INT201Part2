<%--
  Created by IntelliJ IDEA.
  User: INT202&204
  Date: 10/3/2023
  Time: 2:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Select your theme</title>
</head>
<body style="background-color: ${bg_color}">
    <div style="margin-left: 150px">
        <h3>Select Your Theme</h3><hr>
        <form action="set-theme" method="post">
            <input type="radio" name="bg" value="silver"><label style="background-color: silver">&nbsp; &nbsp;</label>Silver
            <br>
            <input type="radio" name="bg" value="gray"><label style="background-color: gray">&nbsp; &nbsp;</label>Gray
            <br>
            <input type="radio" name="bg" value="lightgoldenrodyellow"><label style="background-color: lightgoldenrodyellow">&nbsp; &nbsp;</label>Yellow
            <br>
            <input type="radio" name="bg" value="aliceblue"><label style="background-color: aliceblue">&nbsp; &nbsp;</label>Alice blue
            <br>
            <hr>
            <input type="submit" value="OK">
        </form>

    </div>
</body>
</html>
