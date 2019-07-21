package me.kupchenko.service;

import me.kupchenko.dto.RequestUserDto;
import me.kupchenko.dto.UsersDto;

public interface UserService {
    UsersDto getAllUsers();

    void saveUser(RequestUserDto userDto);
}
