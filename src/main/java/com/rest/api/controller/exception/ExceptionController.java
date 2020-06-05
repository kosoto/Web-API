package com.rest.api.controller.exception;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.advice.exception.AuthenticationEntryPointException;
import com.rest.api.model.response.CommonResult;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/exception")
public class ExceptionController {
	
	@GetMapping("/entrypoint")
	public CommonResult entrypointException() {
		throw new AuthenticationEntryPointException();
	}
	
	@GetMapping("/accessdenied")
	public CommonResult accessdeniedException() {
		throw new AccessDeniedException("");
	}
}
