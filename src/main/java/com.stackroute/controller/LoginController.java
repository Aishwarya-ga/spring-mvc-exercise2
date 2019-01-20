package com.stackroute.controller;

import com.stackroute.services.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping(value = "/")
    public String homepage(){
        return "index";
    }

    @RequestMapping("login")
    public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password){
        Login login = new Login();
        login.setUsername(username);
        login.setPassword(password);
        //Using ModelAndView we can send view along with object
        return new ModelAndView("welcome","username",login.getUsername());
    }
}
