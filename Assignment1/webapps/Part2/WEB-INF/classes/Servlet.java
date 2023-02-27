
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class Servlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        Enumeration<String> headerNames = request.getHeaderNames();
        printWriter.println("<ol>");
        while (headerNames.hasMoreElements()) {
	    String headerName = headerNames.nextElement();
            printWriter.println("<li>Request Header Names: " + headerName);
	    Enumeration<String> headers = request.getHeaders(headerName);
	    while (headers.hasMoreElements()) {
		String header = headers.nextElement();
		printWriter.println("&nbsp&nbsp&nbsp&nbspRequest Header: " + header);
        printWriter.println("</li>");
 	        }
        }
        printWriter.println("</ol>");
    }
}