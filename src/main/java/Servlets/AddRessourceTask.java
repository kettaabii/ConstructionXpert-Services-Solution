package Servlets;

import DAO.TaskDao;
import com.fasterxml.jackson.core.type.TypeReference;
import implementation.ProjectDaoImpl;
import implementation.TaskDaoImpl;
import implementation.ResourceDaoImpl;
import modals.Project;
import modals.Resource;


import modals.Task;
import modals.Task.Status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

@WebServlet("/addRessourceTask")
public class AddRessourceTask extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        int taskId = Integer.parseInt(request.getParameter("taskId"));
        Integer id = Integer.valueOf(request.getParameter("projectId"));
        ResourceDaoImpl resourceDao = new ResourceDaoImpl();
        request.setAttribute("taskId", taskId);
        request.setAttribute("projectId", id);
        List<Resource> ressources=null;
        try {
            ressources =resourceDao.getAllResources();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        request.setAttribute("ressourcelist", ressources);
        ressources.forEach(System.out::println);
        response.setContentType("text/html");
        request.getRequestDispatcher("WEB-INF/views/Add-ressource-for-task.jsp").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve selected resource IDs from request parameters
        String[] selectedResourceIds = request.getParameterValues("resources");
        ResourceDaoImpl resourceDao = new ResourceDaoImpl();
        int taskId = Integer.parseInt(request.getParameter("taskId"));
        Integer id = Integer.valueOf(request.getParameter("projectId"));

        System.out.println("eldlkssssssssskskkkkskskskskks");
                if (selectedResourceIds != null && selectedResourceIds.length > 0) {
                    List<Resource> resourcesToAdd = new ArrayList<>();
                    for (String resourceId : selectedResourceIds) {
                        // Convert resource ID to integer if needed
                        int resourceIdint = Integer.parseInt(resourceId);

                        // Retrieve resource details from the database based on the resource ID
                        Resource resource = null; // You need to implement this method
                        try {
                            resource = resourceDao.getResourceById(resourceIdint);
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        if (resource != null) {
                            resourcesToAdd.add(resource);
                        }
                        TaskDao taskDao = new TaskDaoImpl();
                        try {
                            taskDao.addResourcesToTask(taskId,resourcesToAdd);
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    TaskDao taskDao = new TaskDaoImpl();
                    try {
                        System.out.println("maybe heeereeee");
                        System.out.println("hna l id t task "+taskId );
                        taskDao.setTaskStatusEN_COURS(taskId);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                    response.sendRedirect("Showtasksforproject?projectId="+id);
            }

        }

    }
