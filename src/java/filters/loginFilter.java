package filters;

import data.userData;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author abdel
 */
public class loginFilter implements Filter {

    public loginFilter() {
    }

    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {

    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        userData use = (userData) req.getSession().getAttribute("cust");
        System.out.println("filter");
        if (use == null) {
            res.sendRedirect("./error.html");
        } else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {
    }

    public void init(FilterConfig filterConfig) {

    }

}
