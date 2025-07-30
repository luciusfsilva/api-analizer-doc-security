package com.securityia.api_analyze_docs.domain.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.securityia.api_analyze_docs.domain.api.dto.ContractAnalysisResultDto;
import com.securityia.api_analyze_docs.domain.api.dto.ContractAnalysisResultMap;
import com.securityia.api_analyze_docs.domain.enums.StatusEnum;
import com.securityia.api_analyze_docs.domain.model.ContractAnalysisResult;
import com.securityia.api_analyze_docs.domain.model.LogContractAnalysisResult;
import com.securityia.api_analyze_docs.domain.service.ContractAnalysisResultService;
import com.securityia.api_analyze_docs.domain.service.LogContractAnalysisResultService;
import com.securityia.api_analyze_docs.infrastructure.ia.LegalAgent;
import com.securityia.api_analyze_docs.infrastructure.pdf.PdfTextExtractor;
import com.securityia.api_analyze_docs.infrastructure.repository.ContractAnalysisResultRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ContractAnalysisResultServiceImpl implements ContractAnalysisResultService{
	
	private final PdfTextExtractor extractor;
    private final LegalAgent legalAgent;
    private final ContractAnalysisResultRepository contractAnalysisResultRepository;
    private final LogContractAnalysisResultService logContractAnalysisResulService;
    private final ContractAnalysisResultMap contractAnalysisResultMap;

    @Override
	public ContractAnalysisResultDto analyze(MultipartFile contrato) {
		log.info("Starting analysis for contract: {}", contrato.getOriginalFilename());
		String text = extractor.extractText(contrato);
		ContractAnalysisResult result = legalAgent.analyze(text);
		log.info("Analysis result: {}", result);
		if (result != null) {
			contractAnalysisResultRepository.saveAndFlush(result);
			log.info("Analysis result saved successfully");
			logContractAnalysisResulService.saveLog(
					LogContractAnalysisResult
					.addLogContractAnalysisResult( 
							StatusEnum.COMPLIANT, 
							"SAVE", 
							LocalDateTime.now()));
			return contractAnalysisResultMap.toDto(result);
		} else {
			log.warn("No analysis result returned from legal agent");
			throw new RuntimeException("Analysis failed, no result returned from legal agent");
		}
	}

}
