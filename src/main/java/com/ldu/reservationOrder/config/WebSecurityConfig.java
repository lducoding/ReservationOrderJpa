package com.ldu.reservationOrder.config;

import com.ldu.reservationOrder.repository.ResMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final CorsFilter corsFilter;
//    private final ResMemberRepository resMemberRepository;
}
