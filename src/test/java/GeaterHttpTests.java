import org.junit.Test;
import javax.servlet.annotation.WebServlet;
import static org.junit.Assert.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@WebServlet(urlPatterns = "/greater")
public class GeaterHttpTests {
    /**
     *
     * on this test class i can only test for the response
     * only when the application is hosted on tomcat.
     * making it impossible to test the void method.
     *
     **/

    @Test
    public void testDoGetResponseCode() throws IOException {
        URL url = new URL("http://localhost:8080/greater/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        assertEquals(200,con.getResponseCode());
    }
    @Test
    public void testDoGetResponseCodeURL_NoExtendedParameters() throws IOException {
        URL url = new URL("http://localhost:8080/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        assertNotEquals(200,con.getResponseCode());
    }
    @Test
    public void testDoPostResponseAttributeTest() throws IOException {
        URL url = new URL("http://localhost:8080/greater/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");

        assertEquals(200,con.getResponseCode());
    }

    @Test
    public void HttpRequesterTest() throws IOException {
        HttpRequester Hreq = new HttpRequester();
        String URL = "http://ncebasobikwa.co.za/APIs/luluAPI.php?request=hello";
        //the get uses "request=hello" the value comes from input on the view

        assertEquals("Hello There",Hreq.HttpGet(URL));
    }
    @Test
    public void HttpRequesterTestNull() throws IOException {
        HttpRequester Hreq = new HttpRequester();
        String URL = "http://ncebasobikwa.co.za/APIs/luluAPI.php?request=";

        assertNotEquals("Hello There",Hreq.HttpGet(URL));
    }
}
