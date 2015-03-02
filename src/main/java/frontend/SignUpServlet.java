package frontend;

import main.AccountService;
import main.UserProfile;
import templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by v.chibrikov on 13.09.2014.
 */
public class SignUpServlet extends HttpServlet {
    private AccountService accountService;

    public SignUpServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        Map<String, Object> pageVariables = new HashMap<>();
        if(accountService.getSessions(request.getSession().getId()) != null ) {
            response.sendRedirect("/profile");
        } else {
            pageVariables.put("signUpStatus", "Let's try sign up!");
            response.getWriter().println(PageGenerator.getPage("signup.html", pageVariables));
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        response.setStatus(HttpServletResponse.SC_OK);

        Map<String, Object> pageVariables = new HashMap<>();
        if (accountService.addUser(name, new UserProfile(name, password, email))) {
            response.sendRedirect("/signin");
        } else {
            pageVariables.put("signUpStatus", "User with name: " + name + " already exists");
            response.getWriter().println(PageGenerator.getPage("signup.html", pageVariables));
        }

    }

}
