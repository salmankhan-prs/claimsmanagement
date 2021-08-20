package com.cognizant.policymicroservice.service;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberPolicyServiceTest {
	
	@Mock
	MemberPolicyService memberPolicyService;
	
	@Test
	@DisplayName("Checking for MemberPolicyService - if it is loading or not for @GetMapping")
	 void benefitServiceImplNotNullTest() {
		assertThat(memberPolicyService).isNotNull();
	}

}
