package com.ldu.reservationOrder.service;

import com.ldu.reservationOrder.dto.ResUserDto;
import com.ldu.reservationOrder.entity.ResUser;
import com.ldu.reservationOrder.repository.ResJdbcRepository;
import com.ldu.reservationOrder.repository.ResRepositoryCustom;
import com.ldu.reservationOrder.repository.ResUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ResUserService {

    //    private final ResJdbcRepository resJdbcRepository;
    private final ResUserRepository resUserRepository;
//    private final ResRepositoryCustom resRepositoryCustom;


    public ResUserDto userInfo(Long userId) {
        ResUser resUser = resUserRepository.findById(userId).orElseGet(() -> new ResUser("empty"));
        ResUserDto resUserDto = new ResUserDto(resUser);
        return resUserDto;
    }

    public Long registerUser(ResUserDto resUserDto) {
        if (duplicateUser(resUserDto.getEmail())) {
            return 0L;
        }
        ResUser resUser = new ResUser(resUserDto);
        ResUser save = resUserRepository.save(resUser);
        return save.getResUserId();
    }

    public boolean duplicateUser(String email) {
        ResUser byEmail = resUserRepository.findByEmail(email);
        if (byEmail == null) {
            System.out.println("중복아님");
            return false;
        }
        System.out.println("중복");
        return true;
    }
}
