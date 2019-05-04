package com.mudigal.talentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mudigal.talentmanagement.domain.CandidateDetails;

/***********************************
*
* @author Vijayendra Mudigal
* @contact vijayendrap@gmail.com
*
**********************************/

public interface CandidateRepository extends JpaRepository<CandidateDetails, String> {

}
