package Servlets;

import DAO.ProjectDao;
import implementation.ProjectDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Editproject")
public class EditProjectServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        ProjectDao project =new ProjectDaoImpl();
        request.getRequestDispatcher("/WEB-INF/views/editproject.jsp").forward(request, response);
    }
}
