package com.loan.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.loan.CustomException.EmailIdnotfound;
import com.loan.CustomException.InvalidMobileNumber;
import com.loan.model.Enquiry;

import com.loan.repository.EnquiryRepository;
import com.loan.service.Enquiryservice;

import net.bytebuddy.asm.Advice.Return;

@Service
public class EnquiryServiceImpl implements Enquiryservice {
	@Autowired
	EnquiryRepository hRepository;
	

	@Override
	public Enquiry postEnquiryApplication(Enquiry enquiry) {
		if (enquiry.getEnquiryMobnumber().length() == 10) {
		} else {
			throw new InvalidMobileNumber("Invalid Mobile Number...Please Enter Again..!!");
		}
		if (enquiry.getEnquiryMobnumber().startsWith("9") || enquiry.getEnquiryMobnumber().startsWith("8")
				|| enquiry.getEnquiryMobnumber().startsWith("7")) {
		} else {
			throw new InvalidMobileNumber("Mobile No start With 7 8 9!!");
		}
		if (enquiry.getEnquiryEmailid().endsWith("@gmail.com") || enquiry.getEnquiryEmailid().endsWith("@yahoo.com")) {

		} else {
			throw new EmailIdnotfound("ENTER VALID EMAIL ID...!!");
		}
//		String statusString="Pending";
//		enquiry.setEnquiryCibilStatus(statusString);
		
		Enquiry enquiry2 = hRepository.save(enquiry);
		return enquiry2;
	}

	@Override
	public Iterable<Enquiry> getEnquiryApplication() {
		Iterable<Enquiry> enquiries=hRepository.findAll();
		return enquiries;
	}

	@Override
	public Enquiry getEnquiryApplicationById(Integer enquiryId) {
		Optional<Enquiry> enquiry=hRepository.findByEnquiryId(enquiryId);
		return enquiry.get();
	}

	@Override
	public void deleteById(Integer enquiryId) {
		hRepository.deleteById(enquiryId);
		
	}

	@Override
	public Iterable<Enquiry> getcibil() {
		
		return hRepository.findByEnquiryCibilStatus("Under Cibil Check");
	}

	@Override
	public Enquiry getCibilById(Integer enquiryId) {
		Optional<Enquiry> enq=hRepository.findById(enquiryId);
		if(enq.isPresent()) {
			Enquiry enquiry=enq.get();
			return enquiry;
		}
		return null;
	}

	@Override
	public Enquiry updateEnquiryCibil(Enquiry enquiry) {
		enquiry.setEnquiryCibilStatus("Under Cibil Check");
		return hRepository.save(enquiry);
	}

	@Override
	public Enquiry updateCibilScore(Enquiry enquiry) {
		
		Random random=new Random();
		int cibilscore = random.nextInt(400, 900);
		enquiry.setEnquiryCibilScore(cibilscore);
		return hRepository.save(enquiry);
	}

	@Override
	public Enquiry cibilapprovebyoe(Enquiry enquiry) {
		enquiry.setEnquiryCibilStatus("Approved");
		return hRepository.save(enquiry);
	}

	@Override
	public List<Enquiry> getApprovebyOE(String enquiryCibilStatus) {
		return hRepository.findByEnquiryCibilStatus(enquiryCibilStatus);
	}

	@Override
	public Enquiry cibilrejectbyoe(Enquiry enquiry) {
		enquiry.setEnquiryCibilStatus("Rejected");
		return hRepository.save(enquiry);
	}
	
	
	
	
	
	
	

	


	

}
