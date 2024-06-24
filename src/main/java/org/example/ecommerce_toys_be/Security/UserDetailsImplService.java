package org.example.ecommerce_toys_be.Security;

import org.example.ecommerce_toys_be.Entity.Role;
import org.example.ecommerce_toys_be.Entity.User;
import org.example.ecommerce_toys_be.Entity.UserRole;
import org.example.ecommerce_toys_be.Repository.RoleRepository;
import org.example.ecommerce_toys_be.Repository.UserRepository;
import org.example.ecommerce_toys_be.Repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailsImplService implements UserDetailsService {
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            List<UserRole> userRoles = userRoleRepository.findByUserId(user.get().getId());
            List<Role> roles = userRoles.stream().map(userRole -> roleRepository.findById(userRole.getId()).get()

             ).collect(Collectors.toList());
            return new UserDetailsImpl(user.get(), roles);
        }
        else {
            throw new UsernameNotFoundException("user not found");
        }
    }
}
