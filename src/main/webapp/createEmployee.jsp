<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 26.02.2017
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form method="post" name="login" action="employee/create">
  <input type="text" class="big_text" name="unitName" value="" placeholder="unitName"><br>
  <input type="text" class="big_text" name="fio" value="" placeholder="fio"><br>
  <input type="text" class="big_text" name="position" value="" placeholder="position"><br>
  <input type="text" class="big_text" name="email" value="" placeholder="email"><br>
  <input type="text" class="big_text" name="tel" value="" placeholder="tel"><br>
  <input type="text" class="big_text" name="tel2" value="" placeholder="tel2"><br>
  <input type="text" class="big_text" name="room" value="" placeholder="room"><br>
  <button class="index_login_button flat_button button_big_text">create</button>
</form>
</body>
</html>
