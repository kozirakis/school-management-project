package com.example.mvc.webcontroller;


import com.example.middlewear.entity.registrationModels.UserRegistrationObject;
import com.example.middlewear.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private UserService userService;

    public RegistrationController(UserService userService){
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationObject userRegistrationObject() {
        return new UserRegistrationObject();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationObject UserRegistrationObject) {
        userService.save(UserRegistrationObject);
        return "redirect:/registration?success";
    }

}
