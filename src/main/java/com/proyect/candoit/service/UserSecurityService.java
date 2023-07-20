package com.proyect.candoit.service;

import com.proyect.candoit.model.User;
import com.proyect.candoit.repository.UserRepository;
import com.proyect.candoit.security.AuthenticatedUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserSecurityService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isPresent()) return new AuthenticatedUser(user.get());
        throw new UsernameNotFoundException("Usuario no encontrado" +  username);
    }
}
