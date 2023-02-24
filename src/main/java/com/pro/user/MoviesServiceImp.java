package com.pro.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("productService")
public class MoviesServiceImp {
	@Autowired
	private MoviesRepository mr;
	
	public Iterable<Movies> findAll() {
		return mr.findAll();
	}
}
