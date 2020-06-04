package com.rest.api.ctrl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.mapper.ProductTypeMapper;
import com.rest.api.model.ProductType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = {"1. Product Type"})
@RestController
@RequestMapping("/productType")
public class ProductTypeCtrl {
	@Autowired
	private ProductTypeMapper mapper;
	
	@ApiOperation(value = "상품 유형 조회", notes = "ID로 상품 유형을 조회한다.")
	@GetMapping("/get/{id}")
	public ProductType getProductTypeByID(
			@ApiParam(value = "상품 유형 ID", required = true) @PathVariable String id) {
		return mapper.findById(id).orElse(null); 
	}
	
	@ApiOperation(value = "상품 유형 조회", notes = "모든 상품 유형을 조회한다.")
	@GetMapping("/list")
	public List<ProductType> getAll() {
		List<ProductType> list = (List<ProductType>) mapper.findAll();
		list.get(0).toString();
		return list;
	}
	
	@ApiOperation(value = "테스트", notes = "테스트")
	@GetMapping("/test")
	public ProductType test() {
		ProductType p = new ProductType();
		
		return p;
	}
}
