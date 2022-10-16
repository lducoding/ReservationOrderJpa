package com.ldu.reservationOrder.controller;

import com.ldu.reservationOrder.dto.ResUserDto;
import com.ldu.reservationOrder.entity.UserRole;
import com.ldu.reservationOrder.service.ResUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@WebMvcTest(ResUserControllerTest.class)
@SpringBootTest
class ResUserControllerTest {

    @Autowired
    private ResUserService resUserService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void userInfoTest() throws Exception {
        given(resUserService.userInfo(1L)).willReturn(new ResUserDto
                (1L,"123","merlin","aaa@ka.com", UserRole.ROLE_CUSTOMER, "19940407",200));
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/userInfo/{resUserId}", 1L)).andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}