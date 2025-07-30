package com.securityia.api_analyze_docs.domain.model;

import java.util.UUID;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BaseModel {

	@Id
	@EqualsAndHashCode.Include
	protected UUID id = UUID.randomUUID();
	
}
