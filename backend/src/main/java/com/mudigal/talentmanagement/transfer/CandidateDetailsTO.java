package com.mudigal.talentmanagement.transfer;

import lombok.Data;

/***********************************
*
* @author Vijayendra Mudigal
* @contact vijayendrap@gmail.com
*
**********************************/

@Data
public class CandidateDetailsTO {
	
	private String firstname;
	private String surname;
	private String startdate;
	private String noticeperiod;
	private String email;
	private String address;
	private String contactnumber;
	private String laptoppreference;

}
