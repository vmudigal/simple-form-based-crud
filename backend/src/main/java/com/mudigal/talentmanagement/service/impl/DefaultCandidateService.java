package com.mudigal.talentmanagement.service.impl;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.atlassian.jira.rest.client.api.IssueRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.input.IssueInput;
import com.atlassian.jira.rest.client.api.domain.input.IssueInputBuilder;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import com.mudigal.talentmanagement.domain.CandidateDetails;
import com.mudigal.talentmanagement.mapper.CandidateDetailsMapper;
import com.mudigal.talentmanagement.repository.CandidateRepository;
import com.mudigal.talentmanagement.service.CandidateService;
import com.mudigal.talentmanagement.transfer.CandidateDetailsTO;

/***********************************
*
* @author Vijayendra Mudigal
* @contact vijayendrap@gmail.com
*
**********************************/

@Service
@Transactional
public class DefaultCandidateService implements CandidateService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultCandidateService.class);
	
    @Autowired
    private CandidateRepository candidateRepository;
    
    @Value( "${jira.url}" )
    private String JIRA_URL;
    
    @Value( "${jira.username}" )
    private String USERNAME;
    
    @Value( "${jira.password}" )
    private String PASSWORD;
    
    // project key. ex: CMS
    private String PROJECT_KEY="";
    private Long ISSUE_TYPE=2L;

	@Override
	public boolean saveCandidateDetails(CandidateDetailsTO candidateDetailsTO) {
		try {
			candidateRepository.save(CandidateDetailsMapper.INSTANCE.getCandidateDetails(candidateDetailsTO));
			
			// if successfully saved, create a Jira Ticket via Jira Client REST API
			if(!JIRA_URL.equals("")) {
				
				JiraRestClient jiraclient = new AsynchronousJiraRestClientFactory()
					      .createWithBasicHttpAuthentication(URI.create(JIRA_URL),
					    		  USERNAME, PASSWORD);
				IssueRestClient issueClient = jiraclient.getIssueClient();
			    IssueInput newIssue = new IssueInputBuilder(
			      PROJECT_KEY, ISSUE_TYPE, candidateDetailsTO.getFirstname() + " " 
			    + candidateDetailsTO.getSurname() + " Onboarding").build();
			    String key = issueClient.createIssue(newIssue).claim().getKey();
			    LOGGER.debug("Jira issue created: " + key);

			}		    
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public List<CandidateDetailsTO> getAllCandidatesForOnBoarding() {
		List<CandidateDetails> candidatesFromDB = candidateRepository.findAll();
		return candidatesFromDB.stream().map(candidate -> CandidateDetailsMapper.INSTANCE.getCandidateDetailsTO(candidate))
				.collect(Collectors.toList());
	}

}
