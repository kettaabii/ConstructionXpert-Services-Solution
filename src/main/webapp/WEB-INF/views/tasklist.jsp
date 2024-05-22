<%@ page import="modals.Task" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Tâches</title>
    <!-- Add any CSS or Bootstrap/Tailwind imports here -->
</head>
<body>
<h1>Liste des Tâches</h1>
<div class="container">
<c:forEach var="task" items="${tasklist}">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">${task.title}</h5>
            <p class="card-text">Date de début: ${task.dateDebutTache}</p>
            <p class="card-text">Date de fin: ${task.dateFinTache}</p>
            <p class="card-text">Statut: ${task.statut}</p>
        </div>
        </c:forEach>
    </div>

</div>
</body>
</html>
