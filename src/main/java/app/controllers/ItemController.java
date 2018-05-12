package app.controllers;

import app.entities.Item;
import app.entities.User;
import app.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/user/items")
    public String renderUsers(Model model){
        List<Item> items = itemService.getAllItemsServ();
        model.addAttribute("allitems", items);
        return "user/items";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/doSomething")
    public String doSomethingWithPrimitive(@RequestParam String someParam){
        System.out.println(someParam);
        return "user/items";
    }


}
