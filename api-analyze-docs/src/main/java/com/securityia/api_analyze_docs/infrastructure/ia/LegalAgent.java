package com.securityia.api_analyze_docs.infrastructure.ia;

import com.securityia.api_analyze_docs.domain.model.ContractAnalysisResult;

import dev.langchain4j.service.UserMessage;

public interface LegalAgent {

	/**
	 * Analyzes the provided text and returns a ContractAnalysisResult.
	 *
	 * @param text The text to analyze.
	 * @return A ContractAnalysisResult containing the analysis results.
	 */
	@UserMessage("""
					    You are a legal analyst. Evaluate the contract below and:
			1. Check for the presence of SLA, penalty, confidentiality, and termination clauses.
			2. Classify: COMPLIANT, PARTIALLY COMPLIANT, NON-COMPLIANT.
			3. Generate an executive summary.
			4. List missing clauses.
			5. Assess whether the legal risk is high.

			Contract:
			{{it}}
					    """)
	ContractAnalysisResult analyze(String text);
}
