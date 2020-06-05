package com.rest.api.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.api.entity.User;

public interface UserJpaRepo extends JpaRepository<User, String>{
	Optional<User> findByID(String id);
}
