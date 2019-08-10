package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "Authentication Filter",
           value = {"/", "/home", "/edit-profile", "/delete-account"},
           description = "Filter that checks for user authentication")
public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Authentication filter started...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Authentication filter ongoing...");
    }

    @Override
    public void destroy() {
        System.out.println("Authentication filter terminated...");
    }
}
