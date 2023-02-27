
import javax.print.event.PrintJobListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

public class Servlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<h1>Methods from javax.servlet.http.HttpServeletRequest</h1>");

        printWriter.println("<p>request.getAuthType():" + request.getAuthType() + "</p>");
        printWriter.println("request.getContextPath():" + request.getContextPath() + "</p>");
        printWriter.println("request.getMethod():" + request.getMethod() + "</p>");
        printWriter.println("request.getPathInfo():" + request.getPathInfo() + "</p>");
        printWriter.println("request.getPathTranslated():" + request.getPathTranslated() + "</p>");
        printWriter.println("request.getQueryString():" + request.getQueryString() + "</p>");
        printWriter.println("request.getRemoteUser():" + request.getRemoteUser() + "</p>");
        printWriter.println("request.getRequestedSessionId():" + request.getRequestedSessionId() + "</p>");
        printWriter.println("request.getRequestURI():" + request.getRequestURI() + "</p>");
        printWriter.println("request.getRequestURL():" + request.getRequestURL() + "</p>");
        printWriter.println("request.getServletPath():" + request.getServletPath() + "</p>");
        printWriter.println("request.getSession():" + request.getSession() + "</p>");
        printWriter.println("request.getUserPrincipal():" + request.getUserPrincipal() + "</p>");




        //print Cookies
        printWriter.println("<h2>Printing Cookies</h2>");
        Cookie[] cookies = request.getCookies();
        printWriter.println("request.Cookies():");
        for (Cookie cookie : cookies) {
            printWriter.println(cookie);
            printWriter.println("<p>cookie.getComment():" + cookie.getComment() + "</p>");
            printWriter.println("<p>cookie.getDomain():" + cookie.getDomain() + "</p>");
            printWriter.println("<p>cookie.getMaxAge():" + cookie.getMaxAge() + "</p>");
            printWriter.println("<p>cookie.getName():" + cookie.getName() + "</p>");
            printWriter.println("<p>cookie.getPath():" + cookie.getPath() + "</p>");
            printWriter.println("<p>cookie.getSecure():" + cookie.getSecure() + "</p>");
            printWriter.println("<p>cookie.getValue():" + cookie.getValue() + "</p>");
            printWriter.println("<p>cookie.getVersion():" + cookie.getVersion() + "</p>");
        }

        //print Header
        printWriter.println("<h2>Printing headers and values</h2>");
        Enumeration<String> headerNames = request.getHeaderNames();
        printWriter.println("<h3>Printing header names</h3>");
        while (headerNames.hasMoreElements()) {
            printWriter.println("<p>"+ headerNames.nextElement() + "</p>");
        }
        printWriter.println("<h3>Printing header values</h3>");
        headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            printWriter.println("<p>Header "+ headerName + " value is: " + request.getHeader(headerName) +"</p>");
        }

        printWriter.println("<h3>Printing date header values</h3>");
        printWriter.println("<h4>request.getDateHeader()</h4>");
        headerNames = request.getHeaderNames();
        boolean hasDateHeader = false;
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            try {
                long date = request.getDateHeader(headerName);
                printWriter.println("<p>Header "+ headerName + " value is: " + date +"</p>");
                hasDateHeader = true;
            } catch (Exception e) {
                printWriter.println("<p>" + e.toString()+"</p>");
            }
        }
        if (hasDateHeader == false) {
            printWriter.println("<p>No header converted to Date</p>");
        }


        printWriter.println("<h4>request.getHeaders(headerName)</h4>");
        headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            Enumeration<String> headerValues = request.getHeaders(headerName);
            while (headerValues.hasMoreElements()) {
                printWriter.println("<p>Header "+ headerName + " value is: " + headerValues.nextElement() +"</p>");
            }
        }
        printWriter.println("<h4>request.getIntHeader()</h4>");
        headerNames = request.getHeaderNames();
        boolean hasIntHeader = false;
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            try {
                long intHeader = request.getIntHeader(headerName);
                printWriter.println("<p>Header "+ headerName + " value is: " + intHeader +"</p>");
                hasIntHeader = true;
            } catch (Exception e) {
                printWriter.println("<p>" + e.toString()+"</p>");
            }
        }
        if (hasIntHeader == false) {
            printWriter.println("<p>No header converted to int</p>");
        }

        //print Parts
        printWriter.println("<h2>Printing parts and values</h2>");
        try {
            Collection<Part> parts = request.getParts();
            printWriter.println("<p>" + parts+"</p>");
            Iterator<Part> partsIterator = parts.iterator();
            while (partsIterator.hasNext()) {
                printWriter.println("<p>" + partsIterator.next()+"</p>");
            }
        } catch (Exception e) {
            printWriter.println("<p>" + e.toString()+"</p>");
            // TODO: handle exception
        }
        



        printWriter.println("<h1>Methods inherited from javax.servlet.ServletRequest</h1>");
        try {
            printWriter.println("request.getAsyncContext():" + request.getAsyncContext() + "</p>");
        } catch (Exception e) {
            printWriter.println("<p>request.getAsyncContext():" + e.toString()+"</p>");
            // TODO: handle exception
        }
        printWriter.println("request.getCharacterEncoding():" + request.getCharacterEncoding() + "</p>");
        printWriter.println("request.getContentLength():" + request.getContentLength() + "</p>");
        printWriter.println("request.getContentLengthLong():" + request.getContentLengthLong() + "</p>");
        printWriter.println("request.getContentType():" + request.getContentType() + "</p>");
        printWriter.println("request.getContentLength():" + request.getContentLength() + "</p>");
        printWriter.println("request.getDispatcherType():" + request.getDispatcherType() + "</p>");
        printWriter.println("request.getInputStream():" + request.getInputStream() + "</p>");
        printWriter.println("request.getLocalAddr():" + request.getLocalAddr() + "</p>");
        printWriter.println("request.getLocale():" + request.getLocale() + "</p>");
        printWriter.println("request.getLocales():" + request.getLocales() + "</p>");
        printWriter.println("request.getLocalName():" + request.getLocalName() + "</p>");
        printWriter.println("request.getLocalPort():" + request.getLocalPort() + "</p>");
        printWriter.println("request.getProtocol():" + request.getProtocol() + "</p>");
        try {
            printWriter.println("request.getReader():" + request.getReader() + "</p>");
        } catch (Exception e) {
            // TODO: handle exception
            printWriter.println("<p>request.getReader():" + e.toString()+"</p>");

        }
        //Deprecated
        // printWriter.println("request.getRealPath():" + request.getRealPath(request.getServletPath()) + "</p>");
        printWriter.println("request.getRemoteAddr():" + request.getRemoteAddr() + "</p>");
        printWriter.println("request.getRemoteHost():" + request.getRemoteHost() + "</p>");
        printWriter.println("request.getRemotePort():" + request.getRemotePort() + "</p>");
        printWriter.println("request.getRequestDispatcher():" + request.getRequestDispatcher(request.getServletPath()) + "</p>");
        printWriter.println("request.getScheme():" + request.getScheme() + "</p>");
        printWriter.println("request.getServerName():" + request.getServerName() + "</p>");
        printWriter.println("request.getServerPort():" + request.getServerPort() + "</p>");
        printWriter.println("request.getServletContext():" + request.getServletContext() + "</p>");





        //print attribute
        printWriter.println("<h2>Printing attributeNames and values</h2>");
        Enumeration<String> attributeNames = request.getAttributeNames();
        if (attributeNames.hasMoreElements() == false) {
            printWriter.println("<p>No Attributes</p>");

        }
        while(attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            printWriter.println("<p>attribute"+ attributeName + " value is: " + request.getAttribute(attributeName) +"</p>");
        }

        



        //print parameterNames and Values
        printWriter.println("<h2>Printing parameterNames and values</h2>");
        Enumeration<String> parameterNames = request.getParameterNames();
        Map<String, String[]> parameterMap = request.getParameterMap();
        if (parameterNames.hasMoreElements() ==  false) {
            printWriter.println("<p>No Parameter input" + "</p>");
        }
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