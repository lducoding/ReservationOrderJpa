package com.ldu.reservationOrder.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ldu.reservationOrder.dto.ResUserDto;
import com.ldu.reservationOrder.entity.UserRole;
import com.ldu.reservationOrder.service.ResUserService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.TestConstructor.AutowireMode;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

//@WebMvcTest(ResUserControllerTest.class)
@AutoConfigureMockMvc
@TestConstructor(autowireMode = AutowireMode.ALL)
@SpringBootTest
class ResUserControllerTest {

    @MockBean
    private ResUserService resUserService;

    @MockBean
    private JPAQueryFactory jpaQueryFactory;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void userInfoTest() throws Exception {
        given(resUserService.userInfo(1L)).willReturn(new ResUserDto
            (1L, "123", "merlin", "aaa@ka.com", UserRole.ROLE_CUSTOMER, "19940407", 200));

        mockMvc.perform(MockMvcRequestBuilders.get("/userInfo/{resUserId}", 1L))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(jsonPath("$.mileage").value(200));
    }

    @Test
    void registerUserTest() throws Exception {
        ResUserDto resUserDto = new ResUserDto(99L, "password", "마법사", "kokoa@koko.com",
            UserRole.ROLE_SELLER, "19920415", 1000);

        String content  = objectMapper.writeValueAsString(resUserDto);

        given(resUserService.registerUser(resUserDto)).willReturn(99L);

        mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk());
//            .andDo(MockMvcResultHandlers.print());
    }
}