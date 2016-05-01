package rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tolgacaner on 10/04/16.
 */
@Controller
@RequestMapping("/")
public class TestController {

    @RequestMapping("UserManagement")
    public String mainPage() {
        return "UserManagement";
    }

    @RequestMapping("FoodCoopApp")
    public String welcomePage() {
        return "Welcome";
    }

}
