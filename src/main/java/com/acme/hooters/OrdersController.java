package com.acme.hooters;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.acme.hooters.model.Order;
import com.acme.hooters.service.OrderNotFoundException;
import com.acme.hooters.service.OrderRepositroy;


@Controller
@RequestMapping("/orders/*")
public class OrdersController {

    @Autowired
    private OrderRepositroy orderRepository;
    
    @RequestMapping("list")
    public String list(Model model) {
        
        Collection<Order> allOrders = orderRepository.getAllOrders();
        System.out.println("###\n###\n###\n allOrders:" + allOrders.size());
        model.addAttribute("orders", allOrders);
        return "orders/list";
    }
    
    @RequestMapping("{id}/approove")
    public String approove(@PathVariable Long id, Model model, RedirectAttributes flash) {
        try {
            Order order = orderRepository.findByid(id);
            order.approove();
        } catch (OrderNotFoundException e) {
            flash.addFlashAttribute("msg", e.getMessage());
        }
        return "redirect:/orders/list";
    }
}
