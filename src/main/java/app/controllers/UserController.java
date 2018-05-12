package app.controllers;

import app.entities.User;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {

    private UserService userServ;

    @Autowired
    public UserController(UserService userServ) {
        this.userServ = userServ;
    }

    @RequestMapping(method = RequestMethod.GET, path = "admin/users")
    public String renderUsers(Model model){
        List<User> users = userServ.getAllUsersServ();
        model.addAttribute("allusers", users);
        return "admin/users";
    }
}
