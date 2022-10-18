package com.ldu.reservationOrder.service;

import com.ldu.reservationOrder.dto.ResUserDto;
import com.ldu.reservationOrder.entity.UserRole;
import com.ldu.reservationOrder.repository.ResUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class ResUserServiceTest {

    @Autowired
    private ResUserService resUserService;
    @Autowired
    private ResUserRepository resUserRepository;

    @Test
    public void userInfoTest() throws Exception {
        ResUserDto resUserDtoOrigin = resUserService.userInfo(1L);
        ResUserDto resUserDtoOrigin2 = resUserService.userInfo(3L);

        ResUserDto resUserDtoTest = new ResUserDto(resUserRepository.findById(1L).get());

        assertEquals(resUserDtoOrigin, resUserDtoTest);
        assertEquals(resUserDtoOrigin2.getName(), "empty");
    }

//    @Test
//    public void registerUserTest() {
//        ResUserDto resUserDto = new ResUserDto(null, "asd", "dk", "lbrve@naver.com", UserRole.ROLE_CUSTOMER, "19920415", 10);
//        ResUserDto resUserDto1 = new ResUserDto(null, "asd", "dk", "lbrve2@1111naver.com", UserRole.ROLE_CUSTOMER, "19920415", 10);
//        Long aLong = resUserService.registerUser(resUserDto);
//        Long aLong1 = resUserService.registerUser(resUserDto1);
//
////        assertEquals(aLong, 0L);
//        assertEquals(aLong1, 4L);
//    }

    @Test
    public void duplicateUserTest() {
        boolean checkEmail = resUserService.duplicateUser("lbr222ve@naver.com");
        assertEquals(checkEmail, true);
    }

}