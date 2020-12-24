package com.onebill.productbilling.junit.testcontrollers;

import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.onebill.productbilling.dto.ProductDto;
import com.onebill.productbilling.service.ProductService;

public class TestService {

	@Autowired
	private ProductService service;
	
	
	@Test
	public void testAddProductWithNull() {
		ProductDto dto = new ProductDto();
		assertNull(service.addProduct(dto));
	}
}
