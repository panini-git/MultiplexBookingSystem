package com.pro.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface HallRepository extends JpaRepository<Hall, Integer>{
	@Transactional  
	@Modifying
	@Query("UPDATE Hall h SET h.TotalCapacity=(h.TotalCapacity - :nos)  WHERE h.HallId = :hallid")
	void updateTotalSeats(int nos, int hallid); 
}
