package Servlets;

import DAO.TaskDao;
import implementation.ProjectDaoImpl;
import implementation.TaskDaoImpl;
import modals.Project;
import modals.Task;
import modals.Task.Status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet("/addPojectTask")
public class Addprojecttask extends HttpServlet {


    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        response.setContentType("text/html");
        request.getRequestDispatcher("WEB-INF/views/addnewproject.jsp").forward(request,response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


            // Retrieve project data
            String projectName = request.getParameter("projectName");
            String description = request.getParameter("description");
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");
            double budget = Double.parseDouble(request.getParameter("budget"));

            // Retrieve task data
            String taskTitle = request.getParameter("TaskTitle");
            String taskDescription = request.getParameter("Taskdescription");
            String taskStartDate = request.getParameter("TaskstartDate");
            String taskEndDate = request.getParameter("TaskendDate");
        ProjectDaoImpl projectDao = new ProjectDaoImpl();
        TaskDaoImpl taskDao = new TaskDaoImpl();
        try {
            // Create and insert project
            Project project = new Project();
            project.setProjectName(projectName);
            project.setDescription(description);
            project.setDateDebut(Date.valueOf(startDate));
            project.setDateFin(Date.valueOf(endDate));
            project.setBudget(budget);
            projectDao.createProject(project);

            // Create and insert task
            Task task = new Task();
            task.setTitle(taskTitle);
            task.setDescription(taskDescription);
            task.setDateDebutTache(Date.valueOf(taskStartDate));
            task.setDateFinTache(Date.valueOf(taskEndDate));
            task.setStatus(Status.A_FAIRE);
            task.setProjectId(project.getId()); // Set the project ID for the task
            taskDao.associateTaskWithProject(task.getIdTask(), project.getId());
            taskDao.addTask(task);

            // Optionally, you can redirect the user to another page or display a confirmation message
        } catch (SQLException e) {
            // Handle any potential database errors
            e.printStackTrace();
            // You can redirect the user to an error page or display an error message
        }





    }
    public void destroy() {
    }
}