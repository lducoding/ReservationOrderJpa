package com.ldu.reservationOrder.repository;

import com.ldu.reservationOrder.entity.ResUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResUserRepository extends JpaRepository<ResUser, Long> {

    ResUser findByEmail(String email);
}
