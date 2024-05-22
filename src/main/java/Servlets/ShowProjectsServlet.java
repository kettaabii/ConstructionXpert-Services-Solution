package Servlets;

import DAO.ProjectDao;
import implementation.ProjectDaoImpl;
import modals.Project;

import java.io.*;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet ("/ShowProjects")
public class ShowProjectsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ProjectDao projectDao = new ProjectDaoImpl();

        try{
            request.setAttribute("projectslist", projectDao.getProjects());
            System.out.println("dfmlf,vff,vf"+projectDao.getProjects());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("/WEB-INF/views/projectList.jsp").forward(request, response);
    }


}
