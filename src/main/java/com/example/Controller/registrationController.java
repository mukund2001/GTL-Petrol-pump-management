package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // ✅ Corrected import
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Repository.UserRepository;

@Controller
public class registrationController { // ✅ Renamed properly

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) { 
        model.addAttribute("user", new com.example.Model.user()); // ✅ Fully qualified to avoid conflicts
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") com.example.Model.user user, Model model) { // ✅ Fully qualified
        if (userRepository.findByUsername(user.getUsername()) != null) {
            model.addAttribute("error", "Username already exists");
            return "register";
        }
        
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER"); // Default role
        userRepository.save(user);
        
        return "redirect:/login?registered";
    }
}
