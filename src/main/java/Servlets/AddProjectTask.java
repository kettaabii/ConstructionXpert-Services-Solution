package Servlets;

import DAO.TaskDao;
import com.fasterxml.jackson.core.type.TypeReference;
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
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.Map;

@WebServlet("/addPojectTask")
public class AddProjectTask extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        response.setContentType("text/html");
        request.getRequestDispatcher("WEB-INF/views/addnewproject.jsp").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> requestData = objectMapper.readValue(request.getInputStream(), new TypeReference<Map<String,Object>>() {});

        // Extract project data
        String projectName = (String) requestData.get("projectName");
        String startDate = (String) requestData.get("startDate");
        String endDate = (String) requestData.get("endDate");
        String description = (String) requestData.get("description");
        String budget = (String) requestData.get("budget");

        // Extract task data
        String[] taskTitles = request.getParameterValues("taskTitle");
        String[] taskDescriptions = request.getParameterValues("taskDescription");
        String[] taskStartDates = request.getParameterValues("taskStartDate");
        String[] taskEndDates = request.getParameterValues("taskEndDate");

        // Process the extracted data to create projects and tasks
        ProjectDaoImpl projectDao = new ProjectDaoImpl();
        TaskDaoImpl taskDao = new TaskDaoImpl();

        try {
            // Create and insert project
            Project project = new Project();
            project.setProjectName(projectName);
            project.setDescription(description);
            project.setDateDebut(Date.valueOf(startDate));
            project.setDateFin(Date.valueOf(endDate));
            project.setBudget(Double.valueOf(budget));
            Project createdProject = projectDao.createProject(project);

            // Create and insert tasks
            if (taskTitles.length > 0) {
                for (int i = 0; i < taskTitles.length; i++) {
                    Task task = new Task();
                    task.setTitle(taskTitles[i]);
                    task.setDescription(taskDescriptions[i]);
                    task.setDateDebutTache(Date.valueOf(taskStartDates[i]));
                    task.setDateFinTache(Date.valueOf(taskEndDates[i]));
                    task.setStatus(Status.A_FAIRE);;
                    taskDao.addTask(task);
                    System.out.println(task);
                }
            }

            // Redirect to success page
            response.sendRedirect("success.jsp");
        } catch (SQLException e) {
            // Handle any potential database errors
            e.printStackTrace();
            // Redirect to error page
            response.sendRedirect("error.jsp");
        }
}}

