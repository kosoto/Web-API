package com.rest.api.entity;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "OPE_TBM_PROD_TY")
@Data
public class ProductType {
	@Id
	@Column(name = "PROD_TY_ID")
	private String productTypeID;
	
	@Column(name = "PROD_TY_NM")
	private String productTypeName;
	
	@Column(name = "EVAL_MDUL_ID")
	private String evalModuleVersion;
	
	@Column(name = "EVAL_FUNC_NM")
	private String evalFunctionName;
	
	@Column(name = "DEL_YN")
	private String deleteFlag;
	
	@Column(name = "REG_USR_ID")
	private String registorUserID;
		
	@Column(name = "REG_DTIME") 
	private Date registeTime;
	 
}
