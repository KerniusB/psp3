package com.example.demo;

import com.example.demo.model.CashRegister;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.Validation;
import javax.validation.Validator;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CashRegisterTests {

	@Autowired
	protected Validator validator;

	@BeforeClass
	public void setupValidatorInstance()
	{
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	@Test
	void testConstructor()
	{
		CashRegister cashRegister = new CashRegister(1l, "maxima");
		assertAll("Test CashRegister constructor",
				() -> assertEquals(1L, cashRegister.getId()),
				() -> assertEquals("maxima", cashRegister.getShopName())
		);
	}

	@Test
	void testSetGetShopName()
	{
		CashRegister cashRegister = new CashRegister();
		cashRegister.setShopName("lidl");
		assertTrue("lidl".equals(cashRegister.getShopName()));
	}
}
