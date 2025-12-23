import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddServlet", value = "/AddServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String partyVolunteerId = request.getParameter("partyVolunteerId");
        String partyName = request.getParameter("partyName");
        String gender = request.getParameter("gender");
        String aStatus = request.getParameter("aStatus");

        PartyMember member = new PartyMember(partyVolunteerId, partyName, gender,  aStatus);


        AddDao addDao = new AddDao();


        if (addDao.addPartyMember(member)) {
            response.sendRedirect(request.getContextPath() + "/main.html");
        } else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<h1>录入失败！</h1>");
            out.flush();
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 如果您计划支持POST方法，这里应实现与GET类似的数据处理逻辑
        doGet(request, response); // 示例中直接转发到doGet处理，实际开发中可能需要单独处理POST逻辑
    }
}