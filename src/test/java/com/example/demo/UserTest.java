package com.example.demo;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.Validation;
import javax.validation.Validator;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

public class UserTest {

    @Test
    void test()
    {
        assertTrue("labas".equals("labas"));
    }
}
