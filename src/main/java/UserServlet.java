import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {

    private final UserService userService = new UserService(); // 实例化UserService

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession(false); // 不创建新的session，仅获取已存在的session
        if (session != null) {
            User currentUser = (User) session.getAttribute("currentUser");
            if (currentUser != null) {
                String username = currentUser.getUsername();
                response.getWriter().write(username); // 直接写入用户名到响应体
            } else {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "用户未登录");
            }
        } else {
            response.sendError(HttpServletResponse.SC_NO_CONTENT, "没有可用的session");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username+password);
        // 通过UserService实例调用login方法尝试登录
        Optional<User> optionalUser = userService.login(username, password);

        if (optionalUser.isPresent()) {
            // 登录成功，将用户信息存入session
            User loginUser = optionalUser.get();
            HttpSession session = request.getSession();
            session.setAttribute("currentUser", loginUser);
            response.setContentType("application/json"); // 设置内容类型为json
            response.setCharacterEncoding("UTF-8"); // 设置编码
            String s = new Gson().toJson(loginUser);
            response.getWriter().write(s);
//            response.sendRedirect(request.getContextPath() + "/main.html");
        } else {
            // 登录失败，设置错误消息并在request作用域中保留，然后转发回登录页面
//            request.setAttribute("errorMessage", "用户名或密码错误");
//            request.getRequestDispatcher("login.html").forward(request, response); // 确保与实际登录页面的路径一致

            response.setContentType("application/json"); // 设置内容类型为json
            response.setCharacterEncoding("UTF-8"); // 设置编码
            User user = new User();
            user.setUsername("0");
            String s = new Gson().toJson(user);
            response.getWriter().write(s);
        }
    }
}