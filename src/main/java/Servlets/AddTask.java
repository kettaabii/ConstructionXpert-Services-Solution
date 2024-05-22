package Servlets;
import DAO.TaskDao;
import implementation.TaskDaoImpl;
import modals.Task;

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

@WebServlet("/addTask")
public class AddTask extends HttpServlet {


    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        response.setContentType("text/html");
        request.getRequestDispatcher("WEB-INF/views/addTask.jsp").forward(request,response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        TaskDao taskDao = new TaskDaoImpl();
        String title = request.getParameter("taskName");
        String description = request.getParameter("description");
        Date dateDebutTache = Date.valueOf(request.getParameter("dateStart"));
        Date dateFinTache = Date.valueOf(request.getParameter("dateFin"));
        String status = request.getParameter("status");
        Integer projectId = Integer.parseInt(request.getParameter("projectId"));

        Task task = new Task(0,title,description,dateDebutTache,dateFinTache,status,projectId);
        try {
            taskDao.addTask(task);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void destroy() {
    }
}