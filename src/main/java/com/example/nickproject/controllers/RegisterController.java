package com.example.nickproject.controllers;

import com.example.nickproject.domains.User;
import com.example.nickproject.services.UserService;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    private ModelAndView registrationForm()
    {
        return new ModelAndView("register").addObject(new User("","","",1));
    }

    @PostMapping
    public String registration(@Valid User user, Errors errors, RedirectAttributes redirectAttributes)
    {
        if(errors.hasErrors())
        {
            return "registration";
        }
        /*userService.create(user);*/
        return "redirect:/";
    }
}
