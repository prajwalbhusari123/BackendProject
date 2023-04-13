package com.loan.service;

import org.springframework.web.multipart.MultipartFile;

import com.loan.model.EmailId;
import com.loan.model.SanctionLetter;

public interface EmailService {



	String sendSimpleMail(int enquiryId);

	//String sendMailWithAttachment(MultipartFile attachment, int applicantId);

	String sendRejectMail(int enquiryId);

	String sanctionmail(int sid ,SanctionLetter sanctionLetter);

	

}
