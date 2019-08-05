package me.kupchenko.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.kupchenko.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public String userPage(Principal principal) {
        log.info("You've been logged in with username {}", principal.getName());
        return "user";
    }

    @PostMapping("/login/success")
    public String successForwardUrl() {
        return "redirect:/user";
    }
}
