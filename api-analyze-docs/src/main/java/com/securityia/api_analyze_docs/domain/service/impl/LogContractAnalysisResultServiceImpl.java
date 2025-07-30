package com.securityia.api_analyze_docs.domain.service.impl;

import org.springframework.stereotype.Service;

import com.securityia.api_analyze_docs.domain.model.LogContractAnalysisResult;
import com.securityia.api_analyze_docs.domain.service.LogContractAnalysisResultService;
import com.securityia.api_analyze_docs.infrastructure.repository.LogContractAnalysisResultRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class LogContractAnalysisResultServiceImpl implements LogContractAnalysisResultService {
	
	private final LogContractAnalysisResultRepository logContractAnalysisResultRepository;
	
	@Override
	public void saveLog(LogContractAnalysisResult logContractAnalysisResult) {
		log.info("Saving log for contract analysis result: {}", logContractAnalysisResult);
		logContractAnalysisResultRepository.saveAndFlush(logContractAnalysisResult);
	}

}
