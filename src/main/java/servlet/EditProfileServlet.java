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
import java.util.ArrayList;

@WebServlet(name = "EditProfileServlet",
        value = "/editProfile",
        description = "Handles the profile editing user.")
public class EditProfileServlet extends HttpServlet {
    private final UserDAO USERDAO = new UserDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");
        try {
            if(USERDAO.put(new User(Integer.parseInt(id), name, email, password, confirmPassword))){
                // User was added
                request.setAttribute("success", "Your profile was updated successfully!");
            } else {
                // User was not added
                ArrayList<String> errors = new ArrayList<>();
                errors.add("Sorry! we could not update your profile for some reason.");
                request.setAttribute("errors", errors);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("views/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("got here");
        response.setContentType("text/html");
        request.setAttribute("editingProfile", true);
        request.getRequestDispatcher("views/index.jsp").forward(request, response);
    }
}
