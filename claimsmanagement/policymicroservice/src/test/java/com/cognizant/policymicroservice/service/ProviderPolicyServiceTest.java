package com.cognizant.policymicroservice.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class ProviderPolicyServiceTest {
	@Mock
	ProviderPolicyService providerPolicyService;
	
	@Test
	@DisplayName("Checking for ProviderPolicyService - if it is loading or not for @GetMapping")
	void repairServiceImplNullTest() {
		assertThat(providerPolicyService).isNull();
	}
	

}
