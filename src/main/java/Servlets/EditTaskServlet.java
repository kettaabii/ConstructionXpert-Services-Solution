package Servlets;

import DAO.ProjectDao;
import DAO.TaskDao;
import implementation.ProjectDaoImpl;
import implementation.TaskDaoImpl;
import modals.Project;
import modals.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet("/EditTask")
public class EditTaskServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TaskDao taskDao = new TaskDaoImpl();
        int taskId = Integer.parseInt(request.getParameter("taskId"));

        System.out.println("do get projectId: " + taskId);
        try {
            request.setAttribute("task",taskDao.getTaskById(taskId));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        request.getRequestDispatcher("/WEB-INF/views/editTask.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TaskDao taskDao = new TaskDaoImpl();
        int projectId = Integer.parseInt(request.getParameter("projectId"));

        int taskId = Integer.valueOf(request.getParameter("taskId"));
        int assignedEmployeeId =Integer.valueOf(request.getParameter("assignedEmployeeId"));
        String taskName=request.getParameter("tasktitle");
        Date startDate=Date.valueOf(request.getParameter("dateDebutTache"));
        Date endDate=Date.valueOf(request.getParameter("endDate"));
        String description=request.getParameter("description");
        Task.Status status = Task.Status.valueOf(request.getParameter("status"));
        Task task = new Task(taskId,taskName,description,startDate,endDate,status,assignedEmployeeId);
        try {
            taskDao.updateTask(task);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String destinationURL = "http://localhost:8080/ConstructionXpertServices_war_exploded/projectDetails?projectId=" + projectId;
        response.sendRedirect(destinationURL);
        }

    }

