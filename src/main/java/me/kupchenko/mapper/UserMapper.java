package me.kupchenko.mapper;

import me.kupchenko.dto.RequestUserDto;
import me.kupchenko.dto.UserDto;
import me.kupchenko.model.Role;
import me.kupchenko.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userToUserDto(User user);

    @Mapping(ignore = true, target = "id")
    User userDtoToUser(UserDto userDto);

    @Mapping(ignore = true, target = "id")
    User userDtoToUser(RequestUserDto userDto);

    Set<String> rolesSetToStringsSet(List<Role> roles);

    Set<Role> stringsSetToRolesSet(List<String> strings);

    default String roleToString(Role role) {
        return role.getName();
    }

    default Role stringToRole(String roleString) {
        Role role = new Role();
        role.setName(roleString);
        return role;
    }
}