package test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tolgacaner on 10/04/16.
 */
@Controller
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "view";
    }

}
