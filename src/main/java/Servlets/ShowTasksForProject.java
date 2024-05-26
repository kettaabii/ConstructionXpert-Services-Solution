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
        List<Task> tasksbystatusA_faire = null;
        List<Task> tasksbystatusEN_COURS = null;
        List<Task> tasksbystatusFAITE = null;
        try {
            taches = tacheDAO.getTaskByProject(idProjet);
            tasksbystatusA_faire=tacheDAO.getTasksByStatus("A_FAIRE",idProjet);
            tasksbystatusEN_COURS=tacheDAO.getTasksByStatus("EN_COURS",idProjet);
            tasksbystatusFAITE=tacheDAO.getTasksByStatus("FAITE",idProjet);
            System.out.println("tasksbystatusA_faire "+tasksbystatusA_faire);
            tasksbystatusA_faire.forEach( System.out::println);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("tasksbystatusEN_COURS", tasksbystatusEN_COURS);
        request.setAttribute("tasksbystatusFAITE", tasksbystatusFAITE);
        request.setAttribute("tasklist", taches);
        request.setAttribute("tasksbystatusA_faire", tasksbystatusA_faire);

        request.getRequestDispatcher("/WEB-INF/views/Addressource&affect.jsp").forward(request, response);
    }
}
