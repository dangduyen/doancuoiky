package vn.hcmute.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import vn.hcmute.onlineshop.entity.Account;
import vn.hcmute.onlineshop.entity.Event;
import vn.hcmute.onlineshop.entity.Product;
import vn.hcmute.onlineshop.model.dto.AccountDto;
import vn.hcmute.onlineshop.model.dto.EventDto;
import vn.hcmute.onlineshop.model.dto.ProductDto;
import vn.hcmute.onlineshop.service.AccountService;
import vn.hcmute.onlineshop.service.EventService;
import vn.hcmute.onlineshop.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class AdminRestController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private ProductService productService;
    @Autowired
    private EventService eventService;
    @PostMapping("/quanlytaikhoan")
    public ResponseEntity<?> searchUser(HttpServletRequest request) {
        String keyword = request.getParameter("keyword");
        Optional.of(keyword).orElse("");
        List<Account> accounts  = accountService.getAllAccounts(keyword);
        List<AccountDto> accountDtos =accounts.stream()
                .map(account -> new AccountDto(account.getId(),account.getUsername(),account.getPassword(),
                        account.getCustomer().getName(), account.getCustomer().getPhone(), account.getCustomer().getEmail()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(accountDtos);
    }
    @PostMapping("/quanlysanpham")
    public ResponseEntity<?> searchProduct(HttpServletRequest request){
        String keyword=request.getParameter("keyword");
        Optional.of(keyword).orElse("");
        List<Product> products=productService.getAllProducts(keyword);
        List<ProductDto> productDtos=products.stream()
                .map(product -> new ProductDto(product.getId(),product.getName(),product.getPrice(), product.getQuantity(),product.isStatus()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(productDtos);
    }
    @PostMapping("/quanlythongtin")
    public ResponseEntity<?> searchEvent(HttpServletRequest request){
        String keyword=request.getParameter("keyword");
        Optional.of(keyword).orElse("");
        List<Event> events=eventService.getAllEvents(keyword);
        List<EventDto> eventDtos=events.stream()
                .map(event -> new EventDto(event.getId(),event.getName(), event.getContent(), event.getStartDate(), event.getEndDate()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(eventDtos);
    }
}
