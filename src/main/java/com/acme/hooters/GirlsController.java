package com.acme.hooters;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingErrorProcessor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
        
        model.addAttribute("girl", new Girl());
        model.addAttribute("basketOptions", getBasketOptions());
        model.addAttribute("girls", girlRepository.getAllGirls());
        
        return "girls/list";
    }
    
    private Object getBasketOptions() {        
        return Arrays.asList("A","B","C","D");
    }

    @RequestMapping("remove")
    public String remove(@RequestParam String name, RedirectAttributes model) {
        
        girlRepository.remove(name);
        model.addFlashAttribute("msg", "You have successfully deleted: " + name);

        return "redirect:/girls/list";
    }
    
    @RequestMapping("add")
    public String add(@Valid Girl girl, BindingResult errors, Model model, RedirectAttributes flash) {
        if (errors.hasErrors()) {
            model.addAttribute("girl", girl);
            model.addAttribute("basketOptions", getBasketOptions());
            model.addAttribute("girls", girlRepository.getAllGirls());
            return "girls/list";
        } else {
            girlRepository.addGirl(girl);
            flash.addFlashAttribute("msg", "You have succesfully added: " + girl.getName());
            return "redirect:/girls/list";  
        }
              
    }
    
    @ExceptionHandler
    public String error(Exception e) {
        e.printStackTrace();
        return "error";
    }
        
}
