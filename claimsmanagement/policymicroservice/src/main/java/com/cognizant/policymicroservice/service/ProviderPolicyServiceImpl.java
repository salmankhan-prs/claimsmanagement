package com.cognizant.policymicroservice.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.policymicroservice.exception.PolicyNotFoundException;
import com.cognizant.policymicroservice.model.ProviderPolicy;
import com.cognizant.policymicroservice.repository.ProviderPolicyRepo;

@Service
public class ProviderPolicyServiceImpl implements ProviderPolicyService {
	@Autowired
	ProviderPolicyRepo providerPolicyRepo;

	@Override
	public ProviderPolicy setProviderPolicy(ProviderPolicy provider) {
		
		return providerPolicyRepo.save(provider);
	}

	@Override
	public List<ProviderPolicy> getChainOfProviders(int policyId) throws PolicyNotFoundException{
		List<ProviderPolicy> listofproviders = null;
		if(providerPolicyRepo.existsByPolicyId(policyId)) {
		listofproviders=providerPolicyRepo.findAllByPolicyIdOrderByLocation(policyId);}
		else {
			throw new PolicyNotFoundException("Please provide all the valid details");
		}
		return listofproviders;
	}

	

}
