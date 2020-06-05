package com.rest.api.service.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.rest.api.advice.exception.UserNotFoundException;
import com.rest.api.repo.UserJpaRepo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

	private final UserJpaRepo userJpaRepo;
	
	public UserDetails loadUserByUsername(String username) {
		return userJpaRepo.findById(username).orElseThrow(UserNotFoundException::new);		
	}

}
