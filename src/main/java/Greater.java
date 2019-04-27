
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/greater")
public class Greater extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            //writing response back from the request
            PrintWriter out = response.getWriter();
            out.println("this is my hello world"+request.getParameter("option"));

           String op = request.getParameter("option");

           if(op!=null) {
               /** The following line can be used to call a .JSP file to provie the view **/
               request.getRequestDispatcher("/index.jsp").forward(request, response);
               System.out.print("Hola!");
           }
    }
}
