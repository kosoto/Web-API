package com.rest.api.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ListResult<T> extends CommonResult {
	private Iterable<T> list;
}
