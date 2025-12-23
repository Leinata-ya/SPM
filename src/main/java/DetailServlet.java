import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DetailServlet", value = "/DetailServlet")
public class DetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();
        StringBuilder requestBodyBuilder = new StringBuilder();
        try (BufferedReader reader = request.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                requestBodyBuilder.append(line);
            }
        }
        String requestBody = requestBodyBuilder.toString();
        Map<String, String> jsonData = gson.fromJson(requestBody, Map.class);

        // 从Map中获取partyVolunteerId
        String partyVolunteerId = jsonData.get("partyVolunteerId");

        PartyMember memberDetails = DetailHelper.getMemberDetailsById(partyVolunteerId); // 假设的方法，用于从数据库获取党员详细信息
        System.out.println(memberDetails);
        if (memberDetails != null) {
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.print(new Gson().toJson(memberDetails));
            out.flush();
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().println("党员信息未找到");
        }
    }
}