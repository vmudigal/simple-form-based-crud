package com.mudigal.talentmanagement.service;

import java.util.List;

import com.mudigal.talentmanagement.transfer.CandidateDetailsTO;

/***********************************
*
* @author Vijayendra Mudigal
* @contact vijayendrap@gmail.com
*
**********************************/

public interface CandidateService {
	
	boolean saveCandidateDetails (CandidateDetailsTO candidateDetailsTO);
	
	List<CandidateDetailsTO> getAllCandidatesForOnBoarding();

}
