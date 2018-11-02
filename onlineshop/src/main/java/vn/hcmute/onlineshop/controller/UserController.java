package vn.hcmute.onlineshop.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.hcmute.onlineshop.entity.Account;
import vn.hcmute.onlineshop.entity.Customer;
import vn.hcmute.onlineshop.exception.NotFoundException;
import vn.hcmute.onlineshop.model.request.RegisterModel;
import vn.hcmute.onlineshop.service.AccountService;
import vn.hcmute.onlineshop.service.CustomerService;

@Controller
public class UserController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerService customerService;

    @Value("${login.error}")
    private String loginError;

    @Value("${register.error}")
    private String registerError;

    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/login")
    public String login(Model model){
        Account account=new Account();
        model.addAttribute("loginError","");
        model.addAttribute("account",account);
        return  "login";
    }

    @PostMapping("/login")
    public String login(Model model,
                        @ModelAttribute("account") Account account){
        String username=account.getUsername();
        String password=account.getPassword();
        try{
            accountService.findAccountByUsernameAndPassword(username,password);
        }
        catch (NotFoundException e){
            model.addAttribute("loginError",loginError);
            return "login";
        }
        return "redirect:/";
    }
    @GetMapping("/register")
    public String register(Model model){
        RegisterModel registerModel=new RegisterModel();
        model.addAttribute("registerError","");
        model.addAttribute("register", registerModel);
        return "register";
    }
    @PostMapping("/register")
    public String register(Model model, @ModelAttribute("register") RegisterModel registerModel){
        String username=registerModel.getUsername();
        String email=registerModel.getEmail();
        String phone=registerModel.getPhone();
        String password=registerModel.getPasswword();
        String confirmPassword=registerModel.getConfirmPassword();
        if(!password.trim().equals(confirmPassword.trim())){
            model.addAttribute("registerError","Confirm password is incorrect!");
            return "register";
        }
        if(accountService.findAccountByUsername(username)==true){
            model.addAttribute("registerError","Username has been already exist!");
            return "register";
        }
        Account account=new Account();
        account.setUsername(username);
        account.setPassword(password);
        accountService.save(account);
        Customer customer=new Customer();
        customer.setEmail(email);
        customer.setPhone(phone);
        customer.setAccount(account);
        customerService.save(customer);
        account.setCustomer(customer);
        accountService.save(account);
        return "redirect:/login";
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
    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }
}
