
package com.loan.serviceImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Optional;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loan.model.ApplicantDetails;
import com.loan.model.EmailId;
import com.loan.model.Enquiry;
import com.loan.model.SanctionLetter;
import com.loan.repository.ApplicantDetailsRepository;
import com.loan.repository.EnquiryRepository;
import com.loan.repository.SanctionLetterRepository;
import com.loan.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	ApplicantDetailsRepository adr;
	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	EnquiryRepository enquiryRepository;

	@Autowired
	SanctionLetterRepository sanctionLetterRepository;

	/* String filepath ="C:/Users/prajw/OneDrive/Desktop/sun.pdf"; */

	@Value("${spring.mail.username}")
	private String fromEmailId;

	@Override
	public String sendSimpleMail(int enquiryId) {
		Optional<Enquiry> enquirydatails = enquiryRepository.findByEnquiryId(enquiryId);
		if (enquirydatails.isPresent()) {
			try {

				SimpleMailMessage mail = new SimpleMailMessage();
				mail.setFrom(fromEmailId);
				mail.setTo(enquirydatails.get().getEnquiryEmailid());
				mail.setSubject("Regards CAR LOAN WAREHOUSE.!");

				String text = "Hello \n Mr./Mrs." + enquirydatails.get().getEnquiryFname() + "    "
						+ enquirydatails.get().getEnquiryLname() + ",\n" + "\n"
						+ "Thank you for your recent loan enquiry with CAR LOAN WAREHOUSE"
						+ "This mail is to inform you that we have recived your car loan enquiry for amount "
						+ enquirydatails.get().getEnquiryLoanAmount()
						+ "for that we have checked your cibil score that is "
						+ enquirydatails.get().getEnquiryCibilScore()
						+ "As per our policy you are eligible for car loan"
						+ "In order to proceed with the loan disbursement, we require you to submit the following documents:"
						+ "Proof of identity: Aadhar card/PAN card /n" + "Proof of address:Aadhar card/PAN card  /n"
						+ "Proof of income :Salary slip/ Passbook/n"
						+ "Once we receive your documents and verify them, we will proceed with the loan disbursement process"
						+ "We are confident that you will manage your credit loan responsibly, and we look forward to your continued business.\n"
						+ "\n"
						+ "Should you have any questions about your Car loan, please do not hesitate to contact us.\n"
						+ "\n" + "Thank you for your interest in our services." + "\n \n Thanking You. \n"
						+ "Operational Executive \n" + "Car Loan WareHouse Ltd. \n Karvenagar \n"
						+ "Pune, Maharashtra \n India-411052\n" + "\n" + "Thank You For Banking With Us \n\n"
						+ "Car Loan WareHouse Ltd.....!!!!";
				mail.setText(text);

				javaMailSender.send(mail);

				return "Mail Send Successfully...!";
			} catch (Exception e) {
				e.printStackTrace();
				return "Error while sending mail..!";
			}

		} else {
			return "Customer Not Available...!";
		}
	}

	@Override
	public String sendRejectMail(int enquiryId) {
		Optional<Enquiry> enquirydatails = enquiryRepository.findByEnquiryId(enquiryId);
		if (enquirydatails.isPresent()) {
			try {

				SimpleMailMessage mail = new SimpleMailMessage();
				mail.setFrom(fromEmailId);
				mail.setTo(enquirydatails.get().getEnquiryEmailid());
				mail.setSubject("Regards CAR LOAN WAREHOUSE.!!");

				String text = "Hello \n Mr./Mrs." + enquirydatails.get().getEnquiryFname() + " "
						+ enquirydatails.get().getEnquiryLname() + ",\n" + "\n"
						+ "Thank you for your recent loan enquiry with CAR LOAN WAREHOUSE"
						+ "This mail is to inform you that we have recived your car loan enquiry for amount "
						+ enquirydatails.get().getEnquiryLoanAmount()
						+ "for that we have checked your cibil score that is "
						+ enquirydatails.get().getEnquiryCibilScore()
						+ "As per our policy you are not eligible for car loan" + "\n"
						+ "Should you have any questions about your Car loan, please do not hesitate to contact us.\n"
						+ "\n" + "Thank you for your interest in our services." + "\n \n Thanking You. \n"
						+ "Operational Executive \n" + "Car Loan WareHouse Ltd. \n Karvenagar \n"
						+ "Pune, Maharashtra \n India-411052\n" + "\n" + "Thank You For Banking With Us \n\n"
						+ "Car Loan WareHouse Ltd.....!!!!";
				mail.setText(text);

				javaMailSender.send(mail);

				return "Mail Send Successfully...!";
			} catch (Exception e) {
				e.printStackTrace();
				return "Error while sending mail..!";
			}

		} else {
			return "Customer Not Available...!";
		}
	}

	@Override
	public String sanctionmail(int sid , SanctionLetter sanctionLetter) {
		Optional<SanctionLetter > sanctiondata= sanctionLetterRepository.findBySid(sid);
		if (sanctiondata.isPresent()) {
			try {

				SimpleMailMessage mail = new SimpleMailMessage();
				mail.setFrom(fromEmailId);
				mail.setTo(sanctiondata.get().getApplicantEmailId());
				mail.setSubject("Regards CAR LOAN WAREHOUSE.!");
				
				
						
				String text="Dear \n Mr./Mrs." + sanctiondata.get().getApplicantFname() + " "
						+ sanctiondata.get().getApplicantLname()
						+ ",\n" + "\n"
						+"We are pleased to inform you that your car loan application number"+sanctiondata.get().getLoanApplicatioNumber()+"with our bank has been approved. The loan has been sanctioned for an amount of"+sanctiondata.get().getLoanAmountSanctioned() 
						+"at an interest rate of"+sanctiondata.get().getMonthlyEmiAmount()+" % per annum, for a tenure of"+ sanctiondata.get().getLoanTenure()+"years."
						+ "We have considered your credit history, income, and other relevant factors while processing your loan application. "
						+ "We are confident that this loan will help you fulfill your transportation needs and enhance your lifestyle."
						+"Please find below the terms and conditions of the car loan:"
						+"Loan Amount:"+sanctiondata.get().getLoanAmountSanctioned()
						+"Interest Rate:"+sanctiondata.get().getRateOfInterest()+"%"
						+"Loan Tenure: "+sanctiondata.get().getLoanTenure()+"years"
						+"Monthly EMI Rs"+sanctiondata.get().getMonthlyEmiAmount()
						+ "\n"
						+ "Should you have any questions about your Car loan, please do not hesitate to contact us.\n"
						+ "\n" + "Thank you for your interest in our services."
						+ "\n \n Thanking You. \n"
			      		+ "Credit Manager \n"
			      		+ "Car Loan WareHouse Ltd. \n Karvenagar \n"
			      		+ "Pune, Maharashtra \n India-411052\n"
			      		+ "\n"
			      		+ "Thank You For Banking With Us \n\n"
			      		+ "Car Loan WareHouse Ltd.....!!!!";
				mail.setText(text);
				javaMailSender.send(mail);

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


