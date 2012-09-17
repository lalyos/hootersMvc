package com.acme.hooters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.acme.hooters.model.Girl;
import com.acme.hooters.service.GirlRepository;

@Controller
@RequestMapping("/girls/*")
public class GirlsController {

    @Autowired
    private GirlRepository girlRepository;
    
    @RequestMapping("list")
    public String list(Model model) {
        
        
        model.addAttribute("girls", girlRepository.getAllGirls());
        
        return "girls/list";
    }
    
    @RequestMapping("remove")
    public String remove(@RequestParam String name, RedirectAttributes model) {
        
        girlRepository.remove(name);
        model.addFlashAttribute("msg", "You have successfully deleted: " + name);

        return "redirect:/girls/list";
    }
    
    @RequestMapping("add")
    public String add(@ModelAttribute Girl newGirl, RedirectAttributes model) {
        
        girlRepository.addGirl(newGirl);
        model.addFlashAttribute("msg", "You have succesfully added: " + newGirl.getName());
        return "redirect:/girls/list";        
    }
}
