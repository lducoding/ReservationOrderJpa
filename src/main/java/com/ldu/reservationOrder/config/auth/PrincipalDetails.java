package com.ldu.reservationOrder.config.auth;

import com.ldu.reservationOrder.entity.ResUser;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class PrincipalDetails implements UserDetails {

    private ResUser userInfo;

    public PrincipalDetails(ResUser user) {
        this.userInfo = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
//        userInfo.getRoles().forEach(r -> {
//            authorities.add(() -> r);
//        });

        authorities.add(() -> userInfo.getRoles().toString());
        return authorities;
    }

    @Override
    public String getPassword() {
        return userInfo.getPass();
    }

    @Override
    public String getUsername() {
        return userInfo.getEmail();
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
        return true;
    }
}
