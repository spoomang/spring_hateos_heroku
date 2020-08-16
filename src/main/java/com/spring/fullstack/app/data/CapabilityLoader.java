package com.spring.fullstack.app.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.fullstack.app.domain.Capability;
import com.spring.fullstack.app.repository.CapabilityRepository;

@Configuration
public class CapabilityLoader {
	CapabilityRepository repository;

	public CapabilityLoader(CapabilityRepository repository) {
		this.repository = repository;
	}

	@Bean
	public CommandLineRunner run() throws Exception {
		return args -> {
			repository.save(new Capability("java", 10, 5));
			repository.save(new Capability("javascript", 14, 4));
			repository.save(new Capability("react", 13, 10));
		};
	}

}
