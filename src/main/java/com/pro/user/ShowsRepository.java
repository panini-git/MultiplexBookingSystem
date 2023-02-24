package com.pro.user;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowsRepository extends JpaRepository<Shows, Integer> {

	//ArrayList<Movies> findByMovieId();
  
}
