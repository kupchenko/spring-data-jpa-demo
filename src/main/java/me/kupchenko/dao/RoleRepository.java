package me.kupchenko.dao;

import me.kupchenko.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByNameIgnoreCase(String name);
}
