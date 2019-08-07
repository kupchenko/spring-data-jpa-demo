package me.kupchenko.controller;

import lombok.RequiredArgsConstructor;
import me.kupchenko.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/login")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

//    @PostMapping
//    public void saveUsers(@RequestBody LoginRequestDto loginRequestDto) {
//        userService.saveUser(requestUserDto);
//    }
}
