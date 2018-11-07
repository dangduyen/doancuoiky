package vn.hcmute.onlineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
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
    @GetMapping("/addsanpham")
    public String addsanpham(){
        return ("/addsanpham");
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

