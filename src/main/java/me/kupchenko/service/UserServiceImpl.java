package me.kupchenko.service;

import lombok.RequiredArgsConstructor;
import me.kupchenko.dao.RoleRepository;
import me.kupchenko.dao.UserRepository;
import me.kupchenko.dto.RequestUserDto;
import me.kupchenko.dto.UserDto;
import me.kupchenko.dto.UsersDto;
import me.kupchenko.exception.NoRoleFoundException;
import me.kupchenko.mapper.UserMapper;
import me.kupchenko.model.Role;
import me.kupchenko.model.User;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder cryptPasswordEncoder;

    @Override
    public UsersDto getAllUsers() {
        List<UserDto> userDtos = userRepository.findAll().stream()
                .map(userMapper::userToUserDto)
                .collect(Collectors.toList());
        return new UsersDto(userDtos);
    }

    @Override
    public void saveUser(RequestUserDto userDto) {
        User user = userMapper.userDtoToUser(userDto);
        user.setPassword(cryptPasswordEncoder.encode(userDto.getPassword()));
        Role role = roleRepository.findByNameIgnoreCase("ROLE_USER").orElseThrow(NoRoleFoundException::new);
        user.getRoles().add(role);
        userRepository.save(user);
    }
}