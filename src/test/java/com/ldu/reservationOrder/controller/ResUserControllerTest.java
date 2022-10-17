package com.ldu.reservationOrder.controller;

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
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.TestConstructor.AutowireMode;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
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



    @Test
    void userInfoTest() throws Exception {
        given(resUserService.userInfo(1L)).willReturn(new ResUserDto
                (1L,"123","merlin","aaa@ka.com", UserRole.ROLE_CUSTOMER, "19940407",200));

        mockMvc.perform(MockMvcRequestBuilders.get("/userInfo/{resUserId}", 1L))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(jsonPath("$.mileage").value(200));
    }
}