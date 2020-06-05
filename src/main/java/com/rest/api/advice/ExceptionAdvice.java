package com.rest.api.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rest.api.advice.exception.ProductTypeNotFoundException;
import com.rest.api.model.response.CommonResult;
import com.rest.api.service.ResponseService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionAdvice {
	private final ResponseService responseService;
	private final MessageSource messageSource;
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	protected CommonResult defaultException(HttpServletRequest request, Exception e) {
		return responseService.getFailResult(Integer.valueOf(getMessage("unKnown.code")), getMessage("unKnown.msg"));
	}
	
	@ExceptionHandler(ProductTypeNotFoundException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	protected CommonResult productTypeNotFoundException(HttpServletRequest request, ProductTypeNotFoundException e) {
		return responseService.getFailResult(Integer.valueOf(getMessage("productTypeNotFound.code")), getMessage("productTypeNotFound.msg"));
	}

	/**
	 * code정보에 해당하는 메시지를 조회합니다. 
	 * @param code
	 * @return
	 */
    private String getMessage(String code) {
        return getMessage(code, null);
    }
    
    /**
     * code정보, 추가 argument로 현재 locale에 맞는 메시지를 조회합니다.
     * @param code
     * @param args
     * @return
     */
    private String getMessage(String code, Object[] args) {    	
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
