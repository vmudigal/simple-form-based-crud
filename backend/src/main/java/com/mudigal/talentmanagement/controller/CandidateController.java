package com.mudigal.talentmanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mudigal.talentmanagement.service.CandidateService;
import com.mudigal.talentmanagement.transfer.CandidateDetailsTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/***********************************
*
* @author Vijayendra Mudigal
* @contact vijayendrap@gmail.com
*
**********************************/

@RestController
@Api(tags = { "Candidate Onboarding" })
@RequestMapping("/candidate/onboarding/")
public class CandidateController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CandidateController.class);
	
	@Autowired
	private CandidateService candidateService;

	@PostMapping("register")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(notes = "Register a new candidate", value = "Register candidate",
		nickname = "registerCandidate", tags = {"Candidate Onboarding" })
	public boolean registerCandidate(@Valid @RequestBody CandidateDetailsTO candidateDetailsTO) {
		System.out.println(candidateDetailsTO);
		LOGGER.info("Transferred candidate details: ",candidateDetailsTO);
		return candidateService.saveCandidateDetails(candidateDetailsTO);
	}
	
	@GetMapping("list")
	@ApiOperation(notes = "Get candidates list who are supposed be onboarded", value = "Get candidates list", 
	    nickname = "getCandidatesList", tags = {"Candidate Onboarding" })
	public List<CandidateDetailsTO> getPersonsForAutoComplete() {
		return candidateService.getAllCandidatesForOnBoarding();
	}

}