package com.ers.ERSystem;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ers.service.UserService;

public class AppTest {
	
	static UserService us;
	
	@BeforeClass
	public static void beforeAll() {
		us = new UserService();
	}

    @Test
    public void testVerifyManagerCredientials() throws Exception {
    	assertEquals(1, us.verifyLoginCredientials("manager", "pass1234"));
    }
    
    @Test
    public void testVerifyEmployeeCredientials() throws Exception {
    	assertEquals(2, us.verifyLoginCredientials("staremployee", "starenter"));
    }
    
    @Test
    public void testInvalidCredientials() throws Exception {
    	assertEquals(-1, us.verifyLoginCredientials("hackman", "abracadabra"));
    }
}
