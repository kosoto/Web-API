package com.rest.api.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.advice.exception.ProductTypeNotFoundException;
import com.rest.api.mapper.ProductTypeMapper;
import com.rest.api.model.ProductType;
import com.rest.api.model.response.ListResult;
import com.rest.api.model.response.SingleResult;
import com.rest.api.service.ResponseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;

@Api(tags = {"1. Product Type"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/productType")
public class ProductTypeCtrl {
	
	private final ProductTypeMapper mapper;
	private final ResponseService responseService;
	
	@ApiOperation(value = "상품 유형 조회", notes = "ID로 상품 유형을 조회한다.")
	@GetMapping("/get/{id}")
	public SingleResult<ProductType> getProductTypeByID(
			@ApiParam(value = "상품 유형 ID", required = true) @PathVariable String id) {		
		return responseService.getSingleResult(mapper.findById(id).orElseThrow(ProductTypeNotFoundException::new));		
	}
	
	@ApiOperation(value = "상품 유형 조회", notes = "모든 상품 유형을 조회한다.")
	@GetMapping("/list")
	public ListResult<ProductType> getAll() {
		return responseService.getListResult(mapper.findAll());
	}
}
