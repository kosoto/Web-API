package com.rest.api.mapper;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rest.api.model.ProductType;

@Repository
public interface ProductTypeMapper extends CrudRepository<ProductType, String>{
	
	
}
