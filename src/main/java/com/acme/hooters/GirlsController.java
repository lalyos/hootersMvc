package com.acme.hooters;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acme.hooters.model.Girl;
import com.acme.hooters.service.GirlRepository;

@Controller
public class GirlsController {

    @Autowired
    private GirlRepository girlRepository;
    
    @RequestMapping("/girls/list")
    public String list(Model model) {
        
        
        model.addAttribute("girls", girlRepository.getAllGirls());
        
        return "girls/list";
    }
    
    @RequestMapping("/girl/remove")
    public String remove(HttpServletRequest req, Model model) {
        
        girlRepository.remove(req.getParameter("name"));
        model.addAttribute("girls", girlRepository.getAllGirls());

        return "girls/list";
    }
    
    @RequestMapping("/girl/add")
    public String add(HttpServletRequest req, Model model) {
        
        int breastSize = Integer.valueOf(req.getParameter("breast"));
        Girl newGirl = new Girl(req.getParameter("name"), breastSize, req.getParameter("basket"));
        girlRepository.addGirl(newGirl);
        
        model.addAttribute("girls", girlRepository.getAllGirls());
        return "girls/list";        
    }
}
