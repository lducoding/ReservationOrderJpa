package com.ldu.reservationOrder.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ldu.reservationOrder.config.auth.PrincipalDetails;
import com.ldu.reservationOrder.entity.ResUser;
import com.ldu.reservationOrder.repository.ResMemberRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private ResMemberRepository resMemberRepository;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, ResMemberRepository resMemberRepository) {
        super(authenticationManager);
        this.resMemberRepository = resMemberRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        Cookie[] cookies = request.getCookies();
        Cookie cookie2 = null;
        if(cookies!=null) {
        for (Cookie cookie : cookies ) {
            if(cookie.getName().equals("Authorization")) {
                String jwtToken = cookie.getValue().replace("Bearer", "");
                String username = JWT.require(Algorithm.HMAC512("donguking")).build().verify(jwtToken).getClaim("email").asString();

                if (username != null) {
                    ResUser userEntity = resMemberRepository.findByEmail(username);

                    // jwt토큰 서명을 통해서 서명이 정상이면 Authentication 객체를 만들어준다.
                    PrincipalDetails principalDetails = new PrincipalDetails(userEntity);
                    Authentication authentication = new UsernamePasswordAuthenticationToken(principalDetails, null,
                            principalDetails.getAuthorities());

                    // 강제로 시큐리티의 세션에 접근하여 Authentication 객체를 저장
                    SecurityContextHolder.getContext().setAuthentication(authentication);    // 시큐리티를 저장할 수 있는 세션공간 SecurityContextHolder.getContext()
                    System.out.println("권한은: " + principalDetails.getUserInfo().getRoles());
                    chain.doFilter(request, response);
                } else {
                    System.out.println("jwt 쿠키가 없음");
                }
            }
        }
        }
        chain.doFilter(request,response);
    }
}
