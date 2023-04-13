package com.loan.serviceImpl;
import java.util.List;
import java.util.Optional;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loan.CustomException.InvalidApplicantId;
import com.loan.CustomException.InvalidePanNumber;
import com.loan.model.ApplicantDetails;
import com.loan.model.Document;
import com.loan.repository.ApplicantDetailsRepository;
import com.loan.service.ApplicantDetailsService;

@Service
public class ApplicantDetailsServiceimpl implements ApplicantDetailsService {
	@Autowired
	ApplicantDetailsRepository adr;

	@Override
	public ApplicantDetails saveDocumentDetail(MultipartFile adharCard, MultipartFile panCard,
			MultipartFile cancelledCheque, MultipartFile passbook, MultipartFile signature, MultipartFile photo,
			MultipartFile quotation, String applicationJson) {

		ObjectMapper mapper = new ObjectMapper();
		try {
			ApplicantDetails appli = mapper.readValue(applicationJson, ApplicantDetails.class);
  Document doc=new Document();
			doc.setAdharCard(new String(Base64.encodeBase64(adharCard.getBytes())));
			doc.setPanCard(new String(Base64.encodeBase64(panCard.getBytes())));
			doc.setCancelledCheque(new String(Base64.encodeBase64(cancelledCheque.getBytes())));
			doc.setPassbook(new String(Base64.encodeBase64(passbook.getBytes())));
			doc.setSignature(new String(Base64.encodeBase64(signature.getBytes())));
			doc.setPhoto(new String(Base64.encodeBase64(photo.getBytes())));
			doc.setQuotation(new String(Base64.encodeBase64(quotation.getBytes())));
       
			appli.setDocument(doc);
			return adr.save(appli);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Iterable<ApplicantDetails> getDocumentDetails() {
		
		return adr.findAll();
	}

	@Override
	public ApplicantDetails getDocumentById(Integer applicantId) {
	 Optional<ApplicantDetails> applicant=adr.findByApplicantId(applicantId);
		if(applicant.isPresent()) {
			return applicant.get();
		}
		else{
			
			throw new InvalidApplicantId("invalid Applicant Id");
		}
		
	}

	@Override
	public ApplicantDetails findByApplicantpanno(String applicationPanno) {
		
		Optional<ApplicantDetails>pan=adr.findByApplicationPanno(applicationPanno);
		if(pan.isPresent())
		{
			return pan.get();
		}
		else {
			throw new InvalidePanNumber("invalide Applicant pan number");
		}
	}

	@Override
	public ApplicantDetails updateDocument(MultipartFile adharCard, MultipartFile panCard,
			MultipartFile cancelledCheque, MultipartFile passbook, MultipartFile signature, MultipartFile photo,
			MultipartFile quotation, String applicationJson) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			ApplicantDetails appli = mapper.readValue(applicationJson, ApplicantDetails.class);
  Document doc=new Document();
			doc.setAdharCard(new String(Base64.encodeBase64(adharCard.getBytes())));
			doc.setPanCard(new String(Base64.encodeBase64(panCard.getBytes())));
			doc.setCancelledCheque(new String(Base64.encodeBase64(cancelledCheque.getBytes())));
			doc.setPassbook(new String(Base64.encodeBase64(passbook.getBytes())));
			doc.setSignature(new String(Base64.encodeBase64(signature.getBytes())));
			doc.setPhoto(new String(Base64.encodeBase64(photo.getBytes())));
			doc.setQuotation(new String(Base64.encodeBase64(quotation.getBytes())));
       
			appli.setDocument(doc);
			return adr.save(appli);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public void deleteData(int applicantId) {
		adr.deleteById(applicantId);
		
	}
	
	@Override
	public ApplicantDetails updateStatus(ApplicantDetails applicant) {
		applicant.setApplicantStatus("WaitingforApproval");
		ApplicantDetails update=adr.save(applicant);
		return update;
	}

	@Override
	public List<ApplicantDetails> getwaitingforapproval(String applicantStatus) {
		List<ApplicantDetails> applicant=adr.findByApplicantStatus(applicantStatus);
		return applicant;
	}

	@Override
	public ApplicantDetails verifystatusbyoe(ApplicantDetails applicant) {
		applicant.setApplicantStatus("ApplicationVerified");
		ApplicantDetails verifyupdate=adr.save(applicant);
		return verifyupdate;
	}

	@Override
	public List<ApplicantDetails> getApprovebyOE(String applicantStatus) {
		List<ApplicantDetails> verifiedapp=adr.findByApplicantStatus(applicantStatus);
		return verifiedapp;
	}

	@Override
	public ApplicantDetails rejectbyoe(ApplicantDetails applicant) {
		applicant.setApplicantStatus("ApplicationReject");
		ApplicantDetails rejectapplication=adr.save(applicant);
		return rejectapplication;
	}



}

