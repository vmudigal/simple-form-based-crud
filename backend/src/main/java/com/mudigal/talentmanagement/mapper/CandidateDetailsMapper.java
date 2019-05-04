package com.mudigal.talentmanagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mudigal.talentmanagement.domain.CandidateDetails;
import com.mudigal.talentmanagement.transfer.CandidateDetailsTO;

/***********************************
*
* @author Vijayendra Mudigal
* @contact vijayendrap@gmail.com
*
**********************************/

@Mapper(componentModel = "spring")
public interface CandidateDetailsMapper {

	CandidateDetailsMapper INSTANCE = Mappers.getMapper(CandidateDetailsMapper.class);

	CandidateDetails getCandidateDetails(CandidateDetailsTO candidateDetailsTO);
	
	CandidateDetailsTO getCandidateDetailsTO(CandidateDetails candidateDetails);

}
