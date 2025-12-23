import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User newUser = new User(username, password);
        RegisterService userService = new RegisterDao();
        if (userService.registerUser(newUser)) {
            response.sendRedirect(request.getContextPath() + "/login.html");
        } else {
            response.setContentType("text/plain;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("失败。");
            out.flush();
            out.close();
        }
    }
}