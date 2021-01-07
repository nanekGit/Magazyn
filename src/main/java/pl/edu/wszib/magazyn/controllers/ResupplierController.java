package pl.edu.wszib.magazyn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.magazyn.model.Product;
import pl.edu.wszib.magazyn.model.User;
import pl.edu.wszib.magazyn.services.iProductService;
import pl.edu.wszib.magazyn.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class ResupplierController {

    @Autowired
    iProductService productService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/resupply/{id}", method = RequestMethod.GET)
    public String resupply(@PathVariable int id, Model model){
        if (!sessionObject.isLogged()){
            return "redirect:http://localhost:8080/login";
        }
        if (sessionObject.getLoggedUser().getRola() != User.Role.RESUPPLIER){
            if (sessionObject.getLoggedUser().getRola() == User.Role.ADMIN){
                return "redirect:/edit/"+id;
            }
            return "redirect:/main";
        }
        model.addAttribute("product", this.productService.getProductByID(id));
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("role", this.sessionObject.getLoggedUser().getRola().toString());
        model.addAttribute("info", this.sessionObject.getInfo());
        return "resupply";
    }

    @RequestMapping(value = "/resupply/{id}", method = RequestMethod.POST)
    public String resupplyPage(@ModelAttribute Product product, @PathVariable int id){
        if (!sessionObject.isLogged()){
            return "redirect:http://localhost:8080/login";
        }
        if (sessionObject.getLoggedUser().getRola() != User.Role.RESUPPLIER){
            if (sessionObject.getLoggedUser().getRola() == User.Role.ADMIN){
                return "redirect:/edit/"+id;
            }
            return "redirect:/main";
        }
        if(product.getQuantity()<0){
            this.sessionObject.setInfo("Ilość Sztuk nie może być ujemna. Wpisałeś "+product.getQuantity());
            return "redirect:http://localhost:8080/resupply/"+id;
        }
        product.setID(id);
        this.productService.resupplyProduct(product);
        return "redirect:/main";
    }
}
