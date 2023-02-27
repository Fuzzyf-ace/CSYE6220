
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

public class Servlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        Enumeration<String> parameterNames = request.getParameterNames();
        Map<String, String[]> parameterMap = request.getParameterMap();

        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            printWriter.println("<p>" + parameterName + ": ");
            String[] parameterValues = parameterMap.get(parameterName); //request.getParameterValues(parameterName);
            for (String value : parameterValues) {
                printWriter.println(value);
            }
            printWriter.println("\n</p>");
        } 
        
    }
}