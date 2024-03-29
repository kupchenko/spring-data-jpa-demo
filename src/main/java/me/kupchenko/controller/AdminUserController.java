package me.kupchenko.controller;

import lombok.RequiredArgsConstructor;
import me.kupchenko.dto.RequestUserDto;
import me.kupchenko.dto.UsersDto;
import me.kupchenko.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/user")
@RequiredArgsConstructor
public class AdminUserController {
    private final UserService userService;

    @GetMapping
    public UsersDto getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/stub")
    public void saveUsersStub() {
        userService.saveUser(new RequestUserDto("admin", "admin", "Dmitrii", "Kupchenko"));
    }

    @PostMapping
    public void saveUsers(@RequestBody RequestUserDto requestUserDto) {
        userService.saveUser(requestUserDto);
    }
}
