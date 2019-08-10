package servlet;

import db.UserDAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet",
        value = "/login",
        description = "Handles the login of a new user.")
public class LoginServlet extends HttpServlet {
    private final UserDAO USERDAO = new UserDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            if(USERDAO.findByEmailPassword(email, password) != null){
                // User was logged in
                User user = USERDAO.findByEmailPassword(email, password);
                request.setAttribute("success", "Welcome " + user.getName() + " !");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        request.setAttribute("loggingIn", true);
        request.getRequestDispatcher("views/index.jsp").forward(request, response);
    }
}
