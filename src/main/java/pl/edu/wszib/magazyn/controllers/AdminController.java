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
import pl.edu.wszib.magazyn.model.view.ProductModel;
import pl.edu.wszib.magazyn.services.iProductService;
import pl.edu.wszib.magazyn.session.SessionObject;

import javax.annotation.Resource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class AdminController {

    @Autowired
    iProductService productService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable int id, Model model){
        if (!sessionObject.isLogged()){
            return "redirect:http://localhost:8080/login";
        }
        if (sessionObject.getLoggedUser().getRola() != User.Role.ADMIN){
            if (sessionObject.getLoggedUser().getRola() == User.Role.RESUPPLIER){
                return "redirect:/resupply/"+id;
            }
            return "redirect:/main";
        }
        model.addAttribute("product", this.productService.getProductByID(id));
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("role", this.sessionObject.getLoggedUser().getRola().toString());
        model.addAttribute("info", this.sessionObject.getInfo());
        return "edit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editPage(@ModelAttribute Product product, @PathVariable int id){
        if (!sessionObject.isLogged()){
            return "redirect:http://localhost:8080/login";
        }
        if (sessionObject.getLoggedUser().getRola() != User.Role.ADMIN){
            if (sessionObject.getLoggedUser().getRola() == User.Role.RESUPPLIER){
                return "redirect:/resupply/"+id;
            }
            return "redirect:/main";
        }
        Pattern regexp = Pattern.compile("[ A-Za-z0-9._-]{5}.*");
        Matcher nameMatcher = regexp.matcher(product.getName());

        if(!nameMatcher.matches()) {
            this.sessionObject.setInfo("Nazwa musi być długości 5 lub więcej.");
            return "redirect:http://localhost:8080/edit/"+id;
        }
        if(product.getQuantity()<0){
            this.sessionObject.setInfo("Ilość Sztuk nie może być ujemna.\nWpisałeś "+product.getQuantity());
            return "redirect:http://localhost:8080/edit/"+id;
        }
        int error=this.productService.editProduct(product);
        if(error==1){
            this.sessionObject.setInfo("Produkt o takiej nazwie już znajduje się w bazie danych.\nNazwa którą podałeś: "+product.getName());
            return "redirect:http://localhost:8080/edit/"+id;
        }
        if(error==2){
            this.sessionObject.setInfo("Wystąpił błąd podczas aktualizacji bazy danych");
            return "redirect:http://localhost:8080/edit/"+id;
        }
        return "redirect:/main";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model){
        if (!sessionObject.isLogged()){
            return "redirect:http://localhost:8080/login";
        }
        if (sessionObject.getLoggedUser().getRola() != User.Role.ADMIN){
            return "redirect:/main";
        }
        model.addAttribute("productModel", new ProductModel());
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("role", this.sessionObject.getLoggedUser().getRola().toString());
        model.addAttribute("info", this.sessionObject.getInfo());
        return "add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPage(@ModelAttribute ProductModel productModel){
        if (!sessionObject.isLogged()){
            return "redirect:http://localhost:8080/login";
        }
        if (sessionObject.getLoggedUser().getRola() != User.Role.ADMIN){
            return "redirect:/main";
        }
        Pattern regexp = Pattern.compile("[ A-Za-z0-9._-]{5}.*");
        Matcher nameMatcher = regexp.matcher(productModel.getName());

        if(!nameMatcher.matches()) {
            this.sessionObject.setInfo("Nazwa musi być długości 5 lub więcej.");
            return "redirect:http://localhost:8080/add";
        }
        if(productModel.getQuantity()<0){
            this.sessionObject.setInfo("Ilość Sztuk nie może być ujemna. Wpisałeś "+productModel.getQuantity());
            return "redirect:http://localhost:8080/add";
        }
        if(!this.productService.addProduct(productModel)){
            this.sessionObject.setInfo("Produkt o takiej nazwie już znajduje się w bazie danych. Nazwa którą podałeś: "+productModel.getName());
            return "redirect:http://localhost:8080/add";
        }
        return "redirect:/main";
    }
}
