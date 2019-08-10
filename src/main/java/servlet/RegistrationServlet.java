package servlet;

import db.UserDAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "RegistrationServlet",
            value = "/register",
            description = "Handles the registration of a new user.")
public class RegistrationServlet extends HttpServlet {
    private final UserDAO USERDAO = new UserDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");
        try {
            if(USERDAO.post(new User(name, email, password, confirmPassword))){
                // User was added
                User user = USERDAO.findByEmailPassword(email, password);
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                request.setAttribute("success", "Your registration was successful. Use the TheReviewer as you wish!");
            } else {
                // User was not added
                ArrayList<String> errors = new ArrayList<>();
                errors.add("Sorry! we could not register you for some reason.");
                request.setAttribute("errors", errors);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("views/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setAttribute("registering", true);
        request.getRequestDispatcher("views/index.jsp").forward(request, response);
    }
}
