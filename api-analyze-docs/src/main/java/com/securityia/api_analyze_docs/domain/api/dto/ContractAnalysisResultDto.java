package com.securityia.api_analyze_docs.domain.api.dto;

import java.util.List;

import com.securityia.api_analyze_docs.domain.enums.StatusEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContractAnalysisResultDto {

	private StatusEnum status;
	private List<String> missingClauses;
	private boolean riskIsHigh;
}
