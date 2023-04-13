package com.loan.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.model.ApplicantDetails;
import com.loan.model.Installments;
import com.loan.repository.ApplicantDetailsRepository;
import com.loan.repository.InstallmentRepo;
import com.loan.service.InstallmentServiceInter;
@Service
public class InstallmentServiceImpl implements InstallmentServiceInter{

	@Autowired
	private InstallmentRepo installmentRepo;
	
	@Autowired
	private ApplicantDetailsRepository applicantDetailsRepository;

	@Override
	public Optional<ApplicantDetails> findById(int applicantId) {
		
		Optional<ApplicantDetails> optional = applicantDetailsRepository.findByApplicantId(applicantId);
		
		return optional;
	}

	@Override
	public ApplicantDetails saveInstallment(ApplicantDetails applicantDetails) {
		
		Integer totalNumberOfEmi = (int) (applicantDetails.getSanctionLetter().getLoanTenure()*12);
				
		Optional<ApplicantDetails> applicant = applicantDetailsRepository.findByApplicantId(applicantDetails.getApplicantId());
		
		Optional<Installments> installment = installmentRepo.findById(applicantDetails.getInstallments().getInstallmentId());
		
		Double totalPayableAmountWithIntrest = ((applicant.get().getSanctionLetter().getMonthlyEmiAmount())*(totalNumberOfEmi));
		
		
			
			if(installment.isEmpty())
		{
				
				System.out.println("in IF");
				applicantDetails.getInstallments().setInstallmentNumber(1);
				
				int numberOfEmiRecived = (applicantDetails.getInstallments().getInstallmentNumber());
				int numberOfEmisRemaining = (totalNumberOfEmi) - (applicantDetails.getInstallments().getInstallmentNumber());
				Double totalRemainingAmount = ((totalPayableAmountWithIntrest)-(applicantDetails.getSanctionLetter().getMonthlyEmiAmount()));
				
				applicantDetails.getInstallments().setTotalNumberOfEmis(totalNumberOfEmi);
				applicantDetails.getInstallments().setNumberOfEmiRecived(numberOfEmiRecived);
				applicantDetails.getInstallments().setInstallmentStatus("Active");
				applicantDetails.getInstallments().setNumberOfEmiRemaining(numberOfEmisRemaining);
				applicantDetails.getInstallments().setTotalRemaningLoanAmountToBePaid(totalRemainingAmount);
		}
			
			else
		{
				System.out.println("In Else");
				
				int numberOfInstallment = (installment.get().getInstallmentNumber())+1;
				int numberOfEmiRecived = numberOfInstallment;
				int numberOfEmisRemaining = ((totalNumberOfEmi) - (numberOfInstallment));
				
				Double totalRemainingAmount =(installment.get().getTotalRemaningLoanAmountToBePaid())-(applicantDetails.getSanctionLetter().getMonthlyEmiAmount());
				
				applicantDetails.getInstallments().setTotalNumberOfEmis(totalNumberOfEmi);
				applicantDetails.getInstallments().setInstallmentNumber(numberOfInstallment);
				applicantDetails.getInstallments().setNumberOfEmiRecived(numberOfEmiRecived);
				applicantDetails.getInstallments().setInstallmentStatus("Active");
				applicantDetails.getInstallments().setNumberOfEmiRemaining(numberOfEmisRemaining);
				applicantDetails.getInstallments().setTotalRemaningLoanAmountToBePaid(totalRemainingAmount);
				
				if(totalRemainingAmount == 0)
			{
					
				if(numberOfInstallment == totalNumberOfEmi)
					{
					
					applicantDetails.getInstallments().setInstallmentStatus("LoanSettedled");
					
					}
				else
					{
					
					applicantDetails.getInstallments().setInstallmentStatus("Active");
					
					}
					
					
			}
				else
			{
					
					applicantDetails.getInstallments().setInstallmentStatus("Active");
					
			}
						
		}
			
			return applicantDetailsRepository.save(applicantDetails);
		
		
		
	}

	@Override
	public List<Installments> getAllInstallmentDetails() {

		List<Installments> list = installmentRepo.findAll();
		
		return list;
	}

	
	  @Override
	  public List<Installments> getLoansetteled() {
	  
	  return installmentRepo.findAllByInstallmentStatus("LoanSettedled"); 
	  
	  }
	 
	
	
}
