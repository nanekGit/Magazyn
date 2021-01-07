package pl.edu.wszib.magazyn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.magazyn.services.iProductService;
import pl.edu.wszib.magazyn.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class CommonController {

    @Autowired
    iProductService productService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String landingPage(){
        return "redirect:/main";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model){
        model.addAttribute("products", this.productService.getAllProducts());
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        if(this.sessionObject.isLogged()) {
            model.addAttribute("role", this.sessionObject.getLoggedUser().getRola().toString());
        }else{
            model.addAttribute("role", null);
        }
        return "main";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String kontakt(Model model){
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        if(this.sessionObject.isLogged()) {
            model.addAttribute("role", this.sessionObject.getLoggedUser().getRola().toString());
        }else{
            model.addAttribute("role", null);
        }
        return "contact";
    }
}
