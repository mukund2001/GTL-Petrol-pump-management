package com.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {

    @GetMapping("/login")
    public String showLoginForm(Model model, String error, String logout, String registered) {
        // Handle login errors
        if (error != null) {
            model.addAttribute("errorMessage", "Invalid username or password!");
        }
        
        // Handle logout confirmation
        if (logout != null) {
            model.addAttribute("logoutMessage", "You have been logged out successfully!");
        }
        
        // Handle registration success
        if (registered != null) {
            model.addAttribute("registrationMessage", "Registration successful! Please login.");
        }
        
        return "login";
    }

    @GetMapping("/home")
    public String showHomePage() {
        return "home";
    }

    @GetMapping("/access-denied")
    public String showAccessDeniedPage() {
        return "error/access-denied";
    }
}