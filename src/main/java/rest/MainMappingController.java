package rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tolgacaner on 10/04/16.
 */
@Controller
@RequestMapping("/")
public class MainMappingController {

    @RequestMapping("UserManagement")
    public String mainPage() {
        return "UserManagement";
    }

    @RequestMapping("FoodCoopApp")
    public String welcomePage() {
        return "Welcome";
    }

    @RequestMapping(value="/home")
    public String getSubpageHome() {
        return "sub/home";
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

    @RequestMapping(value="/phones")
    public String getPhonesTemplate() {
        return "template/item_phones";
    }

    @RequestMapping(value="/printers")
    public String getPrintersTemplate() {
        return "template/item_printers";
    }

    @RequestMapping(value="/computerdetails")
    public String getComputerDetailsTemplate() {
        return "template/item_computer_details";
    }

    @RequestMapping(value="/phonedetails")
    public String getPhoneDetailsTemplate() {
        return "template/item_phone_details";
    }

    @RequestMapping(value="/printerdetails")
    public String getPrinterDetailsTemplate() {
        return "template/item_printer_details";
    }

}
