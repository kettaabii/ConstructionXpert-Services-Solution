<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 20/05/2024
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add project </title>
</head>
<body>
<form action="T" method="post">
    <label>Project Name :</label><br>
    <input type="text" name="projectName"><br><br>

    <label>Description:</label><br>
    <textarea name="description"></textarea><br><br>

    <label>Budget:</label><br>
    <input type="number" name="budget"><br><br>

    <label> Date</label><br>
    <input type="date" name="dateStart"><br><br>


    <label>Date fin:</label><br>
    <input type="date" name="dateFin"><br><br>





    <input type="submit" value="Add Project ">
</form>

</body>
</html>
