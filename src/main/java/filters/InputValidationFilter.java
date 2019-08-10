package filters;

import utils.Validator;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;

@WebFilter(filterName = "InputValidationFilter",
            value = {"/register", "/login", "/edit-profile"},
            description = "Filter to validate input.")
public class InputValidationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Input validation filter started...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Input validation filter ongoing...");
        if(((HttpServletRequest) request).getMethod().equals("GET")){filterChain.doFilter(request, response);}
        ArrayList<String> errors = new ArrayList<>();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");

        if(!Validator.validateMaxLength(name, 255)){
            errors.add(Validator.getMaxLengthError("name"));
        }

        if(!Validator.validateEmail(email)){
            errors.add(Validator.getInvalidEmailError());
        }

        if(!Validator.validateMinLength(password, 8)){
            errors.add(Validator.getMinLengthError(password));
        }

        if(!Validator.validateStrongPassword(password)){
            errors.add(Validator.getWeakPasswordError());
        }

        if(!Validator.validateConfirmationPassword(password, confirmPassword)){
            errors.add(Validator.confirmPasswordsError());
        }

        if(errors.size() == 0){
            filterChain.doFilter(request, response);
        } else {
            System.out.println("error");
            for (String error: errors) {
                System.out.println("\n" + error);
            }
            response.setContentType("text/html");
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("views/index.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {
        System.out.println("Input validation filter terminated...");
    }
}
