import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import javax.servlet.annotation.WebServlet;
import static org.junit.Assert.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
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

    private URL url;
    private String API_URL, file;
    private JsonFileReader jsonFileReader;
    private HttpRequester Hreq;
    private HttpURLConnection con;

    @Before
    public void initialValues() throws MalformedURLException {
        url = new URL("http://localhost:8080/greater/");
        API_URL = "http://ncebasobikwa.co.za/APIs/luluAPI.php?request=";
        file = "src/main/webapp/data.json";
    }

    @Test
    public void testDoGetResponseCode() throws IOException {
        con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        assertEquals(200,con.getResponseCode());
    }
    @Test
    public void testDoGetResponseCodeURL_NoExtendedParameters() throws IOException {
        URL url = new URL("http://localhost:8080/");
        con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        assertNotEquals(200,con.getResponseCode());
    }
    @Test
    public void testDoPostResponseAttributeTest() throws IOException {
        con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");

        assertEquals(200,con.getResponseCode());
    }

    @Test
    public void HttpRequesterTest() throws IOException {
        Hreq = new HttpRequester();
        API_URL = API_URL+"hello";
        //the get uses "request=hello" the value comes from input on the view

        assertEquals("Hello There",Hreq.HttpGet(API_URL));
    }
    @Test
    public void HttpRequesterTestNull() throws IOException {
        HttpRequester Hreq = new HttpRequester();

        assertNotEquals("Hello There",Hreq.HttpGet(API_URL));
    }

    /**
     * The following tests are for testing the class to read a Json file
     * Made the class to be able to read any .Json file
     * **/
    @Test
    public void JsonFileReaderTest() throws IOException {
         jsonFileReader = new JsonFileReader();

        assertEquals("ok",jsonFileReader.doRead(file).get("test"));
    }
    @Test
    public void JsonFileReaderTestDifferentValue() throws IOException, ParseException {
         jsonFileReader = new JsonFileReader();

        assertNotEquals("ok",jsonFileReader.doRead(file).get("url"));
    }
    @Test
    public void JsonFileReaderTestNull() throws IOException {
         jsonFileReader = new JsonFileReader();

        assertNotEquals("ok",jsonFileReader.doRead(file).get(null));
    }
    @Test
    public void JsonFileReaderTestNullIsEqualsNull() throws IOException {
        jsonFileReader = new JsonFileReader();

        assertEquals(null,jsonFileReader.doRead(file).get(null));
    }
}
