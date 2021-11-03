package com.example.demo;

import com.example.demo.model.Action;
import com.example.demo.model.CashRegister;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.Validation;
import javax.validation.Validator;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

public class ActionTest {

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
        Action action = new Action(1l, 0L, "05.25", 100);
        assertAll("Test CashRegister constructor",
                () -> assertEquals(1L, action.getId()),
                () -> assertEquals(0L, action.getInOut()),
                () -> assertEquals("05.25", action.getDate()),
                () -> assertEquals(100L, action.getAmount())
        );
    }

    @Test
    void testSetGetDate()
    {
        Action action = new Action();
        action.setDate("05.26");
        assertTrue("05.26".equals(action.getDate()));
    }
}
