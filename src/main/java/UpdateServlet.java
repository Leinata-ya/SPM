import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();
        String requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        Map<String, String> jsonData = gson.fromJson(requestBody, Map.class); // 将JSON解析为Map

        // 从Map中获取partyVolunteerId
        String partyVolunteerId = jsonData.get("partyVolunteerId");

        boolean updateSuccess = UpdateHelper.updateApprovalStatus(partyVolunteerId);

        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (updateSuccess) {
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().print("审批状态更新成功");
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().print("审批状态更新失败");
        }
        out.flush();
        out.close();
    }
}