package com.rest.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.advice.exception.UserNotFoundException;
import com.rest.api.entity.User;
import com.rest.api.model.response.ListResult;
import com.rest.api.model.response.SingleResult;
import com.rest.api.repo.UserJpaRepo;
import com.rest.api.service.ResponseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;

@Api(tags = {"1. User"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
	private final UserJpaRepo userJpaRepo;
	private final ResponseService responseService;
	
	@ApiOperation(value = "유저 정보 조회")
	@GetMapping(value = "/user")
	public ListResult<User> findAllUser() {
		return responseService.getListResult(userJpaRepo.findAll());
	}
	
	@ApiOperation(value = "유저 정보 조회", notes = "ID로 유저 정보을 조회한다.")
	@GetMapping("/get/{id}")
	public SingleResult<User> getProductTypeByID(
			@ApiParam(value = "유저 ID", required = true) @PathVariable String id) {		
		return responseService.getSingleResult(userJpaRepo.findById(id).orElseThrow(UserNotFoundException::new));		
	}
	
}
