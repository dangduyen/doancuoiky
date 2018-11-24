package vn.hcmute.onlineshop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.lookup.MapDataSourceLookup;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.hcmute.onlineshop.entity.Account;
import vn.hcmute.onlineshop.entity.Customer;
import vn.hcmute.onlineshop.entity.Role;
import vn.hcmute.onlineshop.exception.NotFoundException;
import vn.hcmute.onlineshop.model.dto.AccountDto;
import vn.hcmute.onlineshop.model.dto.RoleDto;
import vn.hcmute.onlineshop.model.request.RegisterModel;
import vn.hcmute.onlineshop.service.AccountService;
import vn.hcmute.onlineshop.service.CustomerService;
import vn.hcmute.onlineshop.service.RoleService;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class UserController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private RoleService roleService;
    @Value("${login.error}")
    private String loginError;

    @Value("${register.error}")
    private String registerError;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/connect")
    public String connect(Model model){
        Account account=new Account();
        model.addAttribute("loginError","");
        model.addAttribute("account",account);
        return "connect";
    }
    @GetMapping("/login")
    public String login(Model model){
        Account account=new Account();
        model.addAttribute("loginError","");
        model.addAttribute("account",account);
        return  "login";
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.invalidate();
        return "index";
}
    @PostMapping("/login")
    public String login(Model model,
                        @ModelAttribute("account") Account account, HttpSession session){
        String username=account.getUsername();
        String password=account.getPassword();
        try{
            AccountDto accountDto = accountService.findAccountByUsernameAndPassword(username,password);
            System.out.println("accountDto "+ accountDto.getRoles().get(0).getName());
            List<RoleDto> roleAdminDtos =  accountDto.getRoles().stream()
                    .filter(roleDto -> roleDto.getName().equals("ROLE_ADMIN"))
                    .collect(Collectors.toList());
            if(roleAdminDtos.isEmpty()) {
                session.setAttribute("SESSION_FULL_NAME",account.getUsername());
                return "redirect:/";
            } else {
                session.setAttribute("SESSION_FULL_NAME",account.getUsername());
                return "redirect:/admin";
            }
        }
        catch (NotFoundException e){
            model.addAttribute("loginError",loginError);
            return "login";
        }
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
        customer.setAccount(account);
        customerService.save(customer);

        Role role = roleService.findByName("ROLE_USER");
        account.setLstRole(Arrays.asList(role));
        role.getLstAccount().add(account);
        roleService.saveRole(role);
;        return "redirect:/login";
    }
    @GetMapping("/care")
    public String care(){
        return "care";
    }
    @GetMapping("/product")
    public String product(Model model){
//        try {
//            List<ProductList> productLists = productListService.retrieveAllProductList();
//            model.addAttribute("productList",productLists);
//        } catch (NotFoundException ex){
//            model.addAttribute("error",ex.getMessage());
//        }
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
    @GetMapping("/chitietsp")
    public String chitietsp(){
        return "chitietsp";
    }
    @GetMapping("/cart")
    public String cart(){
        return "cart";
    }
    @GetMapping("/buy")
    public String buy(){
        return "buy";
    }
}
