package com.LoginFunctionalityWork.controller;

import com.LoginFunctionalityWork.entity.UserDetails;
import com.LoginFunctionalityWork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class HomeController {
    @Autowired
    private UserService userService;

    @GetMapping("/logins")
    public String loginPage(){
        return "login.jsp";
    }

    @PostMapping("/logins-account")
    public String login(@RequestParam String email, @RequestParam String password, ModelMap model){
        if (userService.validateUser(email, password)){
            UserDetails details = userService.findByEmail(email);
            model.addAttribute("email", details.getEmail());
            return "home.jsp";
        }else {
            return "login.jsp";
        }
    }

    @GetMapping("/logout")
    public String logout(){
        return "login.jsp";
    }
}