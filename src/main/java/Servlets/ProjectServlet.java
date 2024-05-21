package Servlets;

import DAO.ProjectDao;
import implementation.ProjectDaoImpl;
import modals.Project;

import java.io.*;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ProjectServletServlet", value = "/ProjectServlet-servlet")
public class ProjectServlet extends HttpServlet {


    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        response.setContentType("text/html");
        request.getRequestDispatcher("WEB-INF/views/addProject.jsp").forward(request,response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ProjectDao projectDao = new ProjectDaoImpl();
        String projectName = request.getParameter("projectName");
        String description = request.getParameter("description");
        Double budget = Double.parseDouble(request.getParameter("budget"));
        Date dateStart = Date.valueOf(request.getParameter("dateStart"));
        Date dateFin = Date.valueOf(request.getParameter("dateFin"));

        Project project = new Project(0,projectName,description,budget,dateStart,dateFin);
        try {
            projectDao.createProject(project);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void destroy() {
    }
}