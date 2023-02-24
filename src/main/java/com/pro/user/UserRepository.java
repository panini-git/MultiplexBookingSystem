package com.pro.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{

	Object findByName(String username);

	Object findByPass(String password);
}
