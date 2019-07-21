package me.kupchenko.mapper;

import me.kupchenko.dto.RequestUserDto;
import me.kupchenko.dto.UserDto;
import me.kupchenko.model.Role;
import me.kupchenko.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto userToUserDto(User user);

    @Mapping(ignore = true, target = "id")
    User userDtoToUser(UserDto userDto);

    @Mapping(ignore = true, target = "id")
    User userDtoToUser(RequestUserDto userDto);

    Set<String> rolesListToStringList(List<Role> roles);

    Set<Role> stringsListToRolesList(List<String> roleString);

    default String dtoToString(Role role) {
        return role.getName();
    }

    default Role dtoToString(String roleString) {
        Role role = new Role();
        role.setName(roleString);
        return role;
    }
}