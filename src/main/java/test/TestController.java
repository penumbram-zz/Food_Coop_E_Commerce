package test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by tolgacaner on 10/04/16.
 */
@Controller
@RequestMapping("/")
public class TestController {

    @RequestMapping("MainPage")
    public String mainPage() {
        return "UserManagement";
    }

}
