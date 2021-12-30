package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerSimple {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String getAdminPage() {
        return "admin";
    }

    @GetMapping("/user")
    public String getUserPage(){
        return "user";
    }
}
