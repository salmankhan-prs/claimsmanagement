package com.cognizant.policymicroservice;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class PolicymicroserviceApplicationTests {
	@Mock
	PolicymicroserviceApplication policymicroserviceApplication;

	@Test
	void contextLoads() {
		assertNotNull(policymicroserviceApplication);
	}
	

}
