import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StudyServlet", value = "/StudyServlet")
public class StudyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String PartyVolunteerId = request.getParameter("PartyVolunteerId");
        String records = request.getParameter("records");

        Study newStudy = new Study(PartyVolunteerId, records);


        StudyService registerStudy = new StudyDao();
        if (registerStudy.registerStudy(newStudy)) {
            response.sendRedirect(request.getContextPath() + "/main.html");
        } else {
            response.setContentType("text/plain;charset=UTF-8");
            // 输出失败信息
            PrintWriter out = response.getWriter();
            out.println("失败。");
            out.flush();
            out.close();
        }
    }
}