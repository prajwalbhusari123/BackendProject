package com.loan.serviceImpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.model.SanctionLetter;
import com.loan.repository.SanctionLetterRepository;
import com.loan.service.Pdfservice;
import com.loan.utility.PdfUtility;

@Service
public class PdfServiceImpl implements Pdfservice {

	@Autowired
	SanctionLetterRepository sRepository;
	

	@Override
	public ByteArrayInputStream PdfServiceImpl(int sid) {

		Optional<SanctionLetter> sanctionLetter = sRepository.findById(sid);

		String title = "CAR LOAN WARE HOUSE";
		String Content = "\r\n" + sanctionLetter.get().getApplicantFname() + " "
				+ sanctionLetter.get().getApplicantLname() + "\r\n"
				+ sanctionLetter.get().getApplicantMobNumber() + "\r\n" + sanctionLetter.get().getApplicantEmailId()
				+ "\r\n Related Head Office: Pune City H.O \r\n City:Pune \r\n" + "Pin Code:411052\r\n"
				+ "Car Loan WareHouse Ltd. \n Karvenagar \n"
	      		+ "Pune, Maharashtra \n India-411052\n"
				+ "Subject: Approval of loan\r\n\r\n" + "Dear "
				+ sanctionLetter.get().getApplicantFname() +" "+sanctionLetter.get().getApplicantLname()+ ",\r\n"
				+ "We are very glad to inform you that in response to your request for a bank loan in order to meet your tight financial problems, we have approved your request."
				+ "You wanted to meet your expenses. Hence, the bank has decided to approve your application of loan for Rs "
				+ sanctionLetter.get().getLoanAmountSanctioned() + ".\r\n"
				+ "We have thoroughly read and analyzed your business proposal. Our bank has concluded that your plan is perfect for you in order to run a business successfully. The business can be very profitable for you if you follow the terms and conditions. It can be beneficial for us in turn.\r\n"
				+ "The interest rate that you will have to pay on the loan will be "
				+ sanctionLetter.get().getRateOfInterest()+"%"
				+ "%. We hope that this interest rate will be good for you.  \r\n"
				+ "As discussed earlier, you will have to pay the loan back within "
				+ sanctionLetter.get().getLoanTenure()+"years"
				+ " years. Moreover, the interest rate may change depending on the duration of loan you choose.\r\n"
				+ "Please come to the bank and review the terms and conditions of the loan agreement with the bank. The terms have been completely outlined in the promissory note. You are requested to come and sign it.\r\n"
				+ "We have attached several related documents with this letter that are favorable for you. Please review the form thoroughly and return us so that the processing of loan can be done. If you have any query related to this matter, you can contact us on +91 8055422020.\r\n"
				+ "Sincerely,\r\n" + "\r\n" + "Car Loan Warehouse.!\r\n";

//		Optional<SanctionLetter> sanctionLetter =sanctionLetterRepository.findById(sanctionId);

		ByteArrayOutputStream byteArrayOutputStream = PdfUtility.createPdf(title, Content);

		byte[] pdf = byteArrayOutputStream.toByteArray();

		if (sanctionLetter.isPresent()) {
			SanctionLetter sanctionLetter2 = sanctionLetter.get();
			sanctionLetter2.setPdfDocument(pdf);

			sRepository.save(sanctionLetter2);
		}
		return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

	}
	}


