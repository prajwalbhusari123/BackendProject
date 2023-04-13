package com.loan.serviceImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.loan.model.ApplicantDetails;
import com.loan.model.SanctionLetter;
import com.loan.repository.ApplicantDetailsRepository;
import com.loan.repository.SanctionLetterRepository;
import com.loan.service.SanctionLetterService;
@Service
public class SanctionLetterServiceImpl implements SanctionLetterService{
	@Autowired
	SanctionLetterRepository sanctionLetterRepository;
	
	@Autowired
	ApplicantDetailsRepository applicantDetailsRepository;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String fromEmailId;
	
	String filePath="C:/Users/prajw/OneDrive/Desktop/sun.pdf";
	
	@Autowired
	ApplicantDetailsRepository adr;
	
	@Override	
	public SanctionLetter saveData(SanctionLetter sanctionLetter) {
//		Random random=new Random();
//	int	randomnumber=random.nextInt(999999);
//	sanctionLetter.setLoanApplicatioNumber(randomnumber);
//		sanctionLetter.setStatus("SantionLetterGenrated");
//		SanctionLetter sl=sanctionLetterRepository.save(sanctionLetter);
//		
	     return  null;
	}
	@Override
	public Iterable<SanctionLetter> getData() {
		Iterable<SanctionLetter>sanctionletter=sanctionLetterRepository.findAll();
		return sanctionletter;
	}

	
	@Override
	public List<SanctionLetter> getbystatus(String status) {
		List<SanctionLetter> sanlist=sanctionLetterRepository.findByStatus(status);
		return sanlist;
	}
	@Override
	public SanctionLetter getbyid(Integer sid) {
		Optional<SanctionLetter> sl=sanctionLetterRepository.findBySid(sid);
		return   sl.get();
	}
	@Override
	public SanctionLetter sanctionstatuschange(SanctionLetter sanctionLetter) {
		sanctionLetter.setStatus("SanctionLetterSent");
	
		return sanctionLetterRepository.save(sanctionLetter);
	}
	@Override
	public SanctionLetter loandisbursestatusinsactionletter(SanctionLetter sanctionLetter) {
		sanctionLetter.setStatus("LoanDisburse");
		
		return sanctionLetterRepository.save(sanctionLetter);
	}
	@Override
	public ApplicantDetails saveSanctionLetter(ApplicantDetails applicantDetails) {
		Random random  = new Random();
		applicantDetails.getSanctionLetter().setLoanApplicatioNumber(random.nextInt(99999));
		applicantDetails.getSanctionLetter().setStatus("SantionLetterGenrated");
		return applicantDetailsRepository.save(applicantDetails);
	}
	
	@Override
	public Optional<ApplicantDetails> findById(int applicantId) {

		Optional<ApplicantDetails> findByIdOptional = applicantDetailsRepository.findById(applicantId);
		
		return findByIdOptional ;
	}
	@Override
	public String sendMailWithAttachment(Integer sanctionId) {

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		Optional<SanctionLetter> sanctionLetter = sanctionLetterRepository.findById(sanctionId);
		MimeMessageHelper mimeMessageHelper;
		if (sanctionLetter.isPresent()) {
			SanctionLetter sanctionLetter2 = sanctionLetter.get();
			byte[] pdf = sanctionLetter2.getPdfDocument();
			File file = new File(filePath);

			try {
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write(pdf);
				fileOutputStream.close();

				mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
				mimeMessageHelper.setFrom(fromEmailId);
				mimeMessageHelper.setTo(sanctionLetter.get().getApplicantEmailId());
				mimeMessageHelper.setText("Hello "+sanctionLetter.get().getApplicantFname()+" "+sanctionLetter.get().getApplicantLname()+","+"\nPlease go through the Attached Sanction Letter of your applied Loan,and please share the Signed copy with our Relationship Executive\n\n\n\nThank you,\nRegards,\n Car Loan Ware House.");
				mimeMessageHelper.setSubject("Sanction Letter for Applied Loan");


				mimeMessageHelper.addAttachment(filePath, file);

				javaMailSender.send(mimeMessage);



				sanctionLetterRepository.save(sanctionLetter2);

				return "Mail Send Successfully...!";
			} catch (Exception e) {
				e.printStackTrace();
				return "Error while sending mail..!";
			}
		} else {
			return "Customer Not Available...!";
		}
	}
}
	


