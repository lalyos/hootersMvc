package com.acme.hooters;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GirlsController {

    @RequestMapping("/girls")
    public String list(Model model) {
        
        String[] girls = new String[]{"lucy", "suzy", "jolan"};
        model.addAttribute("girls", girls);
        
        return "girls/list";
    }
}
