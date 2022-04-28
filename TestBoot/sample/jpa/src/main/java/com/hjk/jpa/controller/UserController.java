package com.hjk.jpa.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hjk.dao.UserDao;
import com.hjk.jpa.domain.Product;
import com.hjk.jpa.domain.Sex;
import com.hjk.jpa.domain.User;
import com.hjk.jpa.repos.UserReac;
import com.hjk.jpa.service.ProductService;
import com.hjk.jpa.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.agent.VirtualMachine.ForHotSpot.Connection.Response;
import reactor.core.publisher.Flux;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class UserController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;


    @GetMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<UserDao>> getUser() {
        return ResponseEntity.ok(UserDao.of(userService.findAll()));
    }

    @GetMapping(path = "/getUser")
    public ResponseEntity<User> getUser(@RequestParam("name")String name, @RequestParam("age") int age){
        return ResponseEntity.ok(userService.findByNameAndAge(name, age));
    }

    @GetMapping(path = "/save")
    @ResponseBody
    public ResponseEntity<User> save() {
        List<Product> productList = new ArrayList<Product>();
        productList.add(Product.builder().name("test1").build());
        User user = User.builder().age(29).name("호종규").birthDate(LocalDate.of(1994,03,17)).sex(Sex.MALE).productList(productList).build();
        userService.save(user);
        return ResponseEntity.ok(user);
    }

    
}
