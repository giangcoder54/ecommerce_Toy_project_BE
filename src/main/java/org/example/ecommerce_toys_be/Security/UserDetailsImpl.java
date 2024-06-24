package org.example.ecommerce_toys_be.Security;




import org.example.ecommerce_toys_be.Entity.Role;
import org.example.ecommerce_toys_be.Entity.User;
import org.example.ecommerce_toys_be.Repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

//Spring Security use UserDetail object to authenticate and store infor from User
// Therefore, we need create UserDetailImpl to convert user to UserDetails
public class UserDetailsImpl implements UserDetails {
    private final User user;
    private final List<Role> roles;

    public UserDetailsImpl(User user, List<Role> roles) {
        this.user = user;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.getStatus().equals("ACTIVE");
    }
}

