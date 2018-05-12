package app.controllers;

import app.entities.User;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {


    private UserService userServ;

    @Autowired
    public RegistrationController(UserService userServ) {
        this.userServ = userServ;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/registration")
    public String renderReg(Model model) {
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/registration")
    public String renderLoginReg(@ModelAttribute User user, Model model)
    {
        String log = user.getLogin();
        String pass = user.getPassword();
        String name = user.getFIO();
        String role = user.getRole();
        if (pass.length() < 6) {
            model.addAttribute("errorPass", "Пароль должен быть хотя бы 6 символов!");
            return "registration";
        } else if (name.length() == 0) {
            model.addAttribute("errorName", "Поле не должно быть пустым!");
            return "registration";
        } else if (userServ.getUserByLogin(log) != null) {
            model.addAttribute("errorLog", "Такой логин уже существует! Придумайте другой");
            return "registration";
        } else {
            userServ.addUser(log,pass,name,role);
            model.addAttribute("successAdd","Вы успешно зарегистрированы. Теперь можете войти в систему.");
            return "login";
        }
    }

    @ModelAttribute("userForm")
    public User getUser(){
        return new User();
    }
}
