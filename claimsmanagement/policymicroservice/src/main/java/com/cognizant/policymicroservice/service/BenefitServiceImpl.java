package com.cognizant.policymicroservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.policymicroservice.exception.PolicyNotFoundException;
import com.cognizant.policymicroservice.model.Benefits;
import com.cognizant.policymicroservice.model.MemberPolicy;
import com.cognizant.policymicroservice.repository.BenefitRepo;
import com.cognizant.policymicroservice.repository.MemberPolicyRepo;

@Service
public class BenefitServiceImpl implements BenefitService {
	@Autowired
	private BenefitRepo benefitRepo;
	@Autowired
	private MemberPolicyRepo memberPolicyRepo;

	@Override
	public List<Benefits> getEligibleBenefits(int policyId, int memberId) throws PolicyNotFoundException{
		List<MemberPolicy> providers;
		List<Benefits> benefitDetails;
		if(memberPolicyRepo.existsByPolicyIdAndMemberId(policyId,memberId)) {
		providers= memberPolicyRepo.findAllByPolicyIdAndMemberId(policyId, memberId);

		benefitDetails = new ArrayList<Benefits>();
		for (MemberPolicy memberPolicy : providers) {
			benefitDetails.add(getBenefitId(memberPolicy.getBenefitId()));

		}
		}
		else {
			throw new PolicyNotFoundException("Please provide all the valid details");
		}
		return benefitDetails;
	}
	
	public Benefits getBenefitId(int benefitId) {
		return benefitRepo.findByBenefitId(benefitId);
	}

}
