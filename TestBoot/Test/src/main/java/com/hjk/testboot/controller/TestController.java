package com.hjk.testboot.controller;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @GetMapping("/")
    public String test() {
        return "sns/main";
    }
    
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ResponseBody
    public void get(HttpServletRequest request,@RequestParam(value = "secretkey", required = true) String secretkey,@RequestBody String req) {
        System.out.println(req);
        System.out.println(secretkey);
        System.out.println(request);
    }



}
