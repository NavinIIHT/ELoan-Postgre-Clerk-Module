package com.iiht.training.eloan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.eloan.model.LoanOutputDto;
import com.iiht.training.eloan.model.ProcessingDto;
import com.iiht.training.eloan.repository.LoanRepository;
import com.iiht.training.eloan.repository.ProcessingInfoRepository;
import com.iiht.training.eloan.repository.SanctionInfoRepository;
import com.iiht.training.eloan.repository.UsersRepository;
import com.iiht.training.eloan.service.ClerkService;

@Service
public class ClerkServiceImpl implements ClerkService {

	@Override
	public List<LoanOutputDto> allAppliedLoans() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProcessingDto processLoan(Long clerkId, Long loanAppId, ProcessingDto processingDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProcessingDto updateProcessInfo(Long clerkId, Long loanAppId, ProcessingDto processingDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LoanOutputDto> getProcessedLoanStatus(Long clerkId) {
		// TODO Auto-generated method stub
		return null;
	}

}
