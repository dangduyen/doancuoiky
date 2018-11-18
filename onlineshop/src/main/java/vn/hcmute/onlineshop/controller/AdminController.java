package vn.hcmute.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vn.hcmute.onlineshop.entity.Account;
import vn.hcmute.onlineshop.entity.Event;
import vn.hcmute.onlineshop.entity.Product;
import vn.hcmute.onlineshop.model.request.ProductModel;
import vn.hcmute.onlineshop.service.AccountService;
import vn.hcmute.onlineshop.service.EventService;
import vn.hcmute.onlineshop.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private ProductService productService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private EventService eventService;
    @GetMapping("/quanlydonhang")
        public String quanlydonhang(){
        return "quanlydonhang";
        }
     @GetMapping("/quanlythongtin")
    public String quanlythongtin(Model model){
        List<Event> events = new ArrayList<>();
        String keyword = "";
        events = eventService.getAllEvents(keyword);
        model.addAttribute("events", events);
        return "quanlythongtin";
     }
    @GetMapping("/quanlytaikhoan")
    public String quanlytaikhoan(Model model){
        List<Account> accounts = new ArrayList<>();
        String keyword = "";
        accounts = accountService.getAllAccounts(keyword);
        model.addAttribute("accounts",accounts);
        return "quanlytaikhoan";
    }
    @GetMapping("/quanlysanpham")
    public String quanlysanpham(Model model){
        List<Product> products=new ArrayList<>();
        String keyword="";
        products=productService.getAllProducts(keyword);
        model.addAttribute("products", products);
        return "quanlysanpham";
    }
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
    @GetMapping("/addsanpham")
    public String addsanpham(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "addsanpham";
    }
   @PostMapping("/addsanpham")
   public String addsanpham(Model model, @ModelAttribute("addsanpham") ProductModel productModel){
        String name=productModel.getName();
        double price=productModel.getPrice();
        boolean status=productModel.isStatus();
        int quantity=productModel.getQuantity();
       Product product= new Product();
       product.setName(name);
       product.setPrice(price);
       product.setQuantity(quantity);
       product.setStatus(status);
       productService.save(product);
        return "redirect:/quanlysanpham";
   }
    @GetMapping("/adddonhang")
    public String adddonhang(){
        return "adddonhang";
    }
    @GetMapping("/addthongtin")
    public String addthongtin(){
        return "addthongtin";
    }

    }

