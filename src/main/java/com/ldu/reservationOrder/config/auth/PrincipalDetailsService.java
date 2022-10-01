package com.ldu.reservationOrder.config.auth;

import com.ldu.reservationOrder.entity.ResUser;
import com.ldu.reservationOrder.repository.ResUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// http://localhost:8080/login 하면 일로 와야 하는데 안옴 formlogin().disabled해서
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final ResUserRepository resMemberRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User userEntity = userRepository.findByUsername(username);
        ResUser userInfo = resMemberRepository.findByEmail(email);
        PrincipalDetails principalDetails = new PrincipalDetails(userInfo);
        return principalDetails;
    }
}
