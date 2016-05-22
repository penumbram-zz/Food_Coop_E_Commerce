package rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tolgacaner on 10/04/16.
 */
@Controller
@RequestMapping("/")
public class MainMappingController {

    @RequestMapping("FoodCoopApp")
    public String welcomePage() {
        return "Welcome";
    }

    @RequestMapping(value="/home")
    public String getSubpageHome() {
        return "sub/home";
    }

    @RequestMapping("/userManagement")
    public String getSubpageUserManagement() {
        return "sub/user_management";
    }

    @RequestMapping("/productManagement")
    public String getSubpageProductManagement() {
        return "sub/product_management";
    }

    @RequestMapping(value="/popupTmpl")
    public String getSubpagePopupTmpl() {
        return "sub/popupTmpl";
    }

    @RequestMapping(value="/login")
    public String getSubpageLogin() {
        return "sub/login";
    }

    @RequestMapping(value="/products")
    public String getSubpageProducts() {
        return "sub/products";
    }

    @RequestMapping(value="/news")
    public String getSubpageCoop() {
        return "sub/news";
    }

    @RequestMapping(value="/contact")
    public String getSubpageContact() {
        return "sub/contact";
    }

    @RequestMapping(value="/unauthorized")
    public String getUnauthorized() {
        return "sub/unauthorized";
    }

}
