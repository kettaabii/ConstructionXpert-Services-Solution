package Servlets;

import DAO.ProjectDao;
import DAO.TaskDao;
import implementation.ProjectDaoImpl;
import DTO.ProjectData;
import implementation.TaskDaoImpl;
import modals.Task;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Dashboard")
public class DashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ProjectDao projectDao = new ProjectDaoImpl();
        TaskDao taskDao = new TaskDaoImpl();

        try {
            List<ProjectData> projectsData = projectDao.getAllProjectsData();
            request.setAttribute("projectsData", projectsData);
            int overallTasks=taskDao.getNumberOfTotalTasksoOverall();
            request.setAttribute("overallTasks", overallTasks);
            int overallProjects=projectDao.getNumberOfTotalProjectOverall();
            request.setAttribute("overallProjects", overallProjects);
            for (ProjectData projectData : projectsData) {
                int projectId = projectData.getProject().getId();
                int doneTasks = taskDao.getNumberOfTasksByStatus("FAITE", projectId);
                int totalTasks = taskDao.getNumberOfTotalTasks(projectId);

                request.setAttribute("doneTasks", doneTasks);
                request.setAttribute("totalTasks", totalTasks);

            }
            request.setAttribute("session", session);
            request.getRequestDispatcher("/WEB-INF/views/UserLogged.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}