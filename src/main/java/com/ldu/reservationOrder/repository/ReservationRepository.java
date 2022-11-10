package com.ldu.reservationOrder.repository;

import com.ldu.reservationOrder.entity.ResUser;
import com.ldu.reservationOrder.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long>, ReservationRepositoryCustom {

}
