package com.securityia.api_analyze_docs.infrastructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.securityia.api_analyze_docs.domain.model.ContractAnalysisResult;

public interface ContractAnalysisResultRepository extends JpaRepository<ContractAnalysisResult, UUID> {
	// This interface will automatically inherit methods for CRUD operations
	// from JpaRepository, such as save, findById, findAll, deleteById, etc.

}
