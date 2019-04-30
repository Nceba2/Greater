import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonFileReader {
    private String file = "src/main/webapp/data.json";

    public JSONObject doRead(String s) throws IOException {

        try {
            FileReader reader = new FileReader(s);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

            return jsonObject;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
