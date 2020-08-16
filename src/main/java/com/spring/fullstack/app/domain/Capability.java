package com.spring.fullstack.app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Capability {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "The value should not be empty")
	@NotNull(message = "The value should not be null")
	private String techStack;
	private Integer numOfDevelopers = 0;
	private Integer numOfActualDevelopers = 0;

	public Capability(String techStack, Integer numOfDevelopers, Integer numOfActualDevelopers) {
		this.techStack = techStack;
		this.numOfDevelopers = numOfDevelopers;
		this.numOfActualDevelopers = numOfActualDevelopers;
	}

}
