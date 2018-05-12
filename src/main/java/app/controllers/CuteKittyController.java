package app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CuteKittyController {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CuteKittyController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/kotik")
    public String renderKitty(Model model){
        model.addAttribute("your","t'omik");
        model.addAttribute("cute","for");
        model.addAttribute("kitten","kotenok");
        return "kotik";
    }


}



