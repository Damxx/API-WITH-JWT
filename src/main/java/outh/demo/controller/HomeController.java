package outh.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import outh.demo.model.UserApplication;
import outh.demo.repository.UserRepository;
import outh.demo.service.UserProgressService;
import outh.demo.service.UserService;

import java.security.Principal;

@RestController
@RequestMapping("/users")
public class HomeController {

    private UserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserService userService;

    @Autowired
    private UserProgressService userProgressService;

    public HomeController(UserRepository applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder,
                          UserService userService) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userService = userService;
    }

    @PostMapping("/sign-up")
    public boolean signUp(@RequestBody UserApplication userApplication) {
        if(applicationUserRepository.existsByUsernameOrEmail(userApplication.getUsername(),userApplication.getEmail())){
            return false;
        }
        userService.saveUser(userApplication);
        return true;
    }
    @GetMapping("/test1")
    public String testOne(){
        return "test";
    }

    @GetMapping("/test2")
    public String testTwo(){
        return "test2";
    }

    @GetMapping("/test3")
    public String testThree(Authentication authentication, Principal principal){
        System.out.println(authentication.toString());
        UserApplication userApplication = applicationUserRepository.findByUsername(principal.getName());
        return "three";
    }

    @PostMapping("/addexperience/{exp}")
    public boolean addexperience(Principal principal,@PathVariable("exp") int experience){
        UserApplication userApplication = applicationUserRepository.findByUsername(principal.getName());
        userProgressService.addExperience(userApplication,experience);
        return true;
    }

}
