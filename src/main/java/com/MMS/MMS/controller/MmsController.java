package com.MMS.MMS.controller;

import com.MMS.MMS.repository.DummyDatabase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MmsController {

    //Home Page
    @GetMapping(value = "/")
    public String index(Model model){
        model.addAttribute("expenseDB", new DummyDatabase().getDummyDatabase());
        return "homePage";
    }

    @GetMapping(value = "/thymeleafTemplate")
    public String getTemplate(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "thymeleafTemplate";
    }

}
