package com.securityia.api_analyze_docs.domain.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.securityia.api_analyze_docs.domain.api.dto.ContractAnalysisResultDto;
import com.securityia.api_analyze_docs.domain.service.ContractAnalysisResultService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/contract-analysis-results")
public class ContractAnalysisResultController {
	
	private final ContractAnalysisResultService contractAnalysisResultService;
	
	@PostMapping("/analyze")
	public ResponseEntity<ContractAnalysisResultDto> analyze(@PathVariable MultipartFile document) {
		ContractAnalysisResultDto result = contractAnalysisResultService.analyze(document);
		return ResponseEntity.ok(result);
	}

}
