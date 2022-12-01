package com.enotes.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enotes.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
	Optional<User> findUserByEmailAndPassword(String email,String password);
		 

}
