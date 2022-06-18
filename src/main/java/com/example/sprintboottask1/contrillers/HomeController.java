package com.example.sprintboottask1.contrillers;

import com.example.sprintboottask1.db.DBManager;
import com.example.sprintboottask1.db.Items;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {

    @GetMapping(value="/")
    public String index(Model model){
        ArrayList<Items> items = DBManager.getAllItems();
        model.addAttribute("all_items", items);
        return "indexpage";
    }

    @GetMapping(value = "/additem")
    public String addItem(Model model){
        return "additem";
    }

    @PostMapping(value = "/additem")
    public String addItem (@RequestParam(name = "item_name") String name,
                           @RequestParam(name = "item_description") String description,
                           @RequestParam(name = "item_price") double price){

        Items item = new Items();
        item.setName(name);
        item.setDescription(description);
        item.setPrice(price);

        DBManager.addItem(item);

        return "redirect:/";
    }

    @GetMapping(value = "/details/{itemId}")
    public String detailsPage(@PathVariable(name="itemId") Long id,
                              Model model){
        Items item = DBManager.getItem(id);
        model.addAttribute("one_item", item);
        return "details";
    }
}