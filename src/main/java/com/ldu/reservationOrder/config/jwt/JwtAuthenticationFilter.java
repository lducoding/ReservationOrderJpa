package com.ldu.reservationOrder.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ldu.reservationOrder.config.auth.PrincipalDetails;
import com.ldu.reservationOrder.entity.ResUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    @Override
    public void setFilterProcessesUrl(String filterProcessesUrl) {
        super.setFilterProcessesUrl(filterProcessesUrl);
    }

    // POST로 /login 요청시 실행되는 함수
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ResUser userInfo = objectMapper.readValue(request.getInputStream(), ResUser.class);
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(userInfo.getEmail(), userInfo.getPass());
            Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            return authentication;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        PrincipalDetails principalDetails = (PrincipalDetails) authResult.getPrincipal();

        String jwtToken = JWT.create()
                .withSubject("lduToken") // 토큰 이름
                .withExpiresAt(new Date(System.currentTimeMillis()+(60000*30))) // 토큰 유효시간
//                .withClaim("id", principalDetails.getUserInfo().getRes_user_id())
                .withClaim("email", principalDetails.getUserInfo().getEmail())
                .sign(Algorithm.HMAC512("donguking")); // 암호화 비밀키

//        response.addHeader("Authorization","Bearer"+jwtToken);
        Cookie jwtCookie = new Cookie("Authorization", "Bearer"+jwtToken);
        jwtCookie.setMaxAge(60*30);
        jwtCookie.setPath("/");
//        jwtCookie.setSecure(true);
//        jwtCookie.setHttpOnly(true);
//        response.addHeader("username", principalDetails.getUserInfo().getEmail());
        response.addCookie(jwtCookie);
    }
}