package vn.hcmute.onlineshop.controller;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.lookup.DataSourceLookupFailureException;
import org.springframework.jdbc.datasource.lookup.MapDataSourceLookup;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.hcmute.onlineshop.entity.Account;
import vn.hcmute.onlineshop.entity.Bill;
import vn.hcmute.onlineshop.entity.Event;
import vn.hcmute.onlineshop.entity.Product;
import vn.hcmute.onlineshop.model.dto.AccountDto;
import vn.hcmute.onlineshop.model.dto.BillDto;
import vn.hcmute.onlineshop.model.dto.EventDto;
import vn.hcmute.onlineshop.model.dto.ProductDto;
import vn.hcmute.onlineshop.model.response.DataReturn;
import vn.hcmute.onlineshop.service.AccountService;
import vn.hcmute.onlineshop.service.BillService;
import vn.hcmute.onlineshop.service.EventService;
import vn.hcmute.onlineshop.service.ProductService;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    @Autowired
    private BillService billService;
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
    @PostMapping("/xoataikhoan")
    public DataReturn deleteAccount(HttpServletRequest request){
        long id= Long.parseLong(request.getParameter("id"));
        DataReturn dataReturn=new DataReturn();
        dataReturn= accountService.deleteAccount(id);
        return dataReturn;

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
    @PostMapping("/themsanpham")
    public DataReturn addProduct(HttpServletRequest request){
        String name = request.getParameter("name");
        DataReturn dataReturn = new DataReturn();
        double price = Double.parseDouble((request.getParameter("price")));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        long productListId = Long.parseLong(request.getParameter("productListId"));

        Product newProduct = new Product(name, status, price, quantity );
        dataReturn = productService.saveProduct(newProduct, productListId);

        return dataReturn;
    }
    @PostMapping("/xoasanpham")
    public DataReturn deleteProduct(HttpServletRequest  request){
        long id= Long.parseLong(request.getParameter("id"));
        DataReturn dataReturn=new DataReturn();
        dataReturn=productService.deleteProduct(id);

        return dataReturn;
    }
    @PostMapping("/suasanpham")
    public DataReturn editProduct(HttpServletRequest request){
        Long id = Long.valueOf(request.getParameter("id").trim());
        String name=request.getParameter("name");
        Float price= Float.valueOf(request.getParameter("price"));
        Integer quantity= Integer.valueOf(request.getParameter("quantity"));
        Boolean status= Boolean.valueOf(request.getParameter("status"));
        DataReturn dataReturn=new DataReturn();
        dataReturn=productService.editProduct(id, name, price, quantity, status);
        return dataReturn;

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
    @PostMapping("/themthongtin")
    public DataReturn addEvent(HttpServletRequest request){
        String name=request.getParameter("name");
        DataReturn dataReturn=new DataReturn();
        String content=request.getParameter("content");
        String startDate=request.getParameter("startDate");
        String endDate=request.getParameter("endDate");
        Event newEvent=new Event(name, content, Date.valueOf(Optional.of(startDate).orElse("1/1/1991")),Date.valueOf(Optional.of(endDate).orElse("1/1/1991")));
        dataReturn=eventService.saveEvent(newEvent);
        return dataReturn;
    }
    @PostMapping("/xoathongtin")
    public DataReturn deleteEvent(HttpServletRequest request){
        long id= Long.parseLong(request.getParameter("id"));
        DataReturn dataReturn=new DataReturn();
        dataReturn=eventService.deleteEvent(id);
        return dataReturn;
    }
    @PostMapping("/editthongtin")
    public DataReturn editthongtin(HttpServletRequest request){
        Long id= Long.valueOf(request.getParameter("id").trim());
        String name=request.getParameter("name");
        String content=request.getParameter("content");
        String startDate=request.getParameter("startDate");
        String endDate=request.getParameter("endDate");
//        Event newEvent=new Event(name, content, Date.valueOf(Optional.of(startDate).orElse("1/1/1991")),Date.valueOf(Optional.of(endDate).orElse("1/1/1991")));
        DataReturn dataReturn=new DataReturn();
        dataReturn=eventService.editEvent(id,name,content,Date.valueOf(Optional.of(startDate).orElse("1/1/1991")),Date.valueOf(Optional.of(endDate).orElse("1/1/1991")));
        return dataReturn;
    }
    @PostMapping("/quanlydonhang")
    public ResponseEntity<?> searchBill(HttpServletRequest request){
        String keyword=request.getParameter("keyword");
        Optional.of(keyword).orElse("");
        List<Bill> bills=billService.getAllBill(keyword);
        List<BillDto> billDtos=bills.stream()
                .map(bill -> new BillDto(bill.getId(),bill.getTotal(),bill.getPayDate(),bill.getRecipients()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(billDtos);
    }
    @PostMapping("/themdonhang")
    public DataReturn addBill(HttpServletRequest request){
        Double total= Double.valueOf(request.getParameter("total"));
        String payDate=request.getParameter("payDate");
        String recipients=request.getParameter("recipients");
        Bill newBill=new Bill(total,Date.valueOf(Optional.of(payDate).orElse("1/1/1991")),recipients,null, null,null);
        DataReturn dataReturn=new DataReturn();
        dataReturn=billService.saveBill(newBill);
        return dataReturn;
    }
    @PostMapping("/xoadonhang")
    public DataReturn deleteBill(HttpServletRequest request){
        long id= Long.parseLong(request.getParameter("id"));
        DataReturn dataReturn=new DataReturn();
        dataReturn=billService.deleteBill(id);
        return dataReturn;
    }
    @PostMapping("/editdonhang")
    public DataReturn editBill(HttpServletRequest request){
        Long id= Long.valueOf(request.getParameter("id").trim());
        Double total= Double.valueOf(request.getParameter("total"));
        String payDate=request.getParameter("payDate");
        String recipients=request.getParameter("recipients");
        DataReturn dataReturn=new DataReturn();
        dataReturn=billService.editBill(id,total,Date.valueOf(Optional.of(payDate).orElse("1/1/1991")),recipients);
        return dataReturn;
    }
    @PostMapping("/getinstance")
    public DataReturn getInstance(HttpServletRequest request) {
        DataReturn dataReturn = new DataReturn();
        MapDataSourceLookup mapDataSourceLookup = new MapDataSourceLookup();
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        try {
            dataSourceMap = mapDataSourceLookup.getDataSources();
            System.out.println("try : " + dataSourceMap);
            dataReturn.setSuccess("true");
        } catch (DataSourceLookupFailureException ex) {
            System.out.println("exception : " + ex.getMessage());
            dataReturn.setSuccess("false");
            dataReturn.setError(ex.getMessage());
        }

        dataReturn.setData(dataSourceMap);
        return dataReturn;
    }
}
