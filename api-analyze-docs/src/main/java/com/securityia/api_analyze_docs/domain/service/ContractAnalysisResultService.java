package com.securityia.api_analyze_docs.domain.service;

import org.springframework.web.multipart.MultipartFile;

import com.securityia.api_analyze_docs.domain.api.dto.ContractAnalysisResultDto;

public interface ContractAnalysisResultService {
	
	ContractAnalysisResultDto analyze(MultipartFile contrato);

}
