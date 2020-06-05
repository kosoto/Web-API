package com.rest.api.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rest.api.entity.ProductType;

@Repository
public interface ProductTypeMapper extends CrudRepository<ProductType, String>{
	
	
}
