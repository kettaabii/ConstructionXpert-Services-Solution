package Servlets;

import DAO.ProjectDao;
import implementation.ProjectDaoImpl;
import modals.Project;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteProject")
public class DeleteprojectServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int projectid = Integer.parseInt(request.getParameter("projectId"));

        ProjectDao projectDao=new ProjectDaoImpl();
        try {
            Project project = projectDao.getProject(projectid);
            projectDao.deleteProject(project);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        request.getRequestDispatcher("/WEB-INF/views/UserLogged.jsp").forward(request, response);
    }


}
