
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

           String op = "Hi. I am greater the first, simple reponsive application created by Nceba.How are you doing?";
           request.setAttribute("ResponseText",op);

           if(op!=null) {
               /** The following line can be used to call a .JSP file to provie the view **/
               request.getRequestDispatcher("/index.jsp").forward(request, response);
               System.out.println("Get method done");
           }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            //writing response back from the request
            PrintWriter out = response.getWriter();
            out.println("this is my hello world"+request.getParameter("option"));

            String op = "response action worked...";
            request.setAttribute("ResponseText",op);

            if(op!=null) {
                /** The following line can be used to call a .JSP file to provie the view **/
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                System.out.println("Post Method done");
            }
    }
}
