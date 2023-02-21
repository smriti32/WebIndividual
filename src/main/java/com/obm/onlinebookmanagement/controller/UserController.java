package com.obm.onlinebookmanagement.controller;

import com.obm.onlinebookmanagement.entity.User;
import com.obm.onlinebookmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController
{
    @Autowired
    private UserRepository userRepository;

    @GetMapping({"/SignUpPage","editBookedBook/SignUpPage","editBook/SignUpPage"})
    public String viewSignUpPage(Model model)
    {
        model.addAttribute("user", new User());
        return "signupPage.html";
    }

    //here we use BCryptPasswordEncoder to encode the user’s password
    // so the password itself it is not stored in database (for better security)
    // – only the hash value of the password is stored.
    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return "registersuccess";
    }
}
