package com.securityia.api_analyze_docs.domain.model;

import java.time.LocalDateTime;

import com.securityia.api_analyze_docs.domain.enums.StatusEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "log_contract_analysis_results")
public class LogContractAnalysisResult extends BaseModel {
	
	@Enumerated(EnumType.STRING)
	private StatusEnum status;
	private String transaction;
	private LocalDateTime timestamp;
	
	public static LogContractAnalysisResult addLogContractAnalysisResult(StatusEnum compliant, String transaction, LocalDateTime timestamp) {
		LogContractAnalysisResult result = new LogContractAnalysisResult();
		result.status = compliant;
		result.transaction = transaction;
		result.timestamp = timestamp;
		return result;
	}


}
