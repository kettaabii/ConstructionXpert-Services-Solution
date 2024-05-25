package Servlets;

import DAO.TaskDao;
import implementation.TaskDaoImpl;
import modals.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/Showtasksforproject")
public class ShowTasksForProject extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TaskDao tacheDAO = new TaskDaoImpl();
        int idProjet = Integer.parseInt(request.getParameter("projectId"));
        System.out.println("this is id project "+idProjet);
        List<Task> taches = null;
        try {
            taches = tacheDAO.getTaskByProject(idProjet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("tasklist", taches);
        request.getRequestDispatcher("/WEB-INF/views/Addressource&affect.jsp").forward(request, response);
    }
}
