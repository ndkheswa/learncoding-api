package com.learncoding.learncodingapi.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Data
public class CustomUserDetail implements UserDetails {

    private ApplicationUser applicationUser;

    private Set<GrantedAuthority> authorities = null;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return applicationUser.getPassword();
    }

    @Override
    public String getUsername() {
        return applicationUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return applicationUser.isAccountNotExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return applicationUser.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return applicationUser.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return applicationUser.isEnabled();
    }
}
