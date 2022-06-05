package com.goodee.ex05.service;

import java.util.List;
import java.util.Map;

import com.goodee.ex05.domain.ProductDTO;

public interface ProductService {
	public List<ProductDTO> list1();
	public List<Map<String, Object>> list2();	// map의 key값은 칼럼이름, value값은 저장되는 데이터타입(여러가지라서 Object)
	public List<ProductDTO> list3();
}
