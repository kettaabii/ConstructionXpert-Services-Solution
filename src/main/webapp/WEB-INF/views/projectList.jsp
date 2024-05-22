
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 21/05/2024
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<table style="width: 107%; background: rgba(12,14,18,0.78)" class="table table-striped rounded">
    <thead style="padding: 10px">
    <tr>

        <th>Projectname</th>
        <th>FilmTitle</th>
        <th>ReservationDate</th>
        <th>Price</th>
        <th>Seat</th>


    </tr>
    </thead>
    <tbody style="padding: 10px">
    <c:forEach var="projectDao" items="${projectslist}">
        <tr>

            <td>${projectDao.projectName}</td>
            <td>${projectDao.description}</td>
            <td>${projectDao.budget}</td>
            <td>${projectDao.dateDebut}</td>
            <td>${projectDao.dateFin}</td>


        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
