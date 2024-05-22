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
<form action="addTask" method="post">
    <label>Project Name :</label><br>
    <input type="text" name="taskName"><br><br>

    <label>Description:</label><br>
    <textarea name="description"></textarea><br><br>

    <label>description:</label><br>
    <input type="text" name="description"><br><br>

    <label> Date debut :</label><br>
    <input type="date" name="dateStart"><br><br>


    <label>Date fin:</label><br>
    <input type="date" name="dateFin"><br><br>

    <label>Status :</label><br>
    <input type="text" name="status"><br><br>
    <label>Id project :</label><br>
    <input type="number" name="projectId"><br>


    <input type="submit" value="Add Project ">
</form>

</body>
</html>
