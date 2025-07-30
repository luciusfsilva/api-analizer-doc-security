package com.securityia.api_analyze_docs.domain.model;

import java.util.ArrayList;
import java.util.List;

import com.securityia.api_analyze_docs.domain.enums.StatusEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "contract_analysis_results")
@Getter
@Setter(value = AccessLevel.PRIVATE)
public class ContractAnalysisResult extends BaseModel {
	
	@Enumerated(EnumType.STRING)
	private StatusEnum status;
	@Column(length = 1000)
	private String executiveSummary;
	private List<String> missingClauses = new ArrayList<>();
	private boolean riskIsHigh;
	
	protected ContractAnalysisResult addContractAnalysisResult(ContractAnalysisResult contractAnalysisResult) {
		ContractAnalysisResult result = new ContractAnalysisResult();
		result.id = contractAnalysisResult.id;
		result.status = contractAnalysisResult.status;
		result.executiveSummary = contractAnalysisResult.executiveSummary;
		result.missingClauses = contractAnalysisResult.missingClauses;
		result.riskIsHigh = contractAnalysisResult.riskIsHigh;
		return result;
	}
	
	

}
