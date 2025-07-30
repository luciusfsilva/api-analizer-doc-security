package com.securityia.api_analyze_docs.infrastructure.ia;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;

@Configuration
public class LangChainConfig {
	
	@Bean
	OpenAiChatModel openAiChatModel() {
		return OpenAiChatModel.builder()
				.apiKey(System.getenv("OPENAI_API_KEY"))
				.baseUrl("https://openrouter.ai/api/v1/")
				.modelName("mistralai/mistral-7b-instruct")
				.temperature(0.2)
				.build();

	}
	
	@Bean
	LegalAgent legalAgent(OpenAiChatModel openAiChatModel) {
		return AiServices.create(LegalAgent.class, openAiChatModel);
	}
}
