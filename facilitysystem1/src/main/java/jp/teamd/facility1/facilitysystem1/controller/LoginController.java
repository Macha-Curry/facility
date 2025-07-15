package jp.teamd.facility1.facilitysystem1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping(path="loginForm")
    String loginForm() {
        return "loginForm";
    }
}