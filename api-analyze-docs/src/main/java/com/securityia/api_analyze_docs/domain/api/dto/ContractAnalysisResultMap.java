package com.securityia.api_analyze_docs.domain.api.dto;

import org.mapstruct.Mapper;

import com.securityia.api_analyze_docs.domain.model.ContractAnalysisResult;

@Mapper(componentModel = "spring")
public interface ContractAnalysisResultMap {

		ContractAnalysisResultDto toDto(ContractAnalysisResult contractAnalysisResult);
		
}
