package com.securityia.api_analyze_docs.infrastructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.securityia.api_analyze_docs.domain.model.LogContractAnalysisResult;

public interface LogContractAnalysisResultRepository extends JpaRepository<LogContractAnalysisResult, UUID> {

	// Custom query methods can be defined here if needed
	// For example, to find logs by a specific field:
	// List<LogContractAnalysisResult> findBySomeField(String someField);

}
