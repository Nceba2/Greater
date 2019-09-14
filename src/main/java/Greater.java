import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/greater")
public class Greater extends HttpServlet {

    private String input = "";
    private String JsonFile = "src/main/webapp/data.json";
    private HttpRequester httpRequester = new HttpRequester();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            //writing response back from the request
            //this method handles all the get requests

            input = "Hi. I am greater the first, simple reponsive application created by Nceba.How are you doing?";
            request.setAttribute("ResponseText",input);

               /** The following line can be used to call a .JSP file to provide the view **/
               request.getRequestDispatcher("/index.jsp").forward(request, response);
               System.out.println("Get method done");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            //writing response back from the request
            //this method handles all the post requests

            JsonFileReader jsonFileReader = new JsonFileReader();
            input = request.getParameter("responseArea");

        request.setAttribute("ResponseText",
                httpRequester.HttpGet(jsonFileReader.doRead(JsonFile).get("url") + input));

                request.getRequestDispatcher("/index.jsp").forward(request, response);
                System.out.println("Post Method done");
    }
}
