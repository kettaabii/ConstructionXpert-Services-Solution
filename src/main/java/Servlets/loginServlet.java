package Servlets;

import DAO.UserDao;
import implementation.Connectiondb;
import implementation.UserDaoImpl;
import modals.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");





        try (Connection connection = Connectiondb.getConnection()) {
            UserDao userDAO = new UserDaoImpl();
            User user = userDAO.getUserByUsernameAndPassword(username,password);

            if (user != null) {
                HttpSession session = request.getSession();

                    // Set session attribute to mark user as logged in
                    session.setAttribute("userLoggedIn", true);
                    session.setAttribute("username", user.getUserName());

                    System.out.println(user.getUserName() +"::::::::::::::::::");
                    // Redirect to client dashboard
                    response.sendRedirect(request.getContextPath()+"/AddProject");
                } else {
                    // Invalid privilege
                    response.sendRedirect("login.jsp?error=invalid username or password");
                }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}