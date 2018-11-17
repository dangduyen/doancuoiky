package vn.hcmute.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vn.hcmute.onlineshop.entity.Product;
import vn.hcmute.onlineshop.model.request.ProductModel;
import vn.hcmute.onlineshop.service.ProductService;

@Controller
public class AdminController {
    @Autowired
    private ProductService productService;
    @GetMapping("/quanlydonhang")
        public String quanlydonhang(){
        return ("/quanlydonhang");
        }
     @GetMapping("/quanlythongtin")
    public String quanlythongtin(){
        return ("/quanlythongtin");
     }
    @GetMapping("/quanlytaikhoan")
    public String quanlytaikhoan(){
        return ("/quanlytaikhoan");
    }
    @GetMapping("/quanlysanpham")
    public String quanlysanpham(){
        return ("/quanlysanpham");
    }
    @GetMapping("/admin")
    public String admin(){
        return ("/admin");
    }
    @GetMapping("/addsanpham")
    public String addsanpham(Model model){
        ProductModel productModel=new ProductModel();
        model.addAttribute("addsanpham", "");
        model.addAttribute("addsanpham", productModel);
        return ("/addsanpham");
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
        return ("/adddonhang");
    }
    @GetMapping("/addthongtin")
    public String addthongtin(){
        return ("/addthongtin");
    }

    }

