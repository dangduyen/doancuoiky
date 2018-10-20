package vn.hcmute.onlineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/login")
    public  String login(){
        return  "login";
    }
    @GetMapping("/register")
    public  String register(){
        return "register";
    }
    @GetMapping("/care")
    public String care(){
        return "care";
    }
    @GetMapping("/product")
    public String product(){
        return "product";
    }
    @GetMapping("/chitietao")
    public String chitietao(){
        return "chitietao";
    }
}
