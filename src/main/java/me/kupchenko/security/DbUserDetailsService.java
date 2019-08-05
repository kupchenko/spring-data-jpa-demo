package me.kupchenko.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.kupchenko.dao.UserRepository;
import me.kupchenko.model.Role;
import me.kupchenko.model.User;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
public class DbUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Loading '{}' info... ", username);
        Optional<User> userOptional = userRepository.findByName(username);
        User user = userOptional.orElseThrow(() -> {
            log.warn("User not found with username: {}", username);
            return new UsernameNotFoundException("No user found for username: " + username);
        });
        return DbUserDetails.builder()
                .authorities(user.getRoles().stream().map(Role::getName).map(SimpleGrantedAuthority::new).collect(Collectors.toList()))
                .password(user.getPassword())
                .username(user.getName())
                .build();
    }
}
