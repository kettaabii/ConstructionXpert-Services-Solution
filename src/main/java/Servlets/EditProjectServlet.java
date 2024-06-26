package Servlets;

import DAO.ProjectDao;
import implementation.ProjectDaoImpl;
import modals.Project;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet("/Editproject")
public class EditProjectServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProjectDao projectDao = new ProjectDaoImpl();
        int projectId = Integer.parseInt(request.getParameter("projectId"));
        System.out.println("do get projectId: " + projectId);
        try {
            request.setAttribute("project",projectDao.getProject(projectId));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        request.getRequestDispatcher("/WEB-INF/views/editproject.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProjectDao projectDao = new ProjectDaoImpl();

        int projectId = Integer.valueOf(request.getParameter("idProject"));
        System.out.println("do post projectId: " + projectId);
        String projectName=request.getParameter("projectName");
        Date startDate=Date.valueOf(request.getParameter("startDate"));
        Date endDate=Date.valueOf(request.getParameter("endDate"));
        String description=request.getParameter("description");
        Double budget=Double.valueOf(request.getParameter("budget"));
        Project project = new Project(projectId,projectName,description,budget,startDate,endDate);
        try {
            projectDao.updateProject(project);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String destinationURL = "http://localhost:8080/ConstructionXpertServices_war_exploded/projectDetails?projectId=" + projectId;
        response.sendRedirect(destinationURL);
        }

    }

