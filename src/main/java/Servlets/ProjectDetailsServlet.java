package Servlets;

import DAO.EmployeeDao;
import DAO.ProjectDao;
import DAO.TaskDao;
import DAO.UserDao;
import implementation.EmployeeDaoImpl;
import implementation.ProjectDaoImpl;
import implementation.TaskDaoImpl;
import implementation.UserDaoImpl;
import modals.Employee;
import modals.Project;
import modals.Task;
import DTO.ProjectData;
import modals.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/projectDetails")
public class ProjectDetailsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int projectId = Integer.parseInt(request.getParameter("projectId"));

        // Fetch project details from the database
        ProjectDao projectDao = new ProjectDaoImpl();
        Project project = null;
        try {
            project = projectDao.getProject(projectId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Fetch tasks for the project
        TaskDao taskDao = new TaskDaoImpl();
        List<Task> tasks = null;
        try {
            tasks = taskDao.getTaskByProject(projectId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        for (Task task : tasks) {
            Employee employee = null;
            try {
                employee = employeeDao.getEmployeeById(task.getAssignedEmployeeId());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            task.setAssignedEmployee(employee);
        }
        // Calculate number of completed tasks
        int doneTasks = 0;
        for (Task task : tasks) {
            if (task.getStatus() == Task.Status.FAITE) {
                doneTasks++;
            }
        }

        // Create ProjectData object
        ProjectData projectData = new ProjectData(project, tasks, doneTasks, tasks.size());

        // Set ProjectData object as request attribute
        request.setAttribute("projectData", projectData);

        // Forward to JSP for rendering
        request.getRequestDispatcher("WEB-INF/views/project-details.jsp").forward(request, response);
    }
}
