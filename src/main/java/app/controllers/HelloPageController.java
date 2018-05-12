package app.controllers;

import app.services.AnyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HelloPageController {


    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String renderHello() {
        return "redirect:/user/items";
    }


}

