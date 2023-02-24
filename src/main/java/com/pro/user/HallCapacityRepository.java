package com.pro.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface HallCapacityRepository extends JpaRepository<HallCapacity, Integer> {
    @Transactional  
	@Modifying
	@Query("UPDATE HallCapacity h SET h.SeatCount=(h.SeatCount - :nos)  WHERE h.HallCapacityId = :hallcapid")
	void updateSeatCapacity(int nos, int hallcapid);
}
