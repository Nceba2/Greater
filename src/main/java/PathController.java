import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;


@Controller
public class PathController {

    @GetMapping("/")
    public String index(Map<String, Object> Model){
        return "Second response";

    }


}
