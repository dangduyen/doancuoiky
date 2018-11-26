package vn.hcmute.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.hcmute.onlineshop.entity.Account;
import vn.hcmute.onlineshop.entity.Bill;
import vn.hcmute.onlineshop.entity.Event;
import vn.hcmute.onlineshop.entity.Product;
import vn.hcmute.onlineshop.exception.NotFoundException;
import vn.hcmute.onlineshop.model.request.ProductModel;
import vn.hcmute.onlineshop.service.*;

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
    @Autowired
    private ProductListService productListService;
    @Autowired
    private BillService billService;
    @GetMapping("/quanlydonhang")
        public String quanlydonhang(Model model){
        List<Bill> bills=new ArrayList<>();
        String keyword="";
        bills=billService.getAllBill(keyword);
        model.addAttribute("bills",bills);
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
        model.addAttribute("productList",productListService.getAllProductList());

        return "addsanpham";
    }
    @GetMapping("/editsanpham")
    public String editsanpham(@RequestParam("id") long id, Model model){
        Product product = new Product();
        try {
            product=productService.findProductById(id);

        } catch (NotFoundException ex) {
            model.addAttribute("error", ex.getMessage());

        }
        model.addAttribute("product", product);
        return "editproduct";
    }
    @GetMapping("editdonhang")
    public String eidtdonhang(@RequestParam("id") long id, Model model){
        Bill bill=new Bill();
        try {
            bill=billService.findBillById(id);
        }catch (NotFoundException ex){
            model.addAttribute("error",ex.getMessage());
        }
        model.addAttribute("bill",bill);
        return "editdonhang";
    }
    @GetMapping("/adddonhang")
    public String adddonhang(Model model){
        Bill bill=new Bill();
        model.addAttribute("bill",bill);
        return "adddonhang";
    }
    @GetMapping("/editthongtin")
    public  String editthongtin(@RequestParam("id") long id, Model model){
        Event event=new Event();
        try {

            event=eventService.findEventById(id);

        }catch (NotFoundException ex){
            model.addAttribute("error", ex.getMessage());
        }
        model.addAttribute("event",event);
        return "editthongtin";
    }
    @GetMapping("/addthongtin")
    public String addthongtin(Model model){
        Event event=new Event();
        model.addAttribute("event",event);
        return "addthongtin";
    }

    }

